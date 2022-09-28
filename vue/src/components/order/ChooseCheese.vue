<template>
  <div class="chooseCheese">
    <div class="title">치즈 선택</div>
    <cheese-item></cheese-item>
  </div>
</template>

<script>
import CheeseItem from './CheeseItem.vue'

export default {
  components: { CheeseItem },
  name: 'ChooseCheese',

  
}
</script>

<style>
.chooseCheese {
  border-top: 1px solid;
  width: 90%;
  margin: auto;
}
</style>