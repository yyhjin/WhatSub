<template>
  <div>
    <div align="center" style="font-size: 18px; font-weight: bold">개인 맞춤 추천</div>
    <v-card
      class="home_cover home_card_b myclass2"
      elevation="5"
      outlined
      @click.stop="dialogRecoCombi = true"
    >
      <v-row class="pl-5 pt-7" align="center">
        <v-col class="pa-0" cols="4"
          ><v-img class="shadow_img" height="90" :src="combiBasedIndividual.imgUrl"></v-img
        ></v-col>
        <v-col cols="7" class="pa-0 pl-5" align="center">
          <div class="mb-2" style="font-weight: bold">{{ combiBasedIndividual.combName }}</div>
          <div style="font-size: 12px">
            {{ combiBasedIndividual.menuDesc }}
          </div>
        </v-col>
      </v-row>
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
import CombiModal from "@/components/common/CombiModal.vue";

export default {
  name: "RecommendPersonal",
  components: { CombiModal },
  data() {
    return {
      dialogRecoCombi: false,
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
  },
  methods: {
    ...mapActions(["getCombiBasedIndividual"]),
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
