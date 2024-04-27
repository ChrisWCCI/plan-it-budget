import React, { useState } from "react";
import PieChart from "../components/Chart";
import "../Goals.css";
import "../App.css";

function Goals() {
  const initialGoalName = localStorage.getItem("goalName")
    ? localStorage.getItem("goalName")
    : " ";
  const initialGoalAmount = Number(localStorage.getItem("goalAmount") || 0);
  const initialTimeSpan = Number(localStorage.getItem("timeSpan") || 0);
  const initialMonthlyContribution = Number(
    localStorage.getItem("monthlyContribution") || 0
  );
  const [goalName, setGoalName] = useState(initialGoalName);
  const [goalAmount, setGoalAmount] = useState(initialGoalAmount);
  const [timeSpan, setTimeSpan] = useState(initialTimeSpan);
  const [monthlyContribution, setMonthlyContribution] = useState(
    initialMonthlyContribution
  );

  const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 2,
  });
  const calculateTotalSavings = () => {
    return monthlyContribution * timeSpan;
  };

  return (
    <>
      <div className="Goals">
        <h1>Goal Calculator</h1>
        <h3 id="goalMonths">
          You will reach your goal in:{" "}
          {goalAmount !== 0 && monthlyContribution !== 0
            ? goalAmount / monthlyContribution
            : "0"}{" "}
          Months
        </h3>
        <p id="totalGoal">
          Current Total Savings Based on Timeline and Contribution:
        </p>
        <strong id="dollar">{formatter.format(calculateTotalSavings())}</strong>{" "}
        <form className="goals-form">
          <label id="goalName">
            Goal Name:
            <input
              type="text"
              placeholder="Goal Name"
              value={goalName}
              onChange={(e) => setGoalName(e.target.value)}
            />
          </label>
          <label id="goalAmount">
            {" "}
            Goal Amount:
            <input
              type="number"
              placeholder="Goal Amount"
              value={goalAmount}
              onChange={(e) => {
                if (!isNaN(parseInt(e.target.value))) {
                  setGoalAmount(parseInt(e.target.value));
                } else {
                  setGoalAmount(0);
                }
              }}
            />
          </label>
          <label id="timeline">
            {" "}
            Timeline (Months):
            <input
              type="number"
              placeholder="Timeline (months)"
              value={timeSpan}
              onChange={(e) => setTimeSpan(parseInt(e.target.value))}
            />
          </label>
          <label id="monthly">
            {" "}
            Monthly Contribution:
            <input
              type="number"
              placeholder="Monthly Contribution"
              value={monthlyContribution}
              onChange={(e) => {
                if (!isNaN(parseInt(e.target.value))) {
                  setMonthlyContribution(parseInt(e.target.value));
                } else {
                  setMonthlyContribution(0);
                }
              }}
            />
          </label>
          <div
            style={{ width: "600px", height: "300px", marginleft: "20px" }}
            className="calc"
          ></div>
        </form>
      </div>

      <div>
        <PieChart />
      </div>
    </>
  );
}
export default Goals;
