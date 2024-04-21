import React, { useState, useEffect } from "react";
import "../App.css";
import "./Retirement.css";

function Retirement() {
  const initialRetirementAge = Number(
    localStorage.getItem("retirementAge") || 100
  );
  const initialTargetRetAmt = Number(localStorage.getItem("targetRetAmt") || 0);
  const initialAnnualRetExp = Number(localStorage.getItem("annualRetExp") || 0);
  const initialCurrentAge = Number(localStorage.getItem("currentAge") || 35);
  const initialCurrentSavings = Number(
    localStorage.getItem("currentSavings") || 10000
  );
  const initialContributions = Number(
    localStorage.getItem("contributions") || 500
  );
  const initialContributionFreq = Number(
    localStorage.getItem("contributionFreq") || "Monthly"
  );
  const initialPreRetROR = Number(localStorage.getItem("preRetROR") || 7);
  const initialPostRetROR = Number(localStorage.getItem("postRetROR") || 7);
  const initialInflation = Number(localStorage.getItem("inflation") || 2.9);

  const [retirementAge, setRetirementAge] = useState(initialRetirementAge);
  const [targetRetAmt, setTargetRetAmt] = useState(initialTargetRetAmt);
  const [annualRetExp, setAnnualRetExp] = useState(initialAnnualRetExp);
  const [currentAge, setCurrentAge] = useState(initialCurrentAge);
  const [currentSavings, setCurrentSavings] = useState(initialCurrentSavings);
  const [contributions, setContributions] = useState(initialContributions);
  const [contributionFreq, setContributionFreq] = useState(
    initialContributionFreq
  );
  const [preRetROR, setPreRetROR] = useState(initialPreRetROR);
  const [postRetROR, setPostRetROR] = useState(initialPostRetROR);
  const [inflation, setInflation] = useState(initialInflation);

  const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 2,
  });

  useEffect(() => {
    const calcRetirementAge = (updatedTargetRetAmt) => {
      const netPreRetROR = (preRetROR - inflation) / 100;
      let currBal = currentSavings;
      const annualCont =
        contributionFreq === "Annually" ? contributions : contributions * 12;
      let retAge = currentAge;

      while (currBal < updatedTargetRetAmt) {
        currBal = annualCont + currBal * (1 + netPreRetROR);
        retAge += 1;

        if (retAge > 200) break;
      }

      return retAge;
    };
    localStorage.setItem("retirementAge", retirementAge);
    localStorage.setItem("targetRetAmt", targetRetAmt);
    localStorage.setItem("annualRetExp", annualRetExp);
    localStorage.setItem("currentAge", currentAge);
    localStorage.setItem("currentSavings", currentSavings);
    localStorage.setItem("contributions", contributions);
    localStorage.setItem("contributionFreq", contributionFreq);
    localStorage.setItem("preRetROR", preRetROR);
    localStorage.setItem("postRetROR", postRetROR);
    localStorage.setItem("inflation", inflation);

    // AnnualRetExp <= TargetRetAmt * NetRateOfReturn
    // TargetRetAmt >= AnnualRetExp / NetRateOfReturn
    let netPostRetROR = (postRetROR - inflation) / 100;
    if (netPostRetROR === 0) netPostRetROR = 0.00001;

    let updatedTargetRetAmt = annualRetExp / netPostRetROR;
    setTargetRetAmt(updatedTargetRetAmt);

    const retAge = calcRetirementAge(updatedTargetRetAmt);
    setRetirementAge(retAge);
  }, [
    annualRetExp,
    currentAge,
    currentSavings,
    contributions,
    contributionFreq,
    preRetROR,
    postRetROR,
    inflation,
    retirementAge,
    targetRetAmt,
  ]);

  return (
    <div className="retirement">
      <h1 id="retCalc" className="mt-5">
        Retirement Calculator
      </h1>
      <h2 id="age" className="mt-3">You can retire at age {retirementAge} </h2>
      <div>
        <h3 id="target">Target Retirement Amount</h3>
        <h4 id="auto" >Auto Calculation:</h4> {formatter.format(targetRetAmt)}{" "}
      </div>
      <form className="retirement-calc-form">
        <label id="annualExpense">
          Annual retirement expenses (today's dollars)
          <input
            className="rounded ms-2"
            type="number"
            value={annualRetExp}
            onChange={(e) => setAnnualRetExp(parseInt(e.target.value))}
          />
        </label>
        <label id="currentAge">
          Current age
          <input
            className="rounded ms-2"
            type="number"
            value={currentAge}
            onChange={(e) => setCurrentAge(parseInt(e.target.value))}
          />
        </label>
        <label id="currentSavings">
          Current savings balance
          <input
            className="rounded ms-2"
            type="number"
            value={currentSavings}
            onChange={(e) => setCurrentSavings(parseInt(e.target.value))}
          />
        </label>
        <label id="contributions">
          Regular contributions
          <input
            className="rounded ms-2"
            type="number"
            value={contributions}
            onChange={(e) => setContributions(parseInt(e.target.value))}
          />
        </label>
        <label id="frequency">
          Contribution frequency
          <select className="rounded ms-2">
            <option
              value="Monthly"
              onChange={(e) => setContributionFreq(parseInt(e.target.value))}
            >
              Monthly
            </option>
            <option
              value="Annually"
              onChange={(e) => setContributionFreq(parseInt(e.target.value))}
            >
              Annually
            </option>
          </select>
        </label>
        <div>
          <h3 id="advanced" className="mt-1 mb-1">Advanced</h3>
          <label id="pre">
            Pre-retirement rate of return
            <input
              className="rounded ms-2"
              type="number"
              value={preRetROR}
              onChange={(e) => setPreRetROR(parseInt(e.target.value))}
            />
          </label>
          <label id="post">
            Post-retirement rate of return
            <input
              className="rounded ms-2"
              type="number"
              value={postRetROR}
              onChange={(e) => setPostRetROR(parseInt(e.target.value))}
            />
          </label>
          <label id="inflation">
            Inflation
            <input
              className="rounded ms-2"
              type="number"
              value={inflation}
              onChange={(e) => setInflation(parseInt(e.target.value))}
            />
          </label>
        </div>
      </form>
    </div>
  );
}

export default Retirement;
