<template>
  <div>
    <div align="center" style="font-size: 18px; font-weight: bold">개인 맞춤 추천</div>
    <v-card class="home_cover home_card_b myclass2" elevation="5" outlined>
      <v-row class="pl-5 pt-7" align="center">
        <v-col class="pa-0" cols="4"
          ><v-img height="100" width="120" src="@/assets/sample_sand1.png"></v-img
        ></v-col>
        <v-col cols="7" class="pa-0" align="center">
          <div class="mb-2" style="font-weight: bold">치킨 슬라이스</div>
          <div style="font-size: 12px">
            닭가슴살로 만든 치킨 슬라이스를<br />
            담백하게 즐겨보세요.
          </div>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "RecommendPersonal",
  data() {
    return {};
  },
  computed: {
    ...mapGetters([""]),
  },

  methods: {
    ...mapActions([""]),
  },
};
</script>

<style>
.home_card_b {
  height: 130px;
}
.myclass2.v-sheet.v-card {
  border-color: #f4c41f !important;
  border-width: 2px;
}
</style>
