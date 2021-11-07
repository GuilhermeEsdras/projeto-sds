import Footer from 'components/Footer';
import NavBar from 'components/NavBar';
import Routes from 'Routes';

const Layout = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <Routes />
      </div>
      <Footer />
    </>
  );
};

export default Layout;
