<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="pt-15 pl-5 pr-5 pb-3">
      <h3 style="font-size: 22px; float: left">꿀조합 추천</h3>
      <v-spacer></v-spacer>
      <v-btn class="green_btn" height="32" rounded style="float: right">꿀조합 등록</v-btn>
      <div class="mt-6">
        <div class="pt-8 ml-n2 mb-n10">
          <h2 style="position: relative; z-index: 2; transform: rotate(-35deg); width: 10px">
            <span class="fir">BEST</span><span class="sec">!</span>
          </h2>
        </div>
      </div>
      <div class="">
        <v-card class="sand_big_card" style="position: relative; z-index: 1"></v-card>
      </div>
    </div>
    <v-divider></v-divider>
    <div>
      <combi-list></combi-list>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import CombiList from "@/components/combination/CombiList.vue";

export default {
  name: "CombinationView",
  components: { TopNav, BottomNav, CombiList },
};
</script>

<style></style>
