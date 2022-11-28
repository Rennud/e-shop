import styled from 'styled-components';

export const ProductsContainer = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    gap: 1rem;
    margin-bottom: 2rem;
    margin-top: 5rem;
    @media (max-width: 1200px) {
        margin: 0 auto;
        margin-bottom: 10rem
    };
`;