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
    <div align="center" v-for="(OrderListByDay, date) in orderList" :key="date">
      <!-- v-for 전체 주문 -->
      <sand-by-day-list
        :order-list-by-day="OrderListByDay"
        :date="date"
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
import { mapActions, mapGetters } from 'vuex';

export default {
  name: "OrderDetailView",
  components: { BottomNav, SandByDayList },
  data() {
    return {
      openAlert: false,
      
    };
  },

  computed: {
    ...mapGetters(['currentUser', 'order', 'profile']),

    orderList () {
      let olist = {}
      this.order.forEach(each => {
        const i = each.orderedAt.indexOf("T")
        const day = each.orderedAt.substr(0, i)
        if (olist[day]) {
          const or = {
          "branchId" : each.branchId,
          "combinationList" : each.combinationList,
          "orderId" : each.orderId,
          "orderPrice" : each.orderPrice,
          "userId" : each.userId
        }
        olist[day].push(or)
        } else {
          olist[day] = []
          const or = {
            "branchId" : each.branchId,
            "combinationList" : each.combinationList,
            "orderId" : each.orderId,
            "orderPrice" : each.orderPrice,
            "userId" : each.userId
          }
          olist[day].push(or)
          }
      })
      return olist
    }
  },

  methods: {
    ...mapActions(['fetchOrder', 'fetchProfile']),
    goBack() {
      this.$router.go(-1);
    },
    openModal(openAlert) {
      this.openAlert = openAlert;
    },
  },

  mounted () {
    this.fetchProfile().then(
      this.fetchOrder(this.profile.userName)
    )

  }
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
