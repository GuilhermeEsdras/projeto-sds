import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';

import { BASE_URL } from 'api/requests';
import axios from 'axios';
import LoadingBars from 'components/LoadingBars';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';

type SeriesData = {
  name: string;
  data: number[];
};

type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
};

const BarChart = () => {
  const [loading, setLoading] = useState(true);
  const [chartData, setChartData] = useState<ChartData>({
    labels: {
      categories: [],
    },
    series: [
      {
        name: '',
        data: [],
      },
    ],
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`).then((response) => {
      const data: SaleSuccess[] = response.data;
      const myLabels = data.map((x) => x.sellerName);
      const mySeries = data.map((x) => round((100.0 * x.deals) / x.visited, 1));

      setChartData({
        labels: { categories: myLabels },
        series: [
          {
            name: '% Success',
            data: mySeries,
          },
        ],
      });
      setLoading(false);
    });
  }, []);

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  return loading ? (
    <LoadingBars />
  ) : (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
};

export default BarChart;
