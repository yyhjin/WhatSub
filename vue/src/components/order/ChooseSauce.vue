<template>
  <div>
    <div class="chooseSauce">
      <div class="title">소스 선택(최대 3개)</div>
      <sauce-item :sa="sa" v-for="sa in sauce" :key="sa.name"></sauce-item>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import SauceItem from './SauceItem.vue'
export default {
  name: 'ChooseSauce',

  components: { SauceItem },

  computed: {
    ...mapGetters(['sauce'])
  }
}
   
</script>

<style>
.chooseSauce {
  border-top: 1px solid;
  width: 90%;
  margin: auto;
}
</style>