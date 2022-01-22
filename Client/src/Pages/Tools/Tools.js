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

class Tools extends Component {
  state = {
    json: null,
    jsonAns: null,
    option: "0",
  };

  handleChange(value) {
    this.setState({ json: value.replace("\\", "") });
  }

  handleChangeRadio(value) {
    this.setState({ option: value });
  }

  pretty() {
    axios({
      headers: { "Content-Type": "text/plain" },
      method: "POST",
      url: URL + "/api/prettyJSON",
      data: this.state.json,
    }).then((response) => {
      this.setState({ jsonAns: response.data });
    });
  }

  minify() {
    axios({
      headers: { "Content-Type": "text/plain" },
      method: "POST",
      url: URL + "/api/minifyJSON",
      data: this.state.json,
    }).then((response) => {
      this.setState({ jsonAns: response.data });
    });
  }

  render() {
    return (
      <div>
        <Header tools />
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
                defaultValue="Minifikuj"
                name="radio-buttons-group"
                value={this.state.option}
              >
                <FormControlLabel
                  value={0}
                  control={<Radio />}
                  label="Minifikuj"
                />
                <FormControlLabel
                  value={1}
                  control={<Radio />}
                  label="Pretty"
                />
              </RadioGroup>
            </FormControl>
            <Divider />
            <div className="button-div">
              <button
                className="button"
                onClick={() => {
                  if (this.state.option === "0") {
                    this.minify();
                  } else {
                    this.pretty();
                  }
                }}
              >
                {this.state.option === "0" ? "Minifikuj" : "Pretty"}
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
          </div>
          <div className="column">
            <TextField
              disabled
              id="outlined-multiline-static"
              label="Output"
              multiline
              rows={10}
              value={
                this.state.jsonAns
                  ? this.state.option === "1"
                    ? JSON.stringify(this.state.jsonAns, 5, 2)
                    : JSON.stringify(this.state.jsonAns)
                  : this.state.jsonAns === 0 ? "Wrong JSON" : ""
              }
              fullWidth
            />
          </div>
        </div>
      </div>
    );
  }
}

export default Tools;
