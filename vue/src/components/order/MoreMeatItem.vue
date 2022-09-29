<template>
  <div class="moreMeat">
    <button class="oneChoose" @click="selectBread"></button>
    <div class="title">{{ moreMeat.name }}</div>
    <div class="price">+{{ moreMeat.price }}원</div>
  </div>
</template>

<script>
export default {
  name: 'MoreMeatItem',

  props: {
    moreMeat: Object
  }
}
</script>

<style scoped>
.moreMeat {
  margin-top: 10px;
  margin-bottom: 10px;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.oneChoose {
  width: 24px;
  height: 24px;
  border-radius: 50%;
  border: 8px solid  #D9D9D9;
  margin-right: 5px;
}
.price {
  position: relative;
  right: 0;
  margin-left: auto;
}
.title {
  width: 70%;
}

</style>