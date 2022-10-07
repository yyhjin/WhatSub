<template>
  <div class="q_card">
    <v-card height="250" width="250">
      <div class="pt-6">
        <h4 align="center"><span class="fir">오늘의</span> <span class="sec">추천</span></h4>
        <div class="pa-7 pt-9 pb-9" align="center">
          간단한 질문의 답변을 통해 오늘 먹을 샌드위치 메뉴를 추천 받을 수 있습니다.
        </div>
        <div class="ml-8">
          <v-btn class="green_btn" width="185" small elevation="0" rounded @click="startTodayReco"
            >시작하기</v-btn
          >
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "ResultRecommendToday",
  methods: {
    startTodayReco() {
      this.$emit("compo-change");
    },
  },
};
</script>

<style scoped>
span.fir {
  color: #239347;
}
span.sec {
  color: #f4c41f;
}
</style>
