import {
  Facebook,
  Instagram,
  Twitter,
} from '@mui/icons-material';
import { makeStyles } from '@material-ui/core'

const useStyles = makeStyles({

  footerStyles: {
    color: 'white',
    background: 'linear-gradient(129deg, #2E151B 30%, #c8a27c 80%)',
    bottom:0,
    position:'fixed',
    width: '100%'
  },
  socialIconsContainer: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    margin: '5px 5px',
  },
  socialMediaLinks: {
    textDecoration: 'none',
    '&:hover': {
      color: '#54b3d6'
    },
    color: 'inherit',
    margin:'0 15px'
  },
  bottomText: {
    marginTop: '0',
    marginBottom: '10px',
    fontSize: '15px',
    textAlign: 'center'
  }
})

export default function Footer() {

  const classes = useStyles();

  return (
    <footer className={classes.footerStyles}>
      <div className={classes.socialIconsContainer}>
        <a href='https://www.instagram.com/' className={classes.socialMediaLinks} target="_blank">
          <Instagram style={{fontSize: '30px'}}/>
        </a>
        <a href='https://www.facebook.com/' className={classes.socialMediaLinks} target="_blank">
          <Facebook  style={{fontSize: '30px'}}/>
        </a>
        <a href='https://twitter.com/' className={classes.socialMediaLinks} target="_blank">
          <Twitter style={{fontSize: '30px'}}/>
        </a>
      </div>
      <h5 className={classes.bottomText}>Copyright ©2022 Developed with passion and lot of coffee</h5>
    </footer>
  );
}
