import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/HomePage';

function App() {
  return (
      <BrowserRouter>
        <Routes>
            <Route path="/" element={<Home />} />
            {/* <Route path="/products" element={<Products/>}/>
            <Route path="/contact-me" element={<ContactMe />} />
            <Route path="/login" element={<Login />} />
            <Route path="/sign-up" element={<SignUp />} /> */}
        </Routes>
      </BrowserRouter>

  );
};
export default App;