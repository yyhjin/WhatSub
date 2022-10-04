<template>
  <div>
    {{ index+1 }}번째 주문
    {{ orderMenu.orderPrice }}
    <sand-by-order
    v-for="(combination, index) in combinationList" :key="index"
    :combination="combination"
    ></sand-by-order>
  </div>
</template>

<script>
// import api from '@/api/api'
import SandByOrder from './SandByOrder.vue';
export default {
  name: "SandByDayListItem",
  components: { SandByOrder },
  props: {
    orderMenu: Object,
    index:Number
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
