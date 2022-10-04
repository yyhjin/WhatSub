<template>
  <div>
    <div align="center" style="font-size: 18px; font-weight: bold">썹BTI 맞춤 추천</div>
    <v-card
      v-if="!isClicked"
      class="home_cover home_card_b myclass3"
      elevation="5"
      outlined
      @click.stop="dialogRecoCombi = true"
      color="#239347"
      style="position: relative"
    >
      <v-row class="pl-5 pt-7" align="center">
        <v-col class="pa-0" cols="4"
          ><v-img class="shadow_img" height="90" :src="combiBasedSubti.imgUrl"></v-img
        ></v-col>
        <v-col cols="7" class="pa-0 pl-5" align="center">
          <div class="mb-2" style="font-weight: bold">{{ combiBasedSubti.combName }}</div>
          <div style="font-size: 13px">
            {{ combiBasedSubti.menuDesc }}
          </div>
        </v-col>
      </v-row>
      <v-card
        v-if="isClicked"
        class="myclass_cover home_card_b_cover"
        elevation="5"
        outlined
        @click.stop="dialogRecoCombi = true"
        style="position: absolute"
      >
        <v-row class="pl-5 pt-7" align="center">
          <v-col class="pa-0" cols="4">
            <div>빵:</div>
            <div>치즈:</div>
            <div>소스:</div>
          </v-col>
          <v-col cols="7" class="pa-0 pl-5" align="center">
            <div class="mb-2" style="font-weight: bold">{{ combiBasedSubti.combName }}</div>
            <div style="font-size: 12px">
              {{ combiBasedSubti.menuDesc }}
            </div>
          </v-col>
        </v-row>
      </v-card>
    </v-card>
    <combi-modal
      :combi-list-item="combiBasedSubti"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import CombiModal from "@/components/common/CombiModal.vue";

export default {
  name: "RecommendSubti",
  components: { CombiModal },
  data() {
    return {
      dialogRecoCombi: false,
      isClicked: false,
    };
  },
  created() {
    console.log(this.userSubti);
    this.getCombiBasedSubti({
      subti: this.userSubti,
    });
  },
  computed: {
    ...mapGetters(["combiBasedSubti", "userSubti"]),
  },
  methods: {
    ...mapActions(["getCombiBasedSubti"]),
  },
};
</script>

<style>
.myclass3.v-sheet.v-card {
  border-color: #444444 !important;
  border-width: 2px;
}
.myclass_cover.v-sheet.v-card {
  border-color: #239347 !important;
  border-width: 3px;
}
.home_card_b_cover {
  max-width: 102% !important;
  height: 130px;

  margin-top: -95px;
  margin-left: -2px;

  background-color: white;
  opacity: 0.9;
  top: 3;
}
</style>
