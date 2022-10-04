<template>
  <div>
    <v-card class="sand_big_card">
      <v-row>
        <v-col class="pa-0 mt-3 ml-3" cols="5" align="center" >
          <v-avatar class="" height="70" width="100" tile
            ><v-img
              height="70"
              width="100"
              src="https://cdn.vuetifyjs.com/images/cards/foster.jpg"
            ></v-img
          ></v-avatar>
          <div class="mt-1">
            <h6 style="font-size: 15px; font-weight: bold">{{ sand.combName }}</h6>
          </div>
          <div>
            <h6 style="font-size: 13px; font-weight: 400">
              {{ sand.combination.price | comma }}원
            </h6>
          </div>
        </v-col>
        <v-col>
          <div class="mt-1 ml-n4" >
            <h6 style="font-size: 14px; font-weight: 500">
              메뉴: {{ sand.menuName }}<br />추가재료: {{ others[0] }}···<br />소스:
              {{ sauce[0] }}···
            </h6>
          </div>
          <div class="mt-4 ml-n3">
            <v-icon size="20" color="yellow darken-2">mdi-star</v-icon>
            <span style="font-size: small"> {{ sand.scoreAvg }}</span>
            <v-icon class="ml-2" size="17" color="green darken-2">mdi-message-outline</v-icon>
            <span style="font-size: small"> {{ sand.reviewCnt }}</span>
            <v-icon v-if="!isliked" class="ml-6" size="30" color="grey" @click="clickHeart"
              >mdi-heart-outline</v-icon
            >
            <v-icon v-if="isliked" class="ml-6" size="30" color="red" @click="clickHeart"
              >mdi-heart</v-icon
            >
            <span style="font-size: small"> {{ sand.likesCnt }}</span>
          </div>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "SandBigListItem",
  props: {
    sandListItem: Object,
  },

  computed: {
    sand () {
      return this.sandListItem.combinationPostDto
    }
  }
};
</script>

<style>
.sand_big_card {
  height: 140px;
  width: 333px;
}
.sand_big_card:last-child {
  margin-bottom: 10px;
}
</style>
