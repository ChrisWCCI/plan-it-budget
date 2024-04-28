import React, { useContext, useEffect, useState } from "react";

const BudgetsContext = React.createContext();

export const UNCATEGORIZED_BUDGET_ID = "Uncatergorized";
export function useBudgets() {
  return useContext(BudgetsContext);
}

export const BudgetsProvider = ({ children }) => {
  const [budgets, setBudgets] = useState([]);
  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    // Fetch budgets and expenses from the backend on component mount
    fetchBudgets();
    fetchExpenses();
  }, []);

  function fetchBudgets() {
    fetch("http://localhost:8080/api/budget")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch budgets");
        }
        return response.json();
      })
      .then((data) => {
        setBudgets(data);
      })
      .catch((error) => {
        console.error("Error fetching budgets:", error);
      });
  }

  function fetchExpenses() {
    fetch("http://localhost:8080/api/expenses")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch expenses");
        }
        return response.json();
      })
      .then((data) => {
        setExpenses(data);
      })
      .catch((error) => {
        console.error("Error fetching expenses:", error);
      });
  }

  function getBudgetExpenses(budgetId) {
    return expenses.filter((expense) => expense.budget.id === budgetId);
  }

  function addExpense({ description, chargeAmount, budgetId }) {
    fetch("http://localhost:8080/api/expenses", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        description,
        chargeAmount,
        budgetId,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to add expense");
        }
        return response.json();
      })
      .then((savedExpense) => {
        setExpenses((prevExpenses) => [...prevExpenses, savedExpense]);
      })
      .catch((error) => {
        console.error("Error adding expense:", error);
      });
  }

  function deleteExpense({ id }) {
    fetch(`http://localhost:8080/api/expenses/${id}`, {
      method: "DELETE",
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to delete expense");
        }
        setExpenses((prevExpenses) =>
          prevExpenses.filter((expense) => expense.id !== id)
        );
      })
      .catch((error) => {
        console.error("Error deleting expense:", error);
      });
  }

  function editExpense({ id, description, chargeAmount, budgetId }) {
    fetch(`http://localhost:8080/api/expenses/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        description,
        chargeAmount,
        budgetId,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to edit expense");
        }
        return response.json();
      })
      .then((editedExpense) => {
        setExpenses((prevExpenses) =>
          prevExpenses.map((expense) =>
            expense.id === id ? editedExpense : expense
          )
        );
      })
      .catch((error) => {
        console.error("Error editing expense:", error);
      });
  }

  function addBudget({ budgetName, max }) {
    fetch("http://localhost:8080/api/budget", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ budgetName, max }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to add budget");
        }
        return response.json();
      })
      .then((savedBudget) => {
        setBudgets((prevBudgets) => [...prevBudgets, savedBudget]);
      })
      .catch((error) => {
        console.error("Error adding budget:", error);
      });
  }

  function editBudget({ id, budgetName, max }) {
    fetch(`http://localhost:8080/api/budget/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        budgetName,
        max,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to edit budget");
        }
        return response.json();
      })
      .then((editedBudget) => {
        setBudgets((prevBudgets) =>
          prevBudgets.map((budget) =>
            budget.id === id ? editedBudget : budget
          )
        );
      })
      .catch((error) => {
        console.error("Error editing budget:", error);
      });
  }

  function deleteBudget({ id }) {
    fetch(`http://localhost:8080/api/budget/${id}`, {
      method: "DELETE",
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to delete budget");
        }
        setBudgets((prevBudgets) =>
          prevBudgets.filter((budget) => budget.id !== id)
        );
        setExpenses((prevExpenses) =>
          prevExpenses.filter((expense) => expense.budget.id !== id)
        );
      })
      .catch((error) => {
        console.error("Error deleting budget:", error);
      });
  }

  // other functions...

  return (
    <BudgetsContext.Provider
      value={{
        budgets,
        expenses,
        getBudgetExpenses,
        addExpense,
        editExpense,
        deleteExpense,
        editBudget,
        addBudget,
        deleteBudget,
        // other functions...
      }}
    >
      {children}
    </BudgetsContext.Provider>
  );
};
