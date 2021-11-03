interface TableRowProps {
  data: string;
  vendedor: string;
  clientesVisitados: number;
  negociosFechados: number;
  valor: string;
}

const TableRow = ({
  data,
  vendedor,
  clientesVisitados,
  negociosFechados,
  valor,
}: TableRowProps) => {
  return (
    <tr className="gui-table-row">
      <td className="gui-table-column gui-column1">{data}</td>
      <td className="gui-table-column gui-column2">{vendedor}</td>
      <td className="gui-table-column gui-column3">{clientesVisitados}</td>
      <td className="gui-table-column gui-column4">{negociosFechados}</td>
      <td className="gui-table-column gui-column5">{valor}</td>
    </tr>
  );
};

const DataTable: React.FC = () => {
  return (
    <div className="gui-table-container mb-5">
      <div className="gui-table-wrapper">
        <div className="gui-table-div gui-table">
          <table data-vertable="gui-table" className="gui-table">
            <thead>
              <tr className="gui-table-row gui-table-head">
                <th className="gui-table-column gui-column1">Data</th>
                <th className="gui-table-column gui-column2">Vendedor</th>
                <th className="gui-table-column gui-column3">
                  Clientes visitados
                </th>
                <th className="gui-table-column gui-column4">
                  Negócios Fechados
                </th>
                <th className="gui-table-column gui-column5">Valor</th>
              </tr>
            </thead>
            <tbody>
              <TableRow
                data="22/04/2021"
                vendedor="Guilherme Esdras"
                clientesVisitados={34}
                negociosFechados={25}
                valor="15017.00"
              />
              <TableRow
                data="22/04/2021"
                vendedor="Guilherme Esdras"
                clientesVisitados={34}
                negociosFechados={25}
                valor="15017.00"
              />
              <TableRow
                data="22/04/2021"
                vendedor="Guilherme Esdras"
                clientesVisitados={34}
                negociosFechados={25}
                valor="15017.00"
              />
              <TableRow
                data="22/04/2021"
                vendedor="Guilherme Esdras"
                clientesVisitados={34}
                negociosFechados={25}
                valor="15017.00"
              />
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default DataTable;
