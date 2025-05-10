import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Details from './pages/Details';
import Home from './pages/Home'; // ⬅️ Import Home page

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} /> {/* ⬅️ Show list of persons here */}
        <Route path="/person/:id" element={<Details />} />
      </Routes>
    </Router>
  );
}

export default App;
