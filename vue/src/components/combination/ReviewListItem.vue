<template>
  <div>
    <v-container>
      <v-row align="center">
        <v-col cols="2">
          <v-avatar size="45" color="#d9d9d9" @click="goProfile"></v-avatar>
        </v-col>
        <v-col cols="6">
          <div style="font-size: 13px" @click="goProfile">김계란 | 2022-09-28 &nbsp;16:26</div>
          <div>
            <v-rating
              v-model="rating"
              color="yellow darken-2"
              background-color="yellow darken-2"
              size="18"
              half-increments
              hover
              readonly
            ></v-rating>
          </div>
        </v-col>
        <v-col align="center">
          <div style="font-size: 13px">
            <span style="color: grey" @click="udpateReview">수정&nbsp;&nbsp; </span>
            <span style="color: red" @click="deleteReview">삭제</span>
          </div>
        </v-col>
      </v-row>
    </v-container>
    <v-card elevation="0" class="mb-5 mr-10 ml-10">
      <br />
      <br />
    </v-card>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
  </div>
</template>

<script>
export default {
  name: "ReviewListItem",
  data() {
    return {
      rating: 5,
    };
  },
  methods: {
    udpateReview() {
      console.log("updateReview");
    },
    deleteReview() {
      console.log("deleteReview");
    },
    goProfile() {
      this.$router.push({ name: "mypage" });
    },
  },
};
</script>

<style></style>
