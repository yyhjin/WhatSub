<template>
  <v-bottom-navigation :value="bottomValue - 1" color="teal" absolute>
    <v-btn class="clickBtn" @click="[routerPushes('home'), fetchBottomValue(1)]">
      <span>홈</span>
      <v-icon>mdi-home</v-icon>
    </v-btn>

    <v-btn class="clickBtn" @click="[routerPushes('rank'), fetchBottomValue(2)]">
      <span>랭킹</span>
      <v-icon>mdi-equalizer</v-icon>
    </v-btn>

    <v-btn class="clickBtn" @click="[routerPushes('combination'), fetchBottomValue(3)]">
      <span>꿀조합</span>
      <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn class="clickBtn" @click="[routerPushes('orderone'), fetchBottomValue(4)]">
      <span>주문</span>
      <v-icon>mdi-cart-arrow-down</v-icon>
    </v-btn>

    <v-btn class="clickBtn" @click="[routerPushes('mypage'), fetchBottomValue(5)]">
      <span>프로필</span>
      <v-icon>mdi-account</v-icon>
    </v-btn>
  </v-bottom-navigation>
</template>

<script>
import router from "@/router";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "BottomNav",
  data() {
    return {
      value: this.bottomValue,
    };
  },
  computed: {
    ...mapGetters(["bottomValue", "sampleUserName"]),
  },
  methods: {
    ...mapActions(["fetchBottomValue", "getMyList"]),
    routerPushes(icon) {
      router.push({ name: icon });
    },
    // clickMyPage(userName) {
    //   this.getMyList({
    //     userName: userName,
    //   });
    // },
  },
  watch: {
    "$store.state.bottomValue": function () {},
  },
};
</script>

<style>
.v-btn.clickBtn {
  color: #239347 !important;
  width: calc(100% / 5) !important;
}

.v-item-group.v-bottom-navigation .v-btn {
  min-width: 50px;
}
</style>
