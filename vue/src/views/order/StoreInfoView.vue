<template>
  <div class="body">
    <div class="top">
      <v-btn  icon class="backbtn"><v-icon>mdi-arrow-left</v-icon></v-btn>
      픽업 매장 위치
    </div>
    <div class="title">
      {{ store.branchName }}
    </div>
    <store-map 
    :lat="store.lat"
    :lng="store.lng"
    :storeInfoList="[store]"></store-map>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import StoreMap from '../../components/common/StoreMap.vue'
export default {
  components: { StoreMap },
  name: 'StoreInfo',

  computed: {
    ...mapGetters(['basket']),

    store () {
      return this.basket[0].store
    },

    
  }
}
</script>

<style scoped>
.body {
  padding-top: 50px;
  padding-bottom: 40px;
}
.top {
  background-color: white;
  position: fixed;
  top: 0;
  left: 0;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.backbtn {
  position: absolute;
  left: 0;
}
.title {
  height: 50px;
  display: flex;
  align-items: center;
  padding: 20px;
  background-color: #f5f5f5;
  font-size: 5px;
  margin-bottom: 10px;
}
</style>