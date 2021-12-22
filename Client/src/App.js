import React, { Component } from "react";
import { Routes, Route } from "react-router-dom";

function App() {

  return (
    <div className="App">
      <Routes>
        <Route
          exact
          path="/login"
          element={
            <Login
              error={(msg) => {
                this.error(msg);
              }}
              warning={(msg) => {
                this.warning(msg);
              }}
            />
          }
        />
      </Routes>
    </div>
  );
}

export default App;
