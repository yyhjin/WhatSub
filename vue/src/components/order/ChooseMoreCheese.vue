<template>
  <div class="chooseCheese">
    <div class="title">치즈 추가 선택(1개)</div>
    <more-cheese-item :moreChe="moreChe" v-for="moreChe in moreCheese" :key="moreChe.name"></more-cheese-item>
  </div>
</template>

<script>

import { mapGetters } from 'vuex'
import MoreCheeseItem from './MoreCheeseItem.vue'

export default {
  name: 'ChooseMoreCheese',

  components: {MoreCheeseItem},

  computed: {
    ...mapGetters(['moreCheese'])
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