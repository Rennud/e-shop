import coffee from '../../assets/coffee.jpg';
import ProductCard from '../../components/ProductCard';

import { ProductsContainer } from './Layout';

const ProductPage = () => {
    type ProductData = {
        productName: string;
        image: HTMLImageElement;
        price: Number;
    }[];

    const products: ProductData = [
        {
            productName: 'Coffee 1',
            image: coffee,
            price: 200
        },
        {
            productName: 'Coffee 2',
            image: coffee,
            price: 400
        },
        {
            productName: 'Coffee 3',
            image: coffee,
            price: 600
        },
    ];
    return (
        <ProductsContainer>
            {products.map(product => {
                return (
                    <ProductCard
                        productName={product.productName}
                        image={product.image}
                        price={product.price}
                    />
                );
            })}
        </ProductsContainer>
    );

};

export default ProductPage;