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

  afterLogin() {
    window.location.href = "/dashboard";
  }

  registerSuccessfulLogin(token) {
    localStorage.setItem("token", token);
  }
}

export default new AuthenticationService();
