import React, { useState } from "react";

function DebtRemoveButton(id) {
  const [isOpen, setIsOpen] = useState(false);
  const removeDebt = async () => {
    fetch("http://localhost:8080/api/debts/" + id, {
      method: "DELETE",
    }).then((result) => {
      result.json().then((resp) => console.warn(resp));
    });
  };
  return (
    <>
      <button onClick={() => setIsOpen(true)}>Delete</button>
      {isOpen && (
        <div>
          <p>Are you sure you want to delete this data?</p>
          <button onClick={removeDebt}>Yes, delete it</button>
          <button onClick={() => setIsOpen(false)}>Cancel</button>
        </div>
      )}
    </>
  );
}

export default DebtRemoveButton;
