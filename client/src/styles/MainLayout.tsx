import Footer from '../components/Footer';
import Navbar from '../components/Navbar';

import styled from 'styled-components';

const Layout = styled.div`
    background:  #D2B48C;
    position: absolute;
    bottom: 0;
    left: 0;
    right: 0;
    height: 100%
`;

type LayoutProps = {
    children: JSX.Element|JSX.Element[];
};

const MainLayout = ({ children }: LayoutProps) => {
    return (
        <>
            <Navbar/>
            <Layout>
                {children}
            </Layout>
            <Footer />
        </>
    );
};

export default MainLayout;