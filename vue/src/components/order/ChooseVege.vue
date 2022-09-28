<template>
  <div class="chooseVege">
    <div class="title">야채 선택(최대 8개)</div>
    <vege-item :vege="vege" v-for="vege in veges" :key="vege.name"></vege-item>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import VegeItem from './VegeItem.vue'
export default {
  name: 'ChooseVege',

  components: { VegeItem },

  computed: {
    ...mapGetters(['veges'])
  }
}
</script>

<style>
.chooseVege {
  border-top: 1px solid;
  width: 90%;
  margin: auto;
}
</style>