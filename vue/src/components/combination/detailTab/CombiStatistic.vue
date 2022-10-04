<template>
  <div>
    <div class="mt-3" align="center" style="font-size: 18px; font-weight: bold">썹BTI 통계</div>
    <div class="mt-2">
      <pie-chart :stat-detail="combiDetail"></pie-chart>
    </div>
    <br />
    <v-card height="1" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <br />
    <div class="" align="center" style="font-size: 18px; font-weight: bold">성별 통계</div>
    <div class="mt-2">
      <bar-chart :stat-detail="combiDetail"></bar-chart>
    </div>
    <br />
    <v-card height="1" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <br />
    <div class="" align="center" style="font-size: 18px; font-weight: bold">연령대 통계</div>
    <div class="mt-2">
      <line-chart :stat-detail="combiDetail"></line-chart>
    </div>
    <br />
    <br />
  </div>
</template>

<script>
import PieChart from "@/components/combination/detailTab/Pie.vue";
import BarChart from "@/components/combination/detailTab/Bar.vue";
import LineChart from "@/components/combination/detailTab/Line.vue";

export default {
  name: "CombiStatistic",
  props: {
    combiDetail: Object,
  },
  components: {
    PieChart,
    BarChart,
    LineChart,
  },
  created() {
    console.log(this.combiDetail);
  },
};
</script>

<style></style>
