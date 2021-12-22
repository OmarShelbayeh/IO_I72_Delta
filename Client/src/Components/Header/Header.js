import React, { Component } from "react";

//Css
import "./css/Header.css";

class Header extends Component {
  render() {
    return (
      <div className="header">
        <div className="menu">
          <a className={this.props.ugly ? "active" : ""} href="/minimalize" z>
            Compare
          </a>
          <a className={this.props.tools ? "active" : ""} href="/tools">
            Minification
          </a>
          <a className={this.props.beautiful ? "active" : ""} href="/beautiful">
            Filter
          </a>
        </div>
      </div>
    );
  }
}

export default Header;
