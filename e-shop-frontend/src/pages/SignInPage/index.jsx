import React, { useState } from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import Alert from "@mui/material/Alert";

import { createTheme, ThemeProvider } from "@mui/material/styles";

import AuthService from "../../services/AuthService";

import { withRouter } from "../../common/WithRouter";

const theme = createTheme();

function Login(props) {
  const [err, setErr] = useState(false);
  const [usernameErrorText, setUsernameErrorText] = useState("");
  const [passwordErrorText, setPasswordErrorText] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    if (data.get("username").length === 0) {
      setUsernameErrorText("Please enter username");
    }
    if (data.get("password").length === 0) {
      setPasswordErrorText("Please enter password");
    }

    if (data.get("username") && data.get("password")) {
      setUsernameErrorText("");
      setPasswordErrorText("");

      AuthService.login(data.get("username"), data.get("password"))
        .then(() => {
          props.router.navigate("/profile");
          window.location.reload();
        })
        .catch(() => setErr(true));
    }
  };

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 15,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <Box
            component="form"
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}
          >
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="Username"
              name="username"
              error={!!usernameErrorText}
              helperText={usernameErrorText}
              autoComplete="username"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              error={!!passwordErrorText}
              helperText={passwordErrorText}
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{
                mb: 2,
                background: "#2E151B",
                "&:hover": {
                  background: "#c8a27c",
                },
              }}
            >
              Sign In
            </Button>
            <Grid container>
              <Grid item xs>
                <Link href="#" variant="body2">
                  Forgot password?
                </Link>
              </Grid>
              <Grid item>
                <Link href={"/register"} variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        {err && (
          <Alert
            severity="error"
            style={{ padding: "10px", marginTop: "10px" }}
          >
            Username or password don't match!
          </Alert>
        )}
      </Container>
    </ThemeProvider>
  );
}

export default withRouter(Login);
