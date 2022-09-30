<template>
  <div class="body">
    <div class="top">
      <v-btn  icon class="backbtn"><v-icon>mdi-arrow-left</v-icon></v-btn>
      장바구니
    </div>
    <div class="store">
      서브웨이 역삼점 
    </div>
    <div class="orderCheck">
      <order-basket :bas="bas" :index="index" v-for="(bas, index) in basket" :key="index"></order-basket>
    </div>
    <div class="bottom">
      <div class="total_price">
        총 {{ totalPrice }}원
      </div>
      
      <button class="order_btn green_btn" @click.prevent="setOrder">
        주문하기
      </button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
// import OrderDetail from '../../components/common/OrderDetail.vue'
import OrderBasket from '../../components/order/OrderBasket.vue'
export default {
  name: 'OrderBasketView',

  components: { OrderBasket },

  computed: {
    ...mapGetters(['basket']),

    totalPrice () {
      let price = 0
      this.basket.forEach(bas => price += bas.price)
      return price
    }
  },

  methods: {
    setOrder () {
      this.$router.push('/ordercheck')
    }
  }
}
</script>

<style scoped>
.body {
  padding-top: 50px;
  padding-bottom: 40px;
}
.top {
  background-color: white;
  position: fixed;
  top: 0;
  left: 0;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.store{
  height: 50px;
  width: 100%;
  background-color: #F5F5F5;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2px;
}
.orderCheck{
  width: 100%;
  /* height: 300px; */
  overflow: scroll;
  background-color: #F5F5F5;
  text-align: center;
}
.top::after {
  content: "";
  position: relative;
}
.backbtn {
  position: absolute;
  left: 0;
}
.bottom {
  height: 40px;
  position: fixed;
  bottom: 0;
  background: white;
  border-top: 1px solid;
  z-index: 4;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
}
.order_btn {
  width: 200px;
  height: 30px;
  border-radius: 15px;
}

</style>