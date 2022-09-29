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
    <order-detail></order-detail>
  </div>
</template>

<script>
import OrderDetail from '../../components/common/OrderDetail.vue'
export default {
  components: { OrderDetail },
  name: 'OrderCheckView'
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
</style>