import coffee from "../../assets/coffee.jpg";
import ProductCard from "../ProductCard";

import { ProductsContainer } from "./Layout";

const ProductsContainerComponent = ({ data }) => {
  return (
    <ProductsContainer>
      <ProductCard productName={data.name} image={coffee} price={data.price} />
    </ProductsContainer>
  );
};

export default ProductsContainerComponent;
