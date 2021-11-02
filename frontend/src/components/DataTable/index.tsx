const DataTable = () => {
  return (
    <div className="table-responsive mb-5">
      <table className="table table-striped table-sm table-hover">
        <thead className="table-light">
          <tr>
            <th scope="col">Data</th>
            <th scope="col">Vendedor</th>
            <th scope="col">Clientes visitados</th>
            <th scope="col">Negócios Fechados</th>
            <th scope="col">Valor</th>
          </tr>
        </thead>
        <tbody className="table-hover">
          <tr>
            <td>22/04/2021</td>
            <td>Guilherme Esdras</td>
            <td>34</td>
            <td>25</td>
            <td>15017.00</td>
          </tr>
          <tr>
            <td>22/04/2021</td>
            <td>Guilherme Esdras</td>
            <td>34</td>
            <td>25</td>
            <td>15017.00</td>
          </tr>
          <tr>
            <td>22/04/2021</td>
            <td>Guilherme Esdras</td>
            <td>34</td>
            <td>25</td>
            <td>15017.00</td>
          </tr>
          <tr>
            <td>22/04/2021</td>
            <td>Guilherme Esdras</td>
            <td>34</td>
            <td>25</td>
            <td>15017.00</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default DataTable;
