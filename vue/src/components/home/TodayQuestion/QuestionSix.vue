<template>
  <div class="q_card">
    <v-card height="250" width="250">
      <div class="pt-6">
        <div class="pa-7 pt-9 pb-9" height="100px" align="center">어떤 음식이 땡겨?</div>
        <div class="ml-8">
          <v-btn class="green_btn mb-3" width="185" small elevation="0" rounded @click="goNext1"
            >닭고기</v-btn
          >
          <v-btn class="main_btn mb-3" width="185" small elevation="0" rounded @click="goNext2"
            >참치</v-btn
          >
          <v-btn class="green_btn" width="185" small elevation="0" rounded @click="goNext3"
            >돼지고기</v-btn
          >
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "QuestionSix",
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
    goNext3() {
      this.ansValue = 3;
      this.$emit("compo-change", this.ansValue);
    },
  },
};
</script>

<style></style>
