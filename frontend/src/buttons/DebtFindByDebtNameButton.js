import React from "react";

function DebtFindByDebtNameButton({ findDebtName }) {
  const findByDebtName = () => {
    fetch("http://localhost:8080/api/debts/debtName/", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(findDebtName),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not okay");
        }
        alert("Debt was removed!");
      })
      .catch((error) => {
        console.error("There was a problem removing the Debt", error);
      });
  };

  return <button onClick={findByDebtName}>Search for debt name</button>;
}

export default DebtFindByDebtNameButton;
