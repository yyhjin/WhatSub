<template>
  <div class="body">
    <div class="top">
      <v-btn icon class="backbtn pl-3" @click="goHome"><v-icon>mdi-home-outline</v-icon></v-btn>
      <h4 class="pt-1">픽업 매장 위치</h4>
    </div>
    <div class="title" align="center">
      <h6 cla>서브웨이 {{ store.branchName }}점 (02-501-1554)</h6>
    </div>
    <div class="pt-1 mb-3" align="center">서울특별시 강남구 테헤란로 25길 20</div>
    <store-map :lat="store.lat" :lng="store.lng" :storeInfoList="[store]" :type="1"></store-map>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import BottomNav from "../../components/common/BottomNav.vue";
import StoreMap from "../../components/common/StoreMap.vue";
export default {
  components: { StoreMap, BottomNav },
  name: "StoreInfo",

  computed: {
    ...mapGetters(["basket"]),

    store() {
      return this.basket[0].store;
    },
  },

  methods: {
    goHome() {
      this.$router.push({
        name: "home",
      });
    },
  },
};
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
