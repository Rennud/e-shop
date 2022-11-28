import styled from 'styled-components';

export const ProjectImg = styled.img`
    max-width: 100%;
    border-radius: 10px;
    height: auto;
    @media (max-width: 1200px) {
        margin: 0 auto;
        width: 60%;
    };
    &:hover {
        transform: scale(1.05);
    };
`;


export const ProductsContainer = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    gap: 1rem;
    margin-top: 25rem;
    margin-bottom: 2rem;
    @media (max-width: 1200px) {
        margin: 0 auto;
        margin-bottom: 10rem
    };
`;