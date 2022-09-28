<template>
  <div>
    <div class="pt-6 pl-6"><h4>My 컬렉션</h4></div>
    <div class="verti_combi no-scroll">
      <div class="collec_card" v-for="(collectionInfoItem, index) in collectionInfo" :key="index">
        <collection-list-item :collection-info-item="collectionInfoItem"></collection-list-item>
      </div>
    </div>
    <div>
      <v-tabs v-model="tab">
        <v-tabs-slider color="#239347"></v-tabs-slider>
        <v-tab class="tab_text_color" v-for="item in items" :key="item">
          <h3>{{ item }}</h3>
        </v-tab>
      </v-tabs>
      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item">
          <v-card v-if="item == '꿀조합 목록'" flat>
            <div class="pt-4 pl-6 pr-6">
              <sand-small-list></sand-small-list>
            </div>
          </v-card>
          <v-card v-else flat>
            <div>
              <sand-big-list></sand-big-list>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
  </div>
</template>

<script>
import CollectionListItem from "@/components/profile/CollectionListItem.vue";
import SandSmallList from "@/components/common/SandSmallList.vue";
import SandBigList from "@/components/common/SandBigList.vue";

export default {
  name: "CollectionList",
  components: { CollectionListItem, SandSmallList, SandBigList },
  data() {
    return {
      tab: null,
      items: ["꿀조합 목록", "찜 목록"],
    };
  },
  props: {
    collectionInfo: Array,
  },
};
</script>

<style>
.tab_text_color {
  color: black !important;
  caret-color: black !important;
}
</style>
