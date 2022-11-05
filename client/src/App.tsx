import React from 'react';
import './App.css';
import Footer from './components/Footer';
import Navbar from './components/Navbar';
import ProductPage from './pages/ProductPage/index';


function App() {
  return (
    <div className="App">
     <Navbar/>
     <ProductPage/>
     <Footer />
    </div>
  );
}

export default App;
