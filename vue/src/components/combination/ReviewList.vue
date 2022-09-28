<template>
  <div class="">
    <v-container>
      <v-row>
        <v-col>
          <h3>리뷰(3)</h3>
        </v-col>
        <v-col cols="5">평점순 | 최신순</v-col>
      </v-row>
    </v-container>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div v-for="(item, index) in 10" :key="index">
      <review-list-item></review-list-item>
    </div>
  </div>
</template>

<script>
import ReviewListItem from "@/components/combination/ReviewListItem.vue";
export default {
  name: "ReviewList",
  components: { ReviewListItem },
};
</script>

<style></style>
