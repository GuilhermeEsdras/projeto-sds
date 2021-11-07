import { useEffect, useState } from 'react';

import { BASE_URL } from 'api/requests';
import axios from 'axios';
import Pagination from 'components/Pagination';
import { SalePage } from 'types/sale';
import { formatLocalDate } from 'utils/format';

interface TableRowProps {
  data: string;
  vendedor: string;
  clientesVisitados: number;
  negociosFechados: number;
  valor: number;
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
      <td data-label="Data" className="gui-table-column gui-column1">
        {data}
      </td>
      <td data-label="vendedor" className="gui-table-column gui-column2">
        {vendedor}
      </td>
      <td
        data-label="Clientes Visitados"
        className="gui-table-column gui-column3"
      >
        {clientesVisitados}
      </td>
      <td
        data-label="Negócios Fechados"
        className="gui-table-column gui-column4"
      >
        {negociosFechados}
      </td>
      <td data-label="Valor" className="gui-table-column gui-column5">
        {valor}
      </td>
    </tr>
  );
};

const DataTable: React.FC = () => {
  const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<SalePage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
      .then((response) => {
        setPage(response.data);
      });
  }, [activePage]); // @NOTE: Chama o useEffect toda vez que activePage muda seu valor.

  const changePage = (index: number) => {
    setActivePage(index);
  };

  return (
    <>
      <Pagination page={page} onPageChange={changePage} />
      <div className="gui-table-container mb-5">
        <div className="gui-table-wrapper">
          <div className="gui-table-div gui-table">
            <table data-vertable="gui-table" className="gui-table">
              <thead>
                <tr className="gui-table-row gui-table-head">
                  <th scope="col" className="gui-table-column gui-column1">
                    Data
                  </th>
                  <th scope="col" className="gui-table-column gui-column2">
                    Vendedor
                  </th>
                  <th scope="col" className="gui-table-column gui-column3">
                    Clientes visitados
                  </th>
                  <th scope="col" className="gui-table-column gui-column4">
                    Negócios Fechados
                  </th>
                  <th scope="col" className="gui-table-column gui-column5">
                    Valor
                  </th>
                </tr>
              </thead>
              <tbody>
                {page.content?.map((pageContent) => {
                  return (
                    <TableRow
                      key={pageContent.id}
                      data={formatLocalDate(pageContent.date, 'dd/MM/yyyy')}
                      vendedor={pageContent.seller.name}
                      clientesVisitados={pageContent.visited}
                      negociosFechados={pageContent.deals}
                      valor={pageContent.amount}
                    />
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
};

export default DataTable;
