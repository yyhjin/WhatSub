<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-5"><h3>최근 주문 내역</h3></v-col>
      </v-row>
    </div>
    <div class="pt-12"></div>
    <div align="center" v-for="OrderListByDay in OrderList" :key="OrderListByDay.orderId">
      <!-- v-for 전체 주문 -->
      <sand-by-day-list
        :order-list-by-day="OrderListByDay"
        @openModal="openModal"
      ></sand-by-day-list>
    </div>
    <br />
    <br />
    <br />
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from "@/components/common/BottomNav.vue";
import SandByDayList from "@/components/nav/currentOrder/SandByDayList.vue";

export default {
  name: "OrderDetailView",
  components: { BottomNav, SandByDayList },
  data() {
    return {
      openAlert: false,
      OrderList: [
        {
          id: 1,
          date: "2022-09-30",
          menu: [
            {
              orderId: 1,
              sand: "aaaa1",
              price: 5400,
            },
            {
              orderId: 2,
              sand: "aaaa2",
              price: 6400,
            },
            {
              orderId: 3,
              sand: "aaaa3",
              price: 7400,
            },
          ],
        },
        {
          id: 2,
          date: "2022-09-29",
          menu: [
            {
              orderId: 1,
              sand: "bbbb1",
              price: 5400,
            },
            {
              orderId: 2,
              sand: "bbbb2",
              price: 6400,
            },
          ],
        },
      ],
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    openModal(openAlert) {
      this.openAlert = openAlert;
    },
  },
};
</script>

<style scoped>
.top {
  padding: 10px;
  position: fixed;
  width: 100%;
  z-index: 2;
}
.bottom {
  position: fixed;
  width: 100%;
  bottom: 0;
}
</style>
