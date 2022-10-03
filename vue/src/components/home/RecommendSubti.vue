<template>
  <div>
    <div align="center" style="font-size: 18px; font-weight: bold">썹BTI 맞춤 추천</div>
    <v-card
      class="home_cover home_card_b myclass3"
      elevation="5"
      outlined
      @click.stop="dialogRecoCombi = true"
    >
      <v-row class="pl-5 pt-7" align="center">
        <v-col class="pa-0" cols="4"
          ><v-img class="shadow_img" height="90" :src="combiBasedSubti.imgUrl"></v-img
        ></v-col>
        <v-col cols="7" class="pa-0 pl-5" align="center">
          <div class="mb-2" style="font-weight: bold">{{ combiBasedSubti.combName }}</div>
          <div style="font-size: 12px">
            {{ combiBasedSubti.menuDesc }}
          </div>
        </v-col>
      </v-row>
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
  border-color: #239347 !important;
  border-width: 2px;
}
</style>
