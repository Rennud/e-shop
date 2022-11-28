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

function SignUp(props) {
  const [errMessageInUsed, setErrMessageInUsed] = useState("");
  const [firstNameErrorText, setFirstNameErrorText] = useState("");
  const [lastNameErrorText, setLastNameErrorText] = useState("");
  const [emailErrorText, setEmailErrorText] = useState("");
  const [usernameErrorText, setUsernameErrorText] = useState("");
  const [passwordErrorText, setPasswordErrorText] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);

    if (data.get("firstName").length === 0) {
      setFirstNameErrorText("Please enter first name");
    }
    if (data.get("lastName").length === 0) {
      setLastNameErrorText("Please enter last name");
    }
    if (data.get("username").length === 0) {
      setUsernameErrorText("Please enter username");
    }
    if (data.get("email").length === 0) {
      setEmailErrorText("Please enter email");
    }
    if (data.get("password").length === 0) {
      setPasswordErrorText("Please enter password");
    }

    if (
      data.get("username") &&
      data.get("email") &&
      data.get("firstName") &&
      data.get("lastName") &&
      data.get("password")
    ) {
      setFirstNameErrorText("");
      setLastNameErrorText("");
      setUsernameErrorText("");
      setEmailErrorText("");
      setPasswordErrorText("");

      const response = AuthService.register(
        data.get("username"),
        data.get("email"),
        data.get("firstName"),
        data.get("lastName"),
        data.get("password")
      );

      response
        .then(() => {
          AuthService.login(data.get("username"), data.get("password")).then(
            () => {
              props.router.navigate("/profile");
              window.location.reload();
            }
          );
        })
        .catch((e) => setErrMessageInUsed(e.response.data.message));
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
            Sign up
          </Typography>
          <Box
            component="form"
            noValidate
            onSubmit={handleSubmit}
            sx={{ mt: 3 }}
          >
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  autoComplete="given-name"
                  name="firstName"
                  fullWidth
                  id="firstName"
                  label="First Name"
                  error={!!firstNameErrorText}
                  helperText={firstNameErrorText}
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  id="lastName"
                  label="Last Name"
                  name="lastName"
                  error={!!lastNameErrorText}
                  helperText={lastNameErrorText}
                  autoComplete="family-name"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="username"
                  label="Username"
                  name="username"
                  error={!!usernameErrorText}
                  helperText={usernameErrorText}
                  autoComplete="username"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  error={!!emailErrorText}
                  helperText={emailErrorText}
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  error={!!passwordErrorText}
                  helperText={passwordErrorText}
                  autoComplete="new-password"
                />
              </Grid>
              <Grid item xs={12}></Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{
                mt: 3,
                mb: 2,
                background: "#2E151B",
                "&:hover": {
                  background: "#c8a27c",
                },
              }}
            >
              Sign Up
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="/login" variant="body2">
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        {errMessageInUsed.length > 0 && (
          <Alert
            severity="error"
            style={{ padding: "10px", marginTop: "10px" }}
          >
            {errMessageInUsed}
          </Alert>
        )}
      </Container>
    </ThemeProvider>
  );
}

export default withRouter(SignUp);
