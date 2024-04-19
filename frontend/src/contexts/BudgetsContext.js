import React, { useContext, useEffect } from "react";

const BudgetsContext = React.createContext();

export const UNCATEGORIZED_BUDGET_ID = "Uncatergorized";
export function useBudgets() {
  return useContext(BudgetsContext);
}

export const BudgetsProvider = ({ children }) => {
  const [budgets, setBudgets] = React.useState([]);
  const [expenses, setExpenses] = React.useState([]);

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

  function fetchExpenses() {}

  function getBudgetExpenses(budgetId) {
    return expenses.filter((expense) => expense.budgetId === budgetId);
  }

  function addExpense({ description, expenseName, chargeAmount, budgetId }) {
    fetch("http://localhost:8080/api/expenses", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        description,
        expenseName,
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
        addBudget,
        deleteBudget,
        // other functions...
      }}
    >
      {children}
    </BudgetsContext.Provider>
  );
};
