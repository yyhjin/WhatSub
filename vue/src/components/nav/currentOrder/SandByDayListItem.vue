<template>
  <div class="cardwrap">
    <div class="ordertitle">
      <h4 class="pt-2" style="font-size: 14px">{{ index + 1 }}번째 주문</h4>
      <v-btn class="grey_btn" rounded small @click.stop="openMo = true">자세히 보기</v-btn>
    </div>
    <sand-by-order
      v-for="(combination, index) in combinationList"
      :key="index"
      :combination="combination"
    ></sand-by-order>
    <v-divider></v-divider>
    <order-detail-modal
      :orderMenu="orderMenu"
      :value="openMo"
      @input="openMo = $event"
      :date="date"
    ></order-detail-modal>
  </div>
</template>

<script>
import OrderDetailModal from "../OrderDetailModal.vue";
// import api from '@/api/api'
import SandByOrder from "./SandByOrder.vue";
export default {
  name: "SandByDayListItem",
  components: { SandByOrder, OrderDetailModal },
  props: {
    orderMenu: Object,
    index: Number,
    date: String,
  },

  data() {
    return {
      openMo: false,
    };
  },

  computed: {
    combinationList() {
      return this.orderMenu.combinationList;
    },
  },

  methods: {},
};
</script>

<style scoped>
.sand_big_card {
  height: 140px;
  width: 90%;
  margin: auto;
  margin-bottom: 20px;
  display: flex;
}
.sand_big_card:last-child {
  margin-bottom: 25px;
}
.first {
  width: 40%;
}
.second {
  width: 60%;
}
.ordertitle {
  margin-top: 12px;
  margin-bottom: 20px;
  justify-content: space-between;
  width: 90%;
  display: flex;
  flex-direction: row;
}
.cardwrap {
  width: 95%;
}
</style>
