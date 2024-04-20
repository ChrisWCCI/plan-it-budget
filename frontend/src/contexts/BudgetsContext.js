<<<<<<< HEAD
=======
import React, { useContext, useEffect } from "react";
>>>>>>> origin/HEAD

 import React, { useContext } from "react";
 import { v4 as uuidV4 } from "uuid";
 import useLocalStorage from "../hooks/UseLocalStorage";

 const BudgetsContext = React.createContext();

<<<<<<< HEAD
 export const UNCATEGORIZED_BUDGET_ID = "Uncatergorized";
 export function useBudgets() {
   return useContext(BudgetsContext);
 }
=======
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
>>>>>>> origin/HEAD

 export const BudgetsProvider = ({ children }) => {
   const [budgets, setBudgets] = useLocalStorage("budgets", []);
   const [expenses, setExpenses] = useLocalStorage("expenses", []);

<<<<<<< HEAD
   function getBudgetExpenses(budgetId) {
     return expenses.filter((expense) => expense.budgetId === budgetId);
   }

   function addExpense({ description, amount, budgetId }) {
     setExpenses((prevExpenses) => {
       return [...prevExpenses, { id: uuidV4(), description, amount, budgetId }];
     });
   }

   function addBudget({ name, max }) {
     setBudgets((prevBudgets) => {
       if (prevBudgets.find((budget) => budget.name === name)) {
         return prevBudgets;
       }
       return [...prevBudgets, { id: uuidV4(), name, max }];
     });
   }

  function deleteBudget({ id }) {
     setExpenses((prevExpenses) => {
       return prevExpenses.map((expense) => {
         if (expense.budgetId !== id) return expense;
         return { ...expense, budgetId: UNCATEGORIZED_BUDGET_ID };
       });
     });
     setBudgets((prevBudgets) => {
       return prevBudgets.filter((budget) => budget.id !== id);
     });
   }

   function deleteExpense({ id }) {
     setExpenses((prevExpenses) => {
       return prevExpenses.filter((expense) => expense.id !== id);
     });
   }

   return (
     <BudgetsContext.Provider
       value={{
         budgets,
         expenses,
         getBudgetExpenses,
        addExpense,
         addBudget,
         deleteBudget,
         deleteExpense,
       }}
     >
       {children}
     </BudgetsContext.Provider>
   );
 };
=======
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
        deleteExpense,
        addBudget,
        deleteBudget,
        // other functions...
      }}
    >
      {children}
    </BudgetsContext.Provider>
  );
};
>>>>>>> origin/HEAD
