import React, { Component } from "react";
import axios from "axios";

//Components
import Header from "../../Components/Header/Header";

//Material UI
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import Checkbox from "@mui/material/Checkbox";
import Divider from "@mui/material/Divider";
import { TextField } from "@mui/material";
import URL from "../../Services/URL";

class Compare extends Component {
  state = {
    firstJSON: "",
    secondJSON: "",
    differences: [],
    compareClicked: false,
  };

  compare() {
    axios({
      method: "POST",
      url: URL + "/api/compareJSONs",
      data: {
        firstJSON: this.state.firstJSON,
        secondJSON: this.state.secondJSON,
      },
    }).then((response) => {
      this.setState({ differences: response.data, compareClicked: true });
    });
  }
  render() {
    return (
      <div>
        <Header compare />
        {!this.state.compareClicked && this.state.differences.length === 0 ? (
          <div className="tools">
            <div className="compareColumn">
              <TextField
                id="outlined-multiline-static"
                label="First JSON"
                multiline
                rows={10}
                fullWidth
                onChange={(event) => {
                  this.setState({ firstJSON: event.target.value });
                }}
              />
              <div className="button-div">
                <button
                  className="button"
                  onClick={() => {
                    this.compare();
                  }}
                >
                  Compare
                </button>
              </div>
            </div>
            <div className="compareColumn">
              <TextField
                //   disabled
                id="outlined-multiline-static"
                label="Second JSON"
                multiline
                rows={10}
                fullWidth
                onChange={(event) => {
                  this.setState({ secondJSON: event.target.value });
                }}
              />
            </div>
          </div>
        ) : (
          ""
        )}
        {this.state.compareClicked ? (
          <div className="lines">
            <div className="column">
              {this.state.firstJSON.split("\n").map((line, index) => (
                <div className="line">
                  <div
                    className="line-number"
                    style={
                      this.state.differences.includes(index + 1)
                        ? { color: "red" }
                        : { color: "green" }
                    }
                  >
                    <pre>{index + 1}</pre>
                  </div>
                  <div
                    className="line-text"
                    style={
                      this.state.differences.includes(index + 1)
                        ? { color: "red", background: "#ffe6e6" }
                        : { color: "green", background: "#e6ffe6" }
                    }
                  >
                    <pre>{line}</pre>
                  </div>
                </div>
              ))}
              {this.state.differences.length === 0 ? (
                <div className="text">No differences found</div>
              ) : (
                <div className="text">{`${this.state.differences.length} ${
                  this.state.differences.length === 1
                    ? "difference"
                    : "differences"
                } found`}</div>
              )}
            </div>
            <div className="column">
              {this.state.secondJSON.split("\n").map((line, index) => (
                <div className="line">
                  <div
                    className="line-number"
                    style={
                      this.state.differences.includes(index + 1)
                        ? { color: "red" }
                        : { color: "green" }
                    }
                  >
                    <pre>{index + 1}</pre>
                  </div>
                  <div
                    className="line-text"
                    style={
                      this.state.differences.includes(index + 1)
                        ? { color: "red", background: "#ffe6e6" }
                        : { color: "green", background: "#e6ffe6" }
                    }
                  >
                    <pre>{line}</pre>
                  </div>
                </div>
              ))}
              <div className="text">
                <button
                  className="button"
                  onClick={() => {
                    this.setState({
                      firstJSON: "",
                      secondJSON: "",
                      differences: [],
                      compareClicked: false,
                    });
                  }}
                >
                  Compare again
                </button>
              </div>
            </div>
          </div>
        ) : (
          ""
        )}
      </div>
    );
  }
}

export default Compare;
