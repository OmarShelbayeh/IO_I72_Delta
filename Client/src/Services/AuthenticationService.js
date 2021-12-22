import axios from "axios";
import URL from "./URL";

class AuthenticationService {
  login(email, password) {
    axios({
      url: URL + "/authenticate",
      method: "POST",
      data: {
        email: email,
        password: password,
      },
    })
      .then((response) => {
        this.registerSuccessfulLogin(response.data.token);
      })
      .then(() => {
        this.afterLogin();
      });
  }

  register(email, name, surname, password, func) {
    axios({
      url: URL + "/api/register",
      method: "POST",
      data: {
        email: email,
        name: name,
        surname: surname,
        password: password,
        role: "USER",
      },
    })
      .then(() => {
        window.location.href = "/login";
      })
      .catch((error) => func(error));
  }

  registerSuccessfulLogin(token) {
    localStorage.setItem("token", token);
  }
}

export default new AuthenticationService();
