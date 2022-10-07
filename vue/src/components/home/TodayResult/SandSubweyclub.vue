<template>
  <div>
    <div class="r_card">
      <v-card height="250" width="250">
        <div class="pt-6">
          <h3 align="center">써브웨이 클럽</h3>
        </div>
        <div class="pt-3 pb-5" align="center">
          <v-img
            class="shadow_img"
            height="110"
            width="200"
            src="https://whatsub.s3.ap-northeast-2.amazonaws.com/SUBWAY/Sandwich/Subway-Club.png"
          ></v-img>
        </div>
        <div align="center">
          <v-btn class="green_btn" width="220" elevation="0" small rounded @click="goCombiTab"
            >써브웨이 클럽 꿀조합 보러가기</v-btn
          >
        </div>
      </v-card>
    </div>
    <div class="mt-10" align="center">
      <v-btn class="grey_btn" width="185" elevation="0" rounded small @click="goTodayReco"
        >오늘의 추천 다시 받기</v-btn
      >
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";

export default {
  name: "SandSubweyclub",
  computed: {
    ...mapGetters(["profile"]),
  },
  methods: {
    ...mapActions(["getFilteringMenu", "fetchProfile"]),
    goTodayReco() {
      this.$router.go(0);
    },
    goCombiTab() {
      this.fetchProfile();
      this.getFilteringMenu({
        menuId: "j",
        userId: this.profile.userId,
      });
      this.$router.push({
        name: "combination",
      });
    },
  },
};
</script>

<style></style>
