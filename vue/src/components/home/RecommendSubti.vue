<template>
  <div>
    <div align="center" style="font-size: 18px; font-weight: bold">썹BTI 맞춤 추천</div>
    <v-card
      class="home_cover home_card_b myclass3"
      elevation="5"
      outlined
      @click="changeCard"
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
        elevation="0"
        outlined
        style="position: absolute"
      >
        <v-row class="pl-8 pt-6" align="center" @click="changeCard">
          <v-col class="pa-0" cols="12" @click="changeCard">
            <div style="font-size: 14px; font-weight: bold">
              <div>빵: {{ bread[0] }}</div>
              <div>치즈: {{ cheese[0] }}</div>
              <div>소스: {{ sauce[0] }} {{ sauce[1] }}</div>
            </div>
          </v-col>
        </v-row>
        <v-row class="pl-6">
          <v-col>
            <div style="font-size: 16px; font-weight: bold">{{ combiBasedSubti.kcal }}kcal</div>
          </v-col>
          <v-col>
            <div style="font-size: 16px; font-weight: bold">
              {{ combiBasedSubti.price | comma }}원
            </div>
          </v-col>
          <v-col class="pa-0 pt-2 pr-6" align="center">
            <v-btn
              class="green_btn"
              elevetion="0"
              rounded
              small
              @click.stop="dialogRecoCombi = true"
              >상세보기</v-btn
            >
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

      bread: [],
      cheese: [],
      sauce: [],
    };
  },
  created() {
    this.fetchProfile();
    this.getCombiBasedSubti({
      subti: this.profile.subti,
    });
    console.log(this.combiBasedSubti.ingredient.length);
    for (let index = 0; index < this.combiBasedSubti.ingredient.length; index++) {
      if (this.combiBasedSubti.ingredient[index].category == "빵") {
        this.bread.push(this.combiBasedSubti.ingredient[index].name);
      } else if (this.combiBasedSubti.ingredient[index].category == "치즈") {
        this.cheese.push(this.combiBasedSubti.ingredient[index].name);
      } else if (this.combiBasedSubti.ingredient[index].category == "소스") {
        this.sauce.push(this.combiBasedSubti.ingredient[index].name);
      }
    }
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  computed: {
    ...mapGetters(["combiBasedSubti", "profile"]),
  },
  methods: {
    ...mapActions(["getCombiBasedSubti", "fetchProfile"]),
    changeCard() {
      this.isClicked = !this.isClicked;
    },
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
  height: 132px;
  width: 320px;

  margin-top: -97px;
  margin-left: -2px;

  background-color: white;
  opacity: 0.9;
  top: 3;
}
</style>
