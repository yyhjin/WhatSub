<template>
  <div>
    <v-card class="sand_big_card" style="position: relative">
      <div
        class="pa-2 pl-50"
        style="position: absolute; font-size: 13px; color: grey"
        @click="btnDeleteZzim"
      >
        <v-icon small color="red">mdi-close</v-icon>제거
      </div>
      <v-row class="">
        <v-col class="pa-0 mt-3 ml-3" cols="5" align="center">
          <v-img class="shadow_img" height="70" width="150" :src="sand.imgUrl"></v-img>
          <div class="mt-1">
            <h6 style="font-size: 15px; font-weight: bold">{{ sand.combName }}</h6>
          </div>
          <div>
            <h6 style="font-size: 13px; font-weight: 400">
              {{ sand.combination.price | comma }}원
            </h6>
          </div>
        </v-col>
        <v-col>
          <div class="mt-1 ml-n4">
            <h6 style="font-size: 14px; font-weight: 500">
              메뉴: {{ sand.menuName }}<br />추가재료: {{ others[0] }}···<br />소스:
              {{ sauce[0] }}···
            </h6>
          </div>
          <div class="mt-3 ml-n4">
            <v-btn class="green_btn" small rounded elevation="0" @click="goOrder">바로주문</v-btn>
            <span class="ml-2"
              ><v-btn
                class="main_btn"
                small
                rounded
                elevation="0"
                @click.stop="dialogRecoCombi = true"
                >상세보기</v-btn
              ></span
            >
          </div>
        </v-col>
      </v-row>
    </v-card>
    <combi-modal
      :combi-list-item="sandListItem.combinationPostDto"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import CombiModal from "@/components/common/mypage/CombiModalMyCombiMyZzim.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "SandBigListItemMyPage",
  components: { CombiModal },
  data() {
    return {
      dialogRecoCombi: false,
      others: [],
      sauce: [],
    };
  },
  props: {
    sandListItem: Object,
  },
  computed: {
    ...mapGetters(["profile"]),
    sand() {
      return this.sandListItem.combinationPostDto;
    },
  },
  created() {
    for (let index = 0; index < this.sandListItem.combinationPostDto.ingredients.length; index++) {
      if (this.sandListItem.combinationPostDto.ingredients[index].category == "추가") {
        this.others.push(this.sandListItem.combinationPostDto.ingredients[index].name);
      } else if (this.sandListItem.combinationPostDto.ingredients[index].category == "소스") {
        this.sauce.push(this.sandListItem.combinationPostDto.ingredients[index].name);
      }
    }
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions(["updateZzimCombi"]),
    goOrder() {},
    btnDeleteZzim() {
      if (confirm("삭제하시겠습니까?")) {
        this.updateZzimCombi({
          combPostId: this.sand.combinationPostId,
          userId: this.profile.userId,
        });
      }
    },
  },
};
</script>

<style>
.sand_big_card {
  height: 140px;
  width: 333px;
}
.sand_big_card:last-child {
  margin-bottom: 10px;
}
.pl-50 {
  margin-left: 260px;
}
</style>
