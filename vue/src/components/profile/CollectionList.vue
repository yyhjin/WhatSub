<template>
  <div>
    <div
      class="mt-6 pt-3 pb-3 mb-1"
      style="background-color: #f4c41f; border-top: 5px solid #239347"
      align="center"
    >
      <h4 style="color: white">My 컬렉션 ({{ pro.collections.length }})</h4>
    </div>
    <div class="verti_combi no-scroll">
      <div class="collec_card" v-for="(collectionItem, index) in pro.collections" :key="index">
        <collection-list-item :collection-item="collectionItem"></collection-list-item>
      </div>
    </div>
    <br />
    <div>
      <v-tabs
        v-model="tab"
        fixed-tabs
        background-color="#239347"
        slider-size="5"
        dark
        style="border-color: #f4c41f"
      >
        <v-tabs-slider color="#f4c41f"></v-tabs-slider>
        <v-tab class="" v-for="item in items" :key="item">
          <h3>{{ item }}</h3>
        </v-tab>
      </v-tabs>
      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item">
          <v-card v-if="item === items[0]" flat>
            <div class="pt-5 pl-6 pr-6">
              <sand-small-list :combi-list="pro.combs"></sand-small-list>
            </div>
          </v-card>
          <v-card v-else flat>
            <div class="pt-1">
              <sand-big-list :zzim-list="pro.dibs"></sand-big-list>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
  </div>
</template>

<script>
import CollectionListItem from "@/components/profile/CollectionListItem.vue";
import SandSmallList from "@/components/common/mypage/SandSmallListMyCombi.vue";
import SandBigList from "@/components/common/mypage/SandBigListMyPage.vue";
// import { mapGetters, mapActions } from "vuex";

export default {
  name: "CollectionList",
  components: { CollectionListItem, SandSmallList, SandBigList },
  data() {
    return {
      tab: null,
      items: [`꿀조합 목록 (${this.pro.combs.length})`, `찜 목록 (${this.pro.dibs.length})`],
    };
  },
  props: {
    pro:Object
  },
  
};
</script>

<style>
.tab_text_color {
  color: black !important;
  caret-color: black !important;
}
</style>
