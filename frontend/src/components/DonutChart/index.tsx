import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';

import { BASE_URL } from 'api/requests';
import axios from 'axios';
import LoadingBars from 'components/LoadingBars';
import { SaleSum } from 'types/sale';

type ChartData = {
  labels: string[];
  series: number[];
};

const DonutChart = () => {
  const [loading, setLoading] = useState(true);
  const [chartData, setChartData] = useState<ChartData>({
    labels: [],
    series: [],
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/amount-by-seller`).then((response) => {
      const data: SaleSum[] = response.data;
      const myLabels = data.map((x) => x.sellerName);
      const mySeries = data.map((x) => x.sum);

      setChartData({ labels: myLabels, series: mySeries });
      setLoading(false);
    });
  }, []);

  const options = {
    legend: {
      show: true,
    },
  };

  return loading ? (
    <LoadingBars />
  ) : (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
};

export default DonutChart;
