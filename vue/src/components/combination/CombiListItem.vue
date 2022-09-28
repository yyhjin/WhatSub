<template>
  <div class="mb-0">
    <v-card class="sand_big_card">
      <v-row>
        <v-col class="pa-0 mt-3 ml-3" cols="5" align="center" @click="goCombiDetail">
          <v-avatar class="" height="70" width="100" tile
            ><v-img
              height="70"
              width="100"
              src="https://cdn.vuetifyjs.com/images/cards/foster.jpg"
            ></v-img
          ></v-avatar>
          <div class="mt-1">
            <h6 style="font-size: 15px; font-weight: bold">{{ combiListItem.name }}</h6>
          </div>
          <div>
            <h6 style="font-size: 13px; font-weight: 400">{{ combiListItem.price }}원</h6>
          </div>
        </v-col>
        <v-col>
          <div class="mt-1 ml-n4" @click="goCombiDetail">
            <h6 style="font-size: 14px; font-weight: 500">
              메뉴: {{ combiListItem.basic }}<br />추가재료: 아보카도<br />소스: 머스타드
            </h6>
          </div>
          <div class="mt-4 ml-n3">
            <v-icon size="20" color="yellow darken-2">mdi-star</v-icon>
            <span style="font-size: small"> 5</span>
            <v-icon class="ml-2" size="17" color="green darken-2">mdi-message-outline</v-icon>
            <span style="font-size: small"> 20</span>
            <v-icon v-if="!isliked" class="ml-6" size="30" color="grey" @click="clickHeart"
              >mdi-heart-outline</v-icon
            >
            <v-icon v-if="isliked" class="ml-6" size="30" color="red" @click="clickHeart"
              >mdi-heart</v-icon
            >
            <span style="font-size: small"> 20</span>
          </div>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "CombiListItem",
  props: {
    combiListItem: Object,
  },
  data() {
    return {
      isliked: false,
    };
  },
  methods: {
    clickHeart() {
      if (this.isliked) {
        this.isliked = false;
      } else {
        this.isliked = true;
      }
    },
    goCombiDetail() {
      this.$router.push({
        name: "combinationdetail",
      });
    },
  },
};
</script>

<style>
.sand_big_card {
  height: 140px;
  width: 333px;
}
</style>
