import React, { Component } from "react";

//css
import "./css/Tools.css";

//Material UI
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import Checkbox from "@mui/material/Checkbox";
import Divider from "@mui/material/Divider";

class Tools extends Component {
  render() {
    return (
      <div className="tools">
        <div className="column">
          <FormControl component="fieldset">
            <FormLabel component="legend">Gender</FormLabel>
            <RadioGroup
              aria-label="gender"
              defaultValue="Usun"
              name="radio-buttons-group"
            >
              <FormControlLabel value="Usun" control={<Radio />} label="Usun" />
              <FormControlLabel
                disabled
                value="Zachowaj"
                control={<Radio />}
                label="Zachowaj"
              />
            </RadioGroup>
          </FormControl>
          <Divider />
          <div className="check">
            <Checkbox defaultChecked />
            <p>Entery</p>
          </div>
          <div className="check">
            <Checkbox defaultChecked />
            <p>Spacji</p>
          </div>
        </div>
        <div className="other-column"></div>
      </div>
    );
  }
}

export default Tools;
