<template>
  <div class="chooseBread">
    <div class="title">빵 선택</div>
    <bread-item :bread="bread" v-for="bread in breads" :key="bread.name"></bread-item>
  </div>
</template>

<script>
import BreadItem from '@/components/order/BreadItem.vue'
import { mapGetters } from 'vuex'

export default {
  name: 'ChooseBread',

  components: {BreadItem},

  computed: {
    ...mapGetters(['breads'])
  }
}
</script>

<style>
.chooseBread {
  border-top: 1px solid;
  width: 90%;
  margin: auto;
}
</style>