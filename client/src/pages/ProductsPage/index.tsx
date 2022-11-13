import coffee from '../../assets/coffee.jpg';
import ProductCard from '../../components/ProductCard';

import { ProductsContainer } from '../../components/ProductContainer/Layout';

const ProductsPage = ({data}: any) => {
    return (
        <ProductsContainer>
                    <ProductCard
                        productName={data.name}
                        image={coffee}
                        price={data.price}
                    />
        </ProductsContainer>
    );

};

export default ProductsPage;