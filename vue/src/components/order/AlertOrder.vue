<template>
  <div class="modal">
    <div class="alert">
      <div class="comment">
        <p>장바구니에 담았습니다.</p>
        <p>메뉴를 추가로 더 담으시겠습니까?</p>
      </div>
      <button class="order_btn main_btn" @click.prevent="goFirst">
          예, 더 담을게요
      </button>
      <button class="order_btn green_btn" @click.prevent="goBasket">
        장바구니로 이동
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "AlertOrder",

  methods: {
    goBasket () {
      this.$router.push('/orderbasket')
    },

    goFirst () {
      this.$router.replace('/ordertwo')
    }
  }
}
</script>

<style scoped>
.alert {
  position: relative;
  top: 250px;
  margin: auto;
  text-align: center;
  font-weight: bold;
  height: 220px;
  width: 320px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border: 5px solid #f4c41f;
  border-radius: 30px;
  background-color: white;
  /* display: none; */
}
.modal {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100vh;
  background-color: rgba(0,0,0,0.4);
  z-index: 1500;
  display: none;
}


.order_btn {
  margin: 5px;
  width: 150px;
  height: 30px;
  border-radius: 15px;
}
</style>