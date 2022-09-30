<template>
  <div class="body">
    <div class="top">
      주문완료!
    </div>
    <div class="time">
      <p>
        주문 번호: <span>129번</span>
      </p>
      <p>
        <span>10~15분</span>정도 소요될 예정이에요.
      </p>
    </div>
    <div class="store">
      서브웨이 역삼점
    </div>
    <div class="orderCheck">
      주문내역
      <order-detail :bas="bas" v-for="(bas, index) in basket" :key="index"></order-detail>
    </div>
    <div class="checkStore">
      예상 시간에 맞춰 매장에 방문해주세요!
      <div align="center" class="order_btn">
        <v-btn class="main_btn" width="185" small elevation="0" rounded >픽업 매장 확인하기</v-btn>
      </div>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import OrderDetail from '../../components/common/OrderDetail.vue'
import BottomNav from '@/components/common/BottomNav.vue'
import { mapGetters } from 'vuex'
export default {
  components: { OrderDetail, BottomNav },
  name: 'OrderCheckView',

  computed: {
    ...mapGetters(['basket'])
  },

  unmounted() {
    localStorage.clear()
  }
  
}
</script>

<style scoped>
.body {
  padding-top: 70px;
}
.top {
  position: fixed;
  top: 0;
  height: 70px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #239347;
  color: #f4c41f;
  font-weight: bold;
}

.time{
  height: 150px;
  width: 100%;
  border: 1px solid;   /* 나중에 지울 거 */
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
}
p {
  font-size: 15px;
}
span {
  font-size: 30px;
  color: red;
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
  height: 300px;
  overflow: scroll;
  background-color: #F5F5F5;
  text-align: center;
}
.checkStore {
  margin-top: 20px;
  height: 60px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
</style>