
import React, { useState, useEffect, useRef} from 'react';
import Chart from 'chart.js/auto';



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




export const GoalTrackerChart = ({ data }) => {
  const chartRef = useRef(null);

  useEffect(() => {
    if (chartRef && chartRef.current) {
      const ctx = chartRef.current.getContext('2d');
      const myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: data.labels,
          datasets: [{
            label: 'Goals Progress',
            data: data.values,
            borderColor: 'rgba(75, 192, 192, 1)',
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderWidth: 1,
          }],
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });
    }
  }, [data]);

  return <canvas ref={chartRef} />;
};

