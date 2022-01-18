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
    jsonANS: "",
  };

  compare() {
    axios({
      headers: { "Content-Type": "text/plain" },
      method: "POST",
      url:
        URL +
        "/api/compareJSONs?firstJSON=" +
        this.state.firstJSON +
        "&secondJSON=" +
        this.state.secondJSON,
      data: this.state.json,
    }).then((response) => {
      this.setState({ jsonAns: response.data });
    });
  }
  render() {
    return (
      <div>
        <Header compare />
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
        <button
          onClick={() => {
            this.compare();
          }}
        >
          Compare
        </button>
      </div>
    );
  }
}

export default Compare;
