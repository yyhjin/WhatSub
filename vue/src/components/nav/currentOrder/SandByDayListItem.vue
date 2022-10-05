<template>
  <div>
    {{ index+1 }}번째 주문
    {{ orderMenu.orderPrice }}
    <v-btn class="main_btn" rounded small @click.stop="openMo = true">상세보기</v-btn>
    <sand-by-order
    v-for="(combination, index) in combinationList" :key="index"
    :combination="combination"
    ></sand-by-order>
    <order-detail-modal
    :orderMenu="orderMenu"
    :value="openMo"
    @input="openMo = $event"
    :date="date"
    ></order-detail-modal>
  </div>
</template>

<script>
import OrderDetailModal from '../OrderDetailModal.vue';
// import api from '@/api/api'
import SandByOrder from './SandByOrder.vue';
export default {
  name: "SandByDayListItem",
  components: { SandByOrder, OrderDetailModal },
  props: {
    orderMenu: Object,
    index:Number,
    date:String
  },

  data() {
    return {
      openMo: false,
    };
  },
 
  computed : {
    combinationList () {
      return this.orderMenu.combinationList
    }
  },


  methods: {
    
  },

  
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
</style>
