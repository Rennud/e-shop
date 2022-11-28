import React, { useState } from "react";
import { AppBar, Tab, Tabs, Toolbar } from "@mui/material";
import { Link } from "react-router-dom";
import Coffee from "@mui/icons-material/Coffee";

const Navbar = ({ currentUser, logout }) => {
  const [value, setValue] = useState();

  return (
    <>
      <AppBar
        sx={{
          background: "linear-gradient(129deg, #2E151B 30%, #c8a27c 80%)",
          position: "absolute",
        }}
      >
        <Toolbar>
          <Coffee sx={{ transform: "scale(2)", marginLeft: "2rem" }} />
          <>
            <Tabs
              sx={{ marginLeft: "2rem", flexGrow: 1 }}
              TabIndicatorProps={{ style: { background: "#c8a27c" } }}
              textColor="inherit"
              value={value}
              onChange={(e, value) => setValue(value)}
            >
              <Tab
                label="Home"
                LinkComponent={Link}
                to={"/"}
                sx={{
                  "&:hover": {
                    background: "white",
                    color: "#2E151B",
                  },
                }}
              />
              <Tab
                label="Products"
                LinkComponent={Link}
                to={"/products"}
                sx={{
                  "&:hover": {
                    background: "white",
                    color: "#2E151B",
                  },
                }}
              />
              <Tab
                label="Contact"
                LinkComponent={Link}
                to={"/contact"}
                sx={{
                  "&:hover": {
                    background: "white",
                    color: "#2E151B",
                  },
                }}
              />
              {currentUser ? (
                <>
                  <Tab
                    label="Profile"
                    sx={{
                      marginLeft: "auto",
                      background: "#2E151B",
                      "&:hover": {
                        background: "white",
                        color: "#2E151B",
                      },
                    }}
                    LinkComponent={Link}
                    to={"/profile"}
                  >
                    {currentUser.username}
                  </Tab>
                  <Tab
                    label="Logout"
                    sx={{
                      marginLeft: "10px",
                      background: "#2E151B",
                      "&:hover": {
                        background: "white",
                        color: "#2E151B",
                      },
                    }}
                    LinkComponent={Link}
                    onClick={logout}
                    to={"/login"}
                  />
                </>
              ) : (
                <>
                  <Tab
                    label="Login"
                    sx={{
                      marginLeft: "auto",
                      background: "#2E151B",
                      "&:hover": {
                        background: "white",
                        color: "#2E151B",
                      },
                    }}
                    LinkComponent={Link}
                    to={"/login"}
                  />
                  <Tab
                    label="Sign up"
                    sx={{
                      marginLeft: "10px",
                      background: "#2E151B",
                      "&:hover": {
                        background: "white",
                        color: "#2E151B",
                      },
                    }}
                    LinkComponent={Link}
                    to={"/signup"}
                  />
                </>
              )}
            </Tabs>
          </>
        </Toolbar>
      </AppBar>
    </>
  );
};
export default Navbar;
