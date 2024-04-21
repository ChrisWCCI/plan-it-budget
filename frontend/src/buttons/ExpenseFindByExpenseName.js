// import React from "react";

// function ExpenseFindByExpenseNameButton({ findExpenseName }) {
//   const findByExpenseName = () => {
//     fetch("http://localhost:8080/api/expenses/expenseName/", {
//       method: "GET",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify(findExpenseName),
//     })
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error("Network response was not okay");
//         }
//         alert("Expense was found!");
//       })
//       .catch((error) => {
//         console.error("There was a problem finding the expense", error);
//       });
//   };

//   return <button onClick={findByExpenseName}>Search for expense name</button>;
// }

// export default ExpenseFindByExpenseNameButton;
