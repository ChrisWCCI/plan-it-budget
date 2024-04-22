import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Goals from "./pages/Goals";
import Resources from "./pages/Resources";
import Retirement from "./pages/Retirement";
import Navbar from "./components/Navbar";

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" exact element={<Home />} />
          <Route path="/goals" element={<Goals />} />
          <Route path="/resources" element={<Resources />} />
          <Route path="/retirement" element={<Retirement />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </Router>
      <footer class="copyright">Ctrl Alt Elite Copyright &copy; 2024</footer>
    </>
  );
}

export default App;
