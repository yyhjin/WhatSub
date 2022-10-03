<template>
  <div>
    <!-- v-for 날짜별 -->
    <div class="mt-3 mb-1">
      <h4 class="ml-n20">{{ date }}</h4>
    </div>
    <div v-for="(orderMenus, index) in orderListByDay" :key="orderMenus.orderId">
      <sand-by-day-list-item
        :index="index"
        :order-menu="orderMenus"
        @openModal="openModal"
        :date="date"
      ></sand-by-day-list-item>
    </div>
    <v-card height="6" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
  </div>
</template>

<script>
import SandByDayListItem from "@/components/nav/currentOrder/SandByDayListItem.vue";

export default {
  name: "SandByDayList",
  components: { SandByDayListItem },
  props: {
    orderListByDay: Array,
    date: String
  },
  data() {
    return {};
  },
  created() {},
  methods: {
    openModal(openAlert) {
      this.$emit("openModal", openAlert);
    },
  },
};
</script>

<style></style>
