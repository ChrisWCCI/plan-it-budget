import React, { useState, useEffect } from "react";
import "../App.css";

function Retirement() {
  const initialRetirementAge = 0;
  const initialTargetRetAmt = 0;
  const initialAnnualRetExp = 0;
  const initialCurrentAge = 0;
  const initialCurrentSavings = 0;
  const initialContributions = 0;
  const initialContributionFreq = "Monthly";
  const initialPreRetROR = 7;
  const initialPostRetROR = 7;
  const initialInflation = 2.9;

  const [retirementAge, setRetirementAge] = useState(
    ("retirementAge", initialRetirementAge)
  );
  const [targetRetAmt, setTargetRetAmt] = useState(
    ("targetRetAmt", initialTargetRetAmt)
  );
  const [annualRetExp, setAnnualRetExp] = useState(
    ("annualRetExp", initialAnnualRetExp)
  );
  const [currentAge, setCurrentAge] = useState(
    ("currentAge", initialCurrentAge)
  );
  const [currentSavings, setCurrentSavings] = useState(
    ("currentSavings", initialCurrentSavings)
  );
  const [contributions, setContributions] = useState(
    ("contributions", initialContributions)
  );
  const [contributionFreq, setContributionFreq] = useState(
    ("contributionFreq", initialContributionFreq)
  );
  const [preRetROR, setPreRetROR] = useState(("preRetROR", initialPreRetROR));
  const [postRetROR, setPostRetROR] = useState(
    ("postRetROR", initialPostRetROR)
  );
  const [inflation, setInflation] = useState(("inflation", initialInflation));

  const handleReset = () => {
    setRetirementAge(initialRetirementAge);
    setTargetRetAmt(initialTargetRetAmt);
    setAnnualRetExp(initialAnnualRetExp);
    setCurrentAge(initialCurrentAge);
    setCurrentSavings(initialCurrentSavings);
    setContributions(initialContributions);
    setContributionFreq(initialContributionFreq);
    setPreRetROR(initialPreRetROR);
    setPostRetROR(initialPostRetROR);
    setInflation(inflation);

    document.getElementById("annualRetExp").value = 0;
    document.getElementById("currentAge").value = 0;
    document.getElementById("currentSavings").value = 0;
    document.getElementById("contributions").value = 0;
    document.getElementById("contributionFreq").value = "Monthly";
    document.getElementById("preRetROR").value = 7;
    document.getElementById("postRetROR").value = 7;
    document.getElementById("inflation").value = 2.9;
  };

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
      let retirementAge = currentAge;
      while (currBal < updatedTargetRetAmt) {
        currBal = annualCont + currBal * (1 + netPreRetROR);
        retirementAge += 1;

        if (retirementAge > 200) break;
      }
      return retirementAge;
    };

    let netPostRetROR = (postRetROR - inflation) / 100;
    if (netPostRetROR === 0) {
      netPostRetROR = 0.00001;
    }

    localStorage.setItem("annualRetExp", annualRetExp);
    localStorage.setItem("currentAge", currentAge);
    localStorage.setItem("currentSavings", currentSavings);
    localStorage.setItem("contributions", contributions);
    localStorage.setItem("contributionFreq", contributionFreq);
    localStorage.setItem("preRetROR", preRetROR);
    localStorage.setItem("postRetROR", postRetROR);
    localStorage.setItem("inflation", inflation);

    const updatedTargetRetAmt = annualRetExp / netPostRetROR;
    setTargetRetAmt(updatedTargetRetAmt);

    const retirementAge = calcRetirementAge(updatedTargetRetAmt);
    setRetirementAge(retirementAge);
    localStorage.setItem("retirementAge", retirementAge);
  }, [
    annualRetExp,
    currentAge,
    currentSavings,
    contributions,
    contributionFreq,
    preRetROR,
    postRetROR,
    inflation,
    targetRetAmt,
    retirementAge,
  ]);

  return (
    <div className="retirement">
      <h1 className="mt-5">Retirement Calculator</h1>
      <h2 className="mt-3">You can retire at age {retirementAge} </h2>
      <div>
        <h3>Target retirement amount</h3>
        <h4>Auto Calculation</h4> {formatter.format(targetRetAmt)}
      </div>
      <form className="retirement-calc-form">
        <label>
          Annual retirement expenses (today's dollars)
          <input
            className="rounded ms-2"
            type="number"
            defaultValue={annualRetExp}
            id="annualRetExp"
            onChange={(e) => {
              if (e.target.value !== "") {
                setAnnualRetExp(parseInt(e.target.value));
              }
            }}
          />
        </label>
        <label>
          Current age
          <input
            className="rounded ms-2"
            type="number"
            defaultValue={currentAge}
            id="currentAge"
            onChange={(e) => {
              if (e.target.value !== "") {
                setCurrentAge(parseInt(e.target.value));
              }
            }}
          />
        </label>
        <label>
          Current savings balance
          <input
            className="rounded ms-2"
            type="number"
            defaultValue={currentSavings}
            id="currentSavings"
            onChange={(e) => setCurrentSavings(parseInt(e.target.value))}
          />
        </label>
        <label>
          Regular contributions
          <input
            className="rounded ms-2"
            type="number"
            defaultValue={contributions}
            id="contributions"
            onChange={(e) => setContributions(parseInt(e.target.value))}
          />
        </label>
        <label>
          Contribution frequency
          <select
            className="rounded ms-2"
            defaultValue={contributionFreq}
            id="contributionFreq"
            onChange={(e) => setContributionFreq(e.target.value)}
          >
            <option value="Monthly">Monthly</option>
            <option value="Annually">Annually</option>
          </select>
        </label>
        <div>
          <h3 className="mt-1 mb-1">Advanced</h3>
          <label>
            Pre-retirement rate of return
            <input
              className="rounded ms-2"
              type="number"
              defaultValue={preRetROR}
              id="preRetROR"
              onChange={(e) => setPreRetROR(parseFloat(e.target.value))}
            />
          </label>
          <label>
            Post-retirement rate of return
            <input
              className="rounded ms-2"
              type="number"
              defaultValue={postRetROR}
              id="postRetROR"
              onChange={(e) => setPostRetROR(parseFloat(e.target.value))}
            />
          </label>
          <label>
            Inflation
            <input
              className="rounded ms-2"
              type="number"
              defaultValue={inflation}
              id="inflation"
              onChange={(e) => setInflation(parseFloat(e.target.value))}
            />
          </label>
        </div>
        <button className="rounded" type="button" onClick={handleReset}>
          Reset
        </button>
      </form>
    </div>
  );
}

export default Retirement;
