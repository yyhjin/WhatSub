<template>
  <div class="q_card">
    <v-card height="250" width="250">
      <div class="pt-6">
        <div class="pa-7 pt-9 pb-9" height="100px" align="center">슬라이스 치킨 vs. 닭가슴살</div>
        <div class="ml-8 mt-6">
          <v-btn class="green_btn mb-3" width="185" small elevation="0" rounded @click="goNext1"
            >슬라이스 치킨</v-btn
          >
          <v-btn class="main_btn" width="185" small elevation="0" rounded @click="goNext2"
            >닭가슴살</v-btn
          >
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "QuestionFifteen",
  data() {
    return {
      ansValue: 0,
    };
  },
  methods: {
    goNext1() {
      this.ansValue = 1;
      this.$emit("compo-change", this.ansValue);
    },
    goNext2() {
      this.ansValue = 2;
      this.$emit("compo-change", this.ansValue);
    },
  },
};
</script>

<style></style>
