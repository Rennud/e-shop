import MainLayout from '../../styles/MainLayout';
import { useEffect, useState } from 'react';
import ProductsContainer from '../../components/ProductContainer';
import { HomeHeader } from './Layout';

import axios from "axios";

const ITEM_API_BASE_URL = "http://localhost:8080/api/item"

const Home = () => {
    const [data, setData] = useState({})
    const  getItemsById = (itemId: Number) => {
      axios.get(`${ITEM_API_BASE_URL}/${itemId}`).then(response => {
          console.log(response.data); //outputs the json response
          setData(response.data)
        }).catch(err => console.log(err));
    }
    useEffect(() => {
      getItemsById(1)
    }, [])
    return (
        <MainLayout>
              <HomeHeader>Our best coffees</HomeHeader>
              <ProductsContainer data={data} />
        </MainLayout>
    );
};

export default Home;