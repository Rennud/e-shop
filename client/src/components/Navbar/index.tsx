import React, { useState } from 'react';
import {
  AppBar,
  Button,
  Tab,
  Tabs,
  Toolbar,
  Typography,
  useMediaQuery,
  useTheme,
} from '@mui/material';
import Coffee from '@mui/icons-material/Coffee';
import DrawerComp from './Drawer';


const Navbar = () => {
  const [value, setValue] = useState();
  const theme = useTheme();
  const isMatch = useMediaQuery(theme.breakpoints.down('md'));

  return (
    <>
      <AppBar sx={{ background: 'linear-gradient(129deg, #2E151B 30%, #c8a27c 80%)', position: 'absolute' }}>
        <Toolbar>
          <Coffee sx={{ transform: 'scale(2)', marginLeft: '2rem' }} />
          {isMatch ? (
            <>
              <Typography sx={{ fontSize: '2rem', paddingLeft: '10%' }}>
                IncCoffee
              </Typography>
              <DrawerComp />
            </>
          ) : (
            <>
              <Tabs
                sx={{ marginLeft: '2rem'}}
                TabIndicatorProps={{style: {background:'#c8a27c'}}}
                textColor='inherit'
                value={value}
                onChange={(e, value) => setValue(value)}
              >
                <Tab label='Home' />
                <Tab label='Products' />
                <Tab label='Contact' />
              </Tabs>
              <Button
                sx={{
                  marginLeft: 'auto',
                  background: '#2E151B',
                  '&:hover': {
                    background: 'white',
                    color: '#2E151B',
                  },
                }}
                variant='contained'
              >
                Login
              </Button>
              <Button
                sx={{
                  marginLeft: '10px',
                  background: '#2E151B',
                  '&:hover': {
                    background: 'white',
                    color: '#2E151B',
                  },
                }}
                variant='contained'
              >
                Sign Up
              </Button>
            </>
          )}
        </Toolbar>
      </AppBar>
    </>
  );
};
export default Navbar;