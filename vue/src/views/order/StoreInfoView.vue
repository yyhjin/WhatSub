<template>
  <div>
    <div class="top" style="position: relative">
      <top-nav></top-nav>
    </div>
    <div>
      <div align="center" style="height: 5vh"><h3>지점 선택</h3></div>
      <search-store-map />
    </div>
    <div style="padding: 10px">
      <div v-if="selectedStore == null">지점을 선택해주세요</div>
      <div v-else>
        <v-row align="center" justify="center">
          <v-col cols="8">
            <h3>{{ selectedStore.branchName }}점</h3>
            <div>{{ selectedStore.contactNo }}</div>
            <div>{{ selectedStore.streetAddress }}</div>
          </v-col>
          <v-col cols="4" align="center">
            <v-btn class="main_btn">주문하기</v-btn>
          </v-col>
        </v-row>
      </div>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import SearchStoreMap from "../../components/order/SearchStoreMap.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import { mapGetters } from "vuex";

export default {
  components: { SearchStoreMap, TopNav, BottomNav },
  name: "StoreInfoView",

  computed: {
    ...mapGetters(["selectedStore"]),
  },
};
</script>

<style></style>
