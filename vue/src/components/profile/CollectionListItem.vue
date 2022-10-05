<template>
  <div>
    <v-card align="center" height="120" width="100" elevation="0">
      <div class="pa-1">
        <v-avatar size="70" tile
          ><img
            v-if="collectionItem.ranking == 1"
            src="https://whatsub.s3.ap-northeast-2.amazonaws.com/default/gold.png"
            alt="rank image"
          />
          <img
            v-if="collectionItem.ranking == 2"
            src="https://whatsub.s3.ap-northeast-2.amazonaws.com/default/silver.png"
            alt="rank image"
          />
          <img
            v-if="collectionItem.ranking == 3"
            src="https://whatsub.s3.ap-northeast-2.amazonaws.com/default/bronze.png"
            alt="rank image"
          />
        </v-avatar>
      </div>
      <div>
        <h5>
          {{ collectionItem.menuName }}
        </h5>
        <h5>{{ rankingDate }}<br />{{ collectionItem.ranking }}위</h5>
      </div>
    </v-card>
  </div>
</template>

<script>
import dayjs from "dayjs";
import { mapGetters } from "vuex";

export default {
  name: "CollectionListItem",
  data() {
    return {
      rankingDate: "",
      collectionImg: {},
    };
  },
  props: {
    collectionItem: Object,
  },
  computed: {
    ...mapGetters([""]),
  },
  created() {
    this.rankingDate = dayjs(this.collectionItem.rankDate).format("YYYY년 MM월");
  },
};
</script>

<style>
.collec_card {
  margin-left: 15px;
  margin-top: 10px;
  margin-bottom: 20px;
}
.collec_card:last-child {
  margin-right: 15px;
}
</style>
