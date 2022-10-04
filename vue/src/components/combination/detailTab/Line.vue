<template>
  <LineChartGenerator
    :chart-options="chartOptions"
    :chart-data="chartData"
    :chart-id="chartId"
    :dataset-id-key="datasetIdKey"
    :plugins="plugins"
    :css-classes="cssClasses"
    :styles="styles"
    :width="width"
    :height="height"
  />
</template>

<script>
import { Line as LineChartGenerator } from "vue-chartjs/legacy";

import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  LineElement,
  LinearScale,
  CategoryScale,
  PointElement,
} from "chart.js";

ChartJS.register(Title, Tooltip, Legend, LineElement, LinearScale, CategoryScale, PointElement);

export default {
  name: "LineChart",
  components: {
    LineChartGenerator,
  },
  props: {
    statDetail: Object,
    chartId: {
      type: String,
      default: "line-chart",
    },
    datasetIdKey: {
      type: String,
      default: "label",
    },
    width: {
      type: Number,
      default: 200,
    },
    height: {
      type: Number,
      default: 200,
    },
    cssClasses: {
      default: "",
      type: String,
    },
    styles: {
      type: Object,
      default: () => {},
    },
    plugins: {
      type: Array,
      default: () => [],
    },
  },
  data() {
    return {
      chartData: {
        labels: ["10대", "20대", "30대", "40대", "50대", "60대"],
        datasets: [
          {
            backgroundColor: ["#ff8e8e", "#fcb563", "#ffe56f", "#84c484", "#6f9ec4", "#8274b3"],
            data: [],
          },
        ],
      },
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            display: false,
          },
          datalabels: {
            display: false,
          },
          tooltip: {
            boxWidth: 15,
          },
        },
      },
    };
  },
  created() {
    for (const key in this.statDetail) {
      if (
        key == "teenager" ||
        key == "twenties" ||
        key == "thirties" ||
        key == "forties" ||
        key == "fifties" ||
        key == "sixties"
      ) {
        if (this.statDetail[key] >= 0) {
          this.chartData.datasets[0].data.push(this.statDetail[key]);
        }
      }
    }
  },
};
</script>
