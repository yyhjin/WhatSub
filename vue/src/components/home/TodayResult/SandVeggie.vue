<template>
  <div>
    <div class="r_card">
      <v-card height="250" width="250">
        <div class="pt-6">
          <h3 align="center">베지</h3>
        </div>
        <div class="pt-3 pb-5" align="center">
          <v-img
            class="shadow_img"
            height="110"
            width="200"
            src="https://whatsub.s3.ap-northeast-2.amazonaws.com/SUBWAY/Sandwich/Veggie-Delite.png"
          ></v-img>
        </div>
        <div align="center">
          <v-btn class="green_btn" width="200" elevation="0" small rounded @click="startTodayReco"
            >베지 꿀조합 보러가기</v-btn
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
export default {
  name: "SandVeggie",
  methods: {
    goTodayReco() {
      this.$router.go(0);
    },
  },
};
</script>

<style></style>
