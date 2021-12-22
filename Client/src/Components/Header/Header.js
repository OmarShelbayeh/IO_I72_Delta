import React, { Component } from "react";

//Css
import "./css/Header.css";

class Header extends Component {
  render() {
    return (
      <div className="header">
        <div className="menu">
          <a className={this.props.ugly ? "active" : ""} href="/minimalize" z>
            Ugly
          </a>
          <a className={this.props.tools ? "active" : ""} href="/tools">
            Tools
          </a>
          <a className={this.props.beautiful ? "active" : ""} href="/beautiful">
            beautiful
          </a>
        </div>
      </div>
    );
  }
}

export default Header;
