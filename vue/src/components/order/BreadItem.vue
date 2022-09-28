<template>
  <div class="bread">
    <button class="oneChoose" @click="selectBread"></button>
    <div class="title">{{ bread.name }}</div>
    <div class="price">+{{ bread.price }}원</div>
  </div>
</template>

<script>
export default {
  name: 'BreadItem',

  props:{
    bread:Object
  }
}
</script>

<style scoped>
.bread {
  margin-top: 10px;
  margin-bottom: 10px;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.price {
  position: relative;
  right: 0;
  margin-left: auto;
}
.title {
  width: 70%;
}
.oneChoose {
  width: 24px;
  height: 24px;
  border-radius: 50%;
  border: 8px solid  #D9D9D9;
  margin-right: 5px;
}


</style>