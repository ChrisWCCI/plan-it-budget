
import Line from "./components/Line";
import React, { useState } from 'react';

const Goals = () => {
  const [name, setName] = useState('');
  const [amount, setAmount] = useState(0);
  const [timeline, setTimeline] = useState(0);
  const [monthlyContribution, setMonthlyContribution] = useState(0);

  const calculateTotalSavings = () => {
    return monthlyContribution * timeline;
  };

  return (
    <div>
      <h1>Goal Calculator</h1>
      <input
        type="text"
        placeholder="Goal Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="number"
        placeholder="Goal Amount"
        value={amount}
        onChange={(e) => setAmount(parseFloat(e.target.value))}
      />
      <input
        type="number"
        placeholder="Timeline (months)"
        value={timeline}
        onChange={(e) => setTimeline(parseInt(e.target.value))}
      />
      <input
        type="number"
        placeholder="Monthly Contribution"
        value={monthlyContribution}
        onChange={(e) => setMonthlyContribution(parseFloat(e.target.value))}
      />
      <p>Total Savings Required: <strong>{calculateTotalSavings()}</strong></p>
    </div>
  );
};

export default Goals;

import { Line } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);

export const LineGraph = () => {
  const options = {};

  return <Line options={options} data={lineChartData} />;
};





