<template>
  <div class="">
    <v-container>
      <v-row>
        <v-col>
          <h3 style="font-size: 16px">리뷰({{ combiReview.length }})</h3>
        </v-col>
      </v-row>
    </v-container>
    <v-card height="1" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div v-for="(combiReviewItem, index) in combiReview" :key="index">
      <review-list-item :combi-review-item="combiReviewItem"></review-list-item>
    </div>
    <v-card height="3" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <br />
    <br />
    <br />
  </div>
</template>

<script>
import ReviewListItem from "@/components/combination/ReviewListItem.vue";

export default {
  name: "ReviewList",
  components: { ReviewListItem },
  props: {
    combiReview: Array,
  },
};
</script>

<style></style>
