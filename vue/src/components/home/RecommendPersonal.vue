<template>
  <div>
    <div class="mt-5" align="center" style="font-size: 18px; font-weight: bold">개인 맞춤 추천</div>
    <v-card
      class="home_cover home_card_b myclass3"
      elevation="5"
      outlined
      @click="changeCard"
      color="#f4c41f"
      style="position: relative"
    >
      <v-row class="pl-5 pt-7" align="center">
        <v-col class="pa-0" cols="4"
          ><v-img class="shadow_img" height="90" :src="combiBasedIndividual.menu.img_url"></v-img
        ></v-col>
        <v-col cols="7" class="pa-0 pl-5" align="center">
          <div class="mb-2" style="font-weight: bold">{{ combiBasedIndividual.comb_name }}</div>
          <div style="font-size: 13px">
            {{ combiBasedIndividual.content }}
          </div>
        </v-col>
      </v-row>
      <v-card
        v-if="isClicked"
        class="myclass2_cover home_card_b_cover"
        elevation="0"
        outlined
        style="position: absolute"
      >
        <v-row class="pl-8 pt-6" align="center" @click="changeCard">
          <v-col class="pa-0" cols="12">
            <div style="font-size: 14px; font-weight: bold">
              <div>빵: {{ bread[0] }}</div>
              <div>치즈: {{ cheese[0] }}</div>
              <div>소스: {{ sauce[0] }} {{ sauce[1] }}</div>
            </div>
          </v-col>
        </v-row>
        <v-row class="pl-6">
          <v-col>
            <div style="font-size: 16px; font-weight: bold">
              {{ combiBasedIndividual.kcal }}kcal
            </div>
          </v-col>
          <v-col>
            <div style="font-size: 16px; font-weight: bold">
              {{ combiBasedIndividual.price | comma }}원
            </div>
          </v-col>
          <v-col class="pa-0 pt-2 pr-6" align="center">
            <v-btn class="main_btn" elevetion="0" rounded small @click.stop="dialogRecoCombi = true"
              >상세보기</v-btn
            >
          </v-col>
        </v-row>
      </v-card>
    </v-card>
    <combi-modal
      :combi-list-item="combiBasedIndividual"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import CombiModal from "@/components/common/recoPersonal/CombiModalPersonal.vue";

export default {
  name: "RecommendPersonal",
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
  computed: {
    ...mapGetters(["combiBasedIndividual", "sampleUserId"]),
  },
  created() {
    console.log(this.sampleUserId);
    this.getCombiBasedIndividual({
      userId: this.sampleUserId,
    });
    for (let index = 0; index < this.combiBasedIndividual.ingredients.length; index++) {
      if (this.combiBasedIndividual.ingredients[index].category == "빵") {
        this.bread.push(this.combiBasedIndividual.ingredients[index].name);
      } else if (this.combiBasedIndividual.ingredients[index].category == "치즈") {
        this.cheese.push(this.combiBasedIndividual.ingredients[index].name);
      } else if (this.combiBasedIndividual.ingredients[index].category == "소스") {
        this.sauce.push(this.combiBasedIndividuals.ingredients[index].name);
      }
    }
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions(["getCombiBasedIndividual"]),
    changeCard() {
      this.isClicked = !this.isClicked;
    },
  },
};
</script>

<style>
.home_card_b {
  height: 130px;
}

.myclass2_cover.v-sheet.v-card {
  border-color: #f4c41f !important;
  border-width: 3px;
}
</style>
