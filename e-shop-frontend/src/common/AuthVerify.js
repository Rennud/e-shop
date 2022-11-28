import React, { useEffect } from "react";
import { withRouter } from "./WithRouter.js";

const parseJwt = (token) => {
  try {
    return JSON.parse(window.atob(token.split(".")[1]));
  } catch (e) {
    return null + `Error ${e}`;
  }
};

const AuthVerify = (props) => {
  let location = props.router.location;

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("user"));

    if (user) {
      const decodedJwt = parseJwt(user.token);
      if (decodedJwt.exp * 1000 < Date.now()) {
        props.logout();
      }
    }
  }, [location, props]);

  return <div></div>;
};

export default withRouter(AuthVerify);
