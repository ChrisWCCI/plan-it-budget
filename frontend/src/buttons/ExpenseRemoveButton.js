// import React, { useState } from "react";

// function ExpenseRemoveButton(id) {
//   const [isOpen, setIsOpen] = useState(false);
//   const removeExpense = async () => {
//     fetch("http://localhost:8080/api/expenses/" + id, {
//       method: "DELETE",
//     }).then((result) => {
//       result.json().then((resp) => console.warn(resp));
//     });
//   };
//   return (
//     <>
//       <button onClick={() => setIsOpen(true)}>Delete</button>
//       {isOpen && (
//         <div>
//           <p>Are you sure you want to delete this data?</p>
//           <button onClick={removeExpense}>Yes, delete it</button>
//           <button onClick={() => setIsOpen(false)}>Cancel</button>
//         </div>
//       )}
//     </>
//   );
// }

// export default ExpenseRemoveButton;
