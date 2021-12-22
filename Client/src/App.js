import React, { Component } from "react";
import { Routes, Route } from "react-router-dom";
import Landing from "./Pages/Landing/Landing";
import Login from "./Pages/Login/Login";
import Tools from "./Pages/Tools/Tools";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route exact path="/" element={<Landing />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/tools" element={<Tools />} />
      </Routes>
    </div>
  );
}

export default App;
