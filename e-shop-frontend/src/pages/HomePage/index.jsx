import React from "react";
import { useEffect, useState } from "react";
import ProductsContainer from "../../components/ProductContainer";
import { HomeHeader } from "./layout";

const ITEM_API_BASE_URL = "http://localhost:8080/api/item";

const Home = () => {
  const [data, setData] = useState({});
  const getItemsById = (itemId) => {
    fetch(`${ITEM_API_BASE_URL}/${itemId}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((data) => setData(data))
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    getItemsById(1);
  }, []);
  return (
    <>
      <HomeHeader>Our best coffees</HomeHeader>
      <ProductsContainer data={data} />
    </>
  );
};

export default Home;
