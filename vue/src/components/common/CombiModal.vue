<template>
  <v-dialog scrollable :value="dialogRecoCombi" @input="dialogRecoCombi = $event">
    <v-card height="680">
      <v-card-title class="pt-3 pl-4">
        <v-row>
          <v-col>
            <v-btn class="green_btn" elevation="0" rounded @click="goCombiDetail" small
              >꿀조합 보러 가기</v-btn
            >
          </v-col>
          <v-spacer></v-spacer>
          <v-col align="right">
            <v-btn class="c_btn pa-0" text @click.stop="dialogRecoCombi = false">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-card-title>
      <v-card-text
        ><combi-info-snad :combi-list-item="combiListItem"></combi-info-snad>
        <combi-info-ingredient :combi-list-item="combiListItem"></combi-info-ingredient>
        <combi-info-nutrition :combi-list-item="combiListItem"></combi-info-nutrition>
      </v-card-text>
      <v-card-actions class="pl-5 pb-5">
        <div style="font-size: 18px; font-weight: 900">
          총&nbsp; {{ combiListItem.price | comma }}원
        </div>
        <v-spacer></v-spacer>
        <v-btn class="main_btn" width="180" elevation="0" rounded @click="goOrderCombi"
          >주문하러 가기</v-btn
        >
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import CombiInfoSnad from "@/components/common/CombiInfoSand.vue";
import CombiInfoIngredient from "@/components/common/CombiInfoIngredient.vue";
import CombiInfoNutrition from "@/components/common/CombiInfoNutrition.vue";

export default {
  name: "CombiModal",
  components: { CombiInfoSnad, CombiInfoIngredient, CombiInfoNutrition },
  props: {
    value: {
      type: Boolean,
      required: true,
    },
    combiListItem: Object,
  },
  computed: {
    dialogRecoCombi: {
      get() {
        return this.value;
      },
      set(value) {
        this.$emit("input", value);
      },
    },
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    goCombiDetail() {
      this.$router.push({
        name: "combinationdetail",
        params: {
          combinationPostId: this.combiListItem.combinationPostId,
        },
      });
    },
    goOrderCombi() {},
  },
};
</script>

<style scoped>
.c_btn {
  min-width: 0px !important;
}
</style>
