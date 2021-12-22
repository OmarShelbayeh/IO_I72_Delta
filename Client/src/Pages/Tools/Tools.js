import React, { Component } from "react";

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

class Tools extends Component {
  render() {
    return (
      <div>
        <Header tools />
        <div className="tools">
          <div className="other-column">
            <FormControl component="fieldset">
              <FormLabel component="legend">Options</FormLabel>
              <RadioGroup
                aria-label="gender"
                defaultValue="Minifikuj"
                name="radio-buttons-group"
              >
                <FormControlLabel
                  value="Minifikuj"
                  control={<Radio />}
                  label="Minifikuj"
                />
                <FormControlLabel
                  value="Deminifikuj"
                  control={<Radio />}
                  label="Deminifikuj"
                />
              </RadioGroup>
            </FormControl>
            <Divider />
          </div>
          <div className="column">
            <TextField
              id="outlined-multiline-static"
              label="Input"
              multiline
              rows={10}
              fullWidth
            />
          </div>
          <div className="column">
            <TextField
              disabled
              id="outlined-multiline-static"
              label="Output"
              multiline
              rows={10}
              value={""}
              fullWidth
            />
          </div>
        </div>
      </div>
    );
  }
}

export default Tools;
