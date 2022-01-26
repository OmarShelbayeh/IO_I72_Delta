import React, { Component } from "react";
import axios from "axios";

//css
import "./css/Tools.css";

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

class Filter extends Component {
  state = {
    json: null,
    jsonAns: null,
    option: "0",

    prop: "",
    specificProperties: [],
  };

  handleChange(value) {
    this.setState({ json: value.replace("\\", "") });
  }

  handleChangeRadio(value) {
    this.setState({ option: value });
  }

  transformWithout() {
    axios({
      method: "POST",
      url: URL + "/api/transformJSONWithoutSpecificProperties",
      data: {
        json: this.state.json,
        specificProperties: this.state.specificProperties,
      },
    })
      .then((response) => {
        this.setState({ jsonAns: response.data });
      })
      .catch(() => {
        this.props.error("Wrong JSON");
        this.setState({ jsonAns: "Wrong JSON" });
      });
  }

  transformWith() {
    axios({
      method: "POST",
      url: URL + "/api/transformJSONSpecificProperties",
      data: {
        json: this.state.json,
        specificProperties: this.state.specificProperties,
      },
    })
      .then((response) => {
        this.setState({ jsonAns: response.data });
      })
      .catch(() => {
        this.props.error("Wrong JSON");
        this.setState({ jsonAns: "Wrong JSON" });
      });
  }

  addToProps() {
    let array = [...this.state.specificProperties];
    array.push(this.state.prop);
    this.setState({ prop: "", specificProperties: array });
  }

  deleteFromProps(index) {
    let array = [...this.state.specificProperties];
    array.splice(index, 1);
    this.setState({ specificProperties: array });
  }

  render() {
    return (
      <div>
        <Header filter />
        <div className="tools">
          <div className="other-column">
            <FormControl
              component="fieldset"
              onChange={(event) => {
                this.handleChangeRadio(event.target.value);
              }}
            >
              <FormLabel component="legend">Options</FormLabel>
              <RadioGroup
                aria-label="gender"
                defaultValue="Delete Properties"
                name="radio-buttons-group"
                value={this.state.option}
              >
                <FormControlLabel
                  value={0}
                  control={<Radio />}
                  label="Delete Properties"
                />
                <FormControlLabel
                  value={1}
                  control={<Radio />}
                  label="Keep Properties"
                />
              </RadioGroup>
            </FormControl>
            <Divider />
            <div className="button-div">
              <button
                className="button"
                onClick={() => {
                  if (this.state.option === "0") {
                    this.transformWithout();
                  } else {
                    this.transformWith();
                  }
                }}
              >
                {this.state.option === "0" ? "Delete" : "Keep"}
              </button>
            </div>
          </div>
          <div className="column">
            <TextField
              id="outlined-multiline-static"
              label="Input"
              multiline
              rows={10}
              fullWidth
              onChange={(event) => {
                this.handleChange(event.target.value);
              }}
            />
            <table>
              <tr>
                <th>Properties</th>
              </tr>
              {this.state.specificProperties.map((prop, index) => (
                <tr>
                  <td>{prop}</td>
                  <td style={{ textAlign: "center" }}>
                    <button onClick={() => this.deleteFromProps(index)}>
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
              <tr>
                <th>
                  <TextField
                    id="outlined-multiline-static"
                    label="Prop"
                    value={this.state.prop}
                    onChange={(e) => {
                      this.setState({ prop: e.target.value });
                    }}
                  />
                </th>
                <th style={{ textAlign: "center" }}>
                  <button className="button" onClick={() => this.addToProps()}>
                    Add
                  </button>
                </th>
              </tr>
            </table>
          </div>
          <div className="column">
            <TextField
              disabled
              id="outlined-multiline-static"
              label="Output"
              multiline
              rows={10}
              value={JSON.stringify(this.state.jsonAns, 5, 2)}
              fullWidth
            />
          </div>
        </div>
      </div>
    );
  }
}

export default Filter;
