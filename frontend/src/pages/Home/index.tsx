import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <>
      <div className="jumbotron mt-5">
        <h1 className="display-4">Gui Vendas</h1>
        <p className="lead">
          Analise o desempenho das suas vendas por diferentes perspectivas
        </p>
        <hr />
        <p>
          Esta aplicação consiste em exibir um dashboard a partir de dados
          fornecidos por um back end construído com Spring Boot.
        </p>
        <Link className="btn btn-primary btn-lg" to="/dashboard">
          Acessar dashboard
        </Link>
      </div>
    </>
  );
};

export default Home;
