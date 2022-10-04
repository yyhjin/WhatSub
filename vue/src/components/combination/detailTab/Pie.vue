<template>
  <Pie
    :chart-options="chartOptions"
    :chart-data="chartData"
    :chart-id="chartId"
    :dataset-id-key="datasetIdKey"
    :plugins="plugins"
    :legend="Legend"
    :css-classes="cssClasses"
    :styles="styles"
    :width="width"
    :height="height"
  />
</template>

<script>
import { Pie } from "vue-chartjs/legacy";

import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, CategoryScale } from "chart.js";

ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale);

export default {
  name: "PieChart",
  components: {
    Pie,
  },
  props: {
    statDetail: Object,
    chartId: {
      type: String,
      default: "pie-chart",
    },
    datasetIdKey: {
      type: String,
      default: "label",
    },
    width: {
      type: Number,
      default: 170,
    },
    height: {
      type: Number,
      default: 170,
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
        labels: [],
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
            display: true,
            position: "right",
          },
        },
      },
    };
  },
  created() {
    for (const key in this.statDetail) {
      if (
        key == "lsah" ||
        key == "lsam" ||
        key == "lseh" ||
        key == "lsem" ||
        key == "lcah" ||
        key == "lcam" ||
        key == "lceh" ||
        key == "lcem" ||
        key == "isah" ||
        key == "isam" ||
        key == "iseh" ||
        key == "isem" ||
        key == "icah" ||
        key == "icam" ||
        key == "iceh" ||
        key == "icem"
      ) {
        if (this.statDetail[key] > 0) {
          this.chartData.labels.push(key.toUpperCase());
          this.chartData.datasets[0].data.push(this.statDetail[key]);
        }
      }
    }
  },
};
</script>
