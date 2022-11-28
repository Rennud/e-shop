import React, { useEffect, useState } from "react";
import { Routes, Route } from "react-router-dom";

import AuthService from "./services/AuthService";

import SignIn from "./pages/SignInPage";
import Home from "./pages/HomePage";
import SignUp from "./pages/SignUpPage";
import Profile from "./components/ProfileComponent";
import AuthVerify from "./common/AuthVerify";
import Footer from "./components/Footer";
import Navbar from "./components/Navbar";
import EventBus from "./common/EventBus";

function App() {
  const [currentUser, setCurrentUser] = useState(undefined);

  const logout = () => {
    AuthService.logout();
    setCurrentUser(undefined);
  };

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
      EventBus.on("logout", () => {
        logout();
      });
    }
  }, []);

  useEffect(() => {
    EventBus.remove("logout");
  });

  return (
    <div>
      <Navbar currentUser={currentUser} logout={logout} />
      <Footer />
      <>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<SignIn />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </>
      <AuthVerify logout={logout} />
    </div>
  );
}

export default App;
