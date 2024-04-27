import React, { useState } from "react";
import { Pie } from "react-chartjs-2";
import { Chart, ArcElement } from "chart.js";

Chart.register(ArcElement);

const PieChart = () => {
  const [data, setData] = useState({
    labels: [
      "Car (Pink)",
      "House (Blue)",
      "Vacation (Yellow)",
      "Education (Green)",
      "Gifts (Purple)",
      "Misc (Orange)",
    ],
    datasets: [
      {
        data: [12, 19, 3, 5, 2, 3], // Initial data for the chart
        backgroundColor: [
          "#FF6384",
          "#36A2EB",
          "#FFCE56",
          "#4CAF50",
          "#9C27B0",
          "#FF9800",
        ],
        hoverBackgroundColor: [
          "#FF6384",
          "#36A2EB",
          "#FFCE56",
          "#4CAF50",
          "#9C27B0",
          "#FF9800",
        ],
      },
    ],
  });

  const handleInputChange = (e, index) => {
    const newData = [...data.datasets[0].data];
    newData[index] = parseInt(e.target.value);
    setData({
      ...data,
      datasets: [{ ...data.datasets[0], data: newData }],
    });
  };
  return (
    <div id="pieChart">
      <Pie data={data} />
      <div>
        {data.labels.map((label, index) => (
          <div key={index}>
            <label id="pieLabels">{label}</label>
            <input
              id="input"
              type="number"
              value={data.datasets[0].data[index]}
              onChange={(e) => handleInputChange(e, index)}
            />
          </div>
        ))}
      </div>
    </div>
  );
};

export default PieChart;
