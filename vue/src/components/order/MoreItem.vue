<template>
  <div class="more">
    <input type="checkbox" name="more" class="multiChoose" @click="selectVege">
    <div class="title">{{ mo.name }}</div>
    <div class="price">+{{ mo.price }}원</div>
  </div>
</template>

<script>
export default {
  name: 'MoreItem',

  props: {
    mo:Object
  }
}
</script>

<style scoped>
.more {
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
.multiChoose {
  width: 25px;
  height: 25px;
  
  border: 8px solid  #D9D9D9;
  margin-right: 5px;
}
</style>