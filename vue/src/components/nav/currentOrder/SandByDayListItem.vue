<template>
  <div>
    <v-card class="sand_big_card"
      >{{ orderMenu.sand }}
      <v-btn class="green_btn" rounded small @click="goRegistForm">리뷰등록</v-btn>
      <v-btn class="main_btn" rounded small>상세보기</v-btn>
    </v-card>
    <alert-combi :value="openAlert" @input="openAlert = $event"></alert-combi>
  </div>
</template>

<script>
import AlertCombi from "@/components/nav/AlertCombi.vue";
export default {
  name: "SandByDayListItem",
  components: { AlertCombi },
  props: {
    orderMenu: Object,
  },
  data() {
    return {
      isRegisted: false,
      openAlert: false,
    };
  },
  methods: {
    goRegistForm() {
      //꿀조합 여부 확인

      //리뷰 등록할 꿀조합이 있다면 리뷰 등록 화면으로 이동
      if (this.isRegisted) {
        this.$router.push({ name: "registreview" });
      } else {
        //리뷰 등록할 꿀조합이 없다면 AlertCombi 띄워주기
        this.openAlert = true;
      }
    },
  },
};
</script>

<style scoped>
.sand_big_card {
  height: 140px;
  width: 333px;
  margin-bottom: 20px;
}
.sand_big_card:last-child {
  margin-bottom: 25px;
}
</style>
