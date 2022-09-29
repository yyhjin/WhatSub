<template>
  <div class="">
    <v-container>
      <v-row>
        <v-col>
          <h3 style="font-size: 16px">리뷰(3)</h3>
        </v-col>
        <v-col class="mt-1" cols="4" style="font-size: 13px">평점순 | 최신순</v-col>
      </v-row>
    </v-container>
    <v-card height="1" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
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
