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
                defaultValue="Usun"
                name="radio-buttons-group"
              >
                <FormControlLabel
                  value="Usun"
                  control={<Radio />}
                  label="Usun"
                />
                <FormControlLabel
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
              id="outlined-multiline-static"
              label="Output"
              multiline
              rows={10}
              fullWidth
            />
          </div>
        </div>
      </div>
    );
  }
}

export default Tools;
