<template>
  <div class="chooseCheese">
    <div class="title">치즈 선택</div>
    <cheese-item  :chee="chee" v-for="chee in cheese" :key="chee.name"></cheese-item>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import CheeseItem from './CheeseItem.vue'

export default {
  name: 'ChooseCheese',

  components: { CheeseItem },

  computed: {
    ...mapGetters(['cheese'])
  }
  
}
</script>

<style>
.chooseCheese {
  border-top: 1px solid;
  width: 90%;
  margin: auto;
}
</style>