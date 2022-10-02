<template>
  <div class="body">
    <div class="top">
      <v-btn  icon class="backbtn"><v-icon>mdi-arrow-left</v-icon></v-btn>
      장바구니
    </div>
    <div class="store">
      서브웨이 {{ store.branchName }}점 
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
import axios from 'axios'
import api from "@/api/api"
import { mapActions, mapGetters } from 'vuex'
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
    },

    store () {
      return this.basket[0].store
    }
  },

  methods: {
    ...mapActions(['fetchBasket']),
    setOrder () {
      let combinationList = []
      this.basket.forEach(bas => {
        const count = bas.cnt
        const price = bas.price
        let combinationId = ""
        let fat = 0
        let kcal = 0
        let protein = 0
        let sodium = 0
        let sugar = 0
        
        for (let value in bas) {
          // console.log(typeof(bas[value]))
          // console.log(Array.isArray(bas[value]))
          if (typeof(bas[value]) === 'object' && bas[value] !== null) {
            // console.log(bas[value])
            if (Array.isArray(bas[value])) {
              bas[value].forEach(each => {
                // console.log(bas[value])
                combinationId += each.ingredientId
                fat += each.fat
                kcal += each.kcal
                protein += each.protein
                sodium += each.sodium
                sugar += each.sugar
              })
            } else {
              if (value === 'menu') {
                // console.log(bas[value])
                combinationId += bas[value].menuId
                fat += bas[value].fat
                kcal += bas[value].kcal
                protein += bas[value].protein
                sodium += bas[value].sodium
                sugar += bas[value].sugar
              } else {
                // console.log(bas[value])
                combinationId += bas[value].ingredientId
                fat += bas[value].fat
                kcal += bas[value].kcal
                protein += bas[value].protein
                sodium += bas[value].sodium
                sugar += bas[value].sugar
              }
            }
          }
        }
      fat = Math.ceil(fat)
      kcal = Math.ceil(kcal)
      protein = Math.ceil(protein)
      sodium = Math.ceil(sodium)
      sugar = Math.ceil(sugar)
      combinationList.push({
        "combinationId": combinationId,
        "count": count,
        "fat": fat,
        "kcal": kcal,
        "price": price,
        "protein": protein,
        "sodium": sodium,
        "sugar": sugar
      })
      })
      const data = {
        "branchId": this.store.branchId,
        "combinationList":combinationList,
        "orderPrice":this.totalPrice,
        "userId":1
      }
      axios({
        url: api.order.order.makeorder(),
        method: 'post',
        data: data
        // headers:getters.authHeader
      }).then(res => {
        console.log(res)
      }).catch(err => {
        console.error(err)
      })
      this.$router.push('/ordercheck') // 요청 성공하면 주소 옮기는게 나을수도
    }
  },

  mounted () {
    this.fetchBasket()
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