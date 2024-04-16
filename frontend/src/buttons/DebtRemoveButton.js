import React, { useState } from "react";
import axios from "axios";

function DebtRemoveButton({ debtRemove }) {
  const [isOpen, setIsOpen] = useState(false);
  const removeDebt = async (debtName) => {
    try {
      const response = await axios.delete(
        "http://localhost:8080/api/debts/{id}"
      );
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
    setIsOpen(false);
  };

  return <button onClick={removeDebt}>Remove Debt</button>;
}

export default DebtRemoveButton;
