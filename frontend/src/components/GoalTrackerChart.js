import React from 'react';
import GoalTrackerChart from './GoalTrackerChart';

const App = () => {
  const chartData = {
    labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
    values: [10, 20, 15, 25], // Example data for goals progress
  };

  return (
    <div>
      <h1>Goal Tracker</h1>
      <GoalTrackerChart data={chartData} />
    </div>
  );
};

export default App;