import { Link } from 'react-router-dom';

import BarChart from 'components/BarChart';
import DataTable from 'components/DataTable';
import DonutChart from 'components/DonutChart';

const Dashboard = () => {
  return (
    <>
      <Link className="btn btn-primary btn-sm" to="/">
        &laquo; Homepage
      </Link>
      <h1 className="text-primary py-3">Dashboard de Venda</h1>

      <div className="row px-3">
        <div className="col-sm-6">
          <h5 className="text-center text-secundary">Taxa de sucesso (%)</h5>
          <BarChart />
        </div>
        <div className="col-sm-6">
          <h5 className="text-center text-secundary">Todas as vendas</h5>
          <DonutChart />
        </div>
      </div>

      <div className="py-3">
        <h2 className="text-primary">Todas as vendas</h2>
      </div>

      <DataTable />
    </>
  );
};

export default Dashboard;
