<template>
  <div>
    <div class="top">
      <v-row>
        <v-col cols="4">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1"><h3>오늘의 추천</h3></v-col>
      </v-row>
    </div>
    <div>
      <component :is="currentComponent" @compo-change="goNextQuestion"></component>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import RecommendTodayDetail from "@/components/home/RecommendTodayDetail.vue";
import BottomNav from "@/components/common/BottomNav.vue";

//오늘의 추천 질문
import QuestionOne from "@/components/home/TodayQuestion/QuestionOne.vue";
import QuestionTwo from "@/components/home/TodayQuestion/QuestionTwo.vue";
import QuestionThree from "@/components/home/TodayQuestion/QuestionThree.vue";
import QuestionFour from "@/components/home/TodayQuestion/QuestionFour.vue";
import QuestionFive from "@/components/home/TodayQuestion/QuestionFive.vue";
import QuestionSix from "@/components/home/TodayQuestion/QuestionSix.vue";
import QuestionSeven from "@/components/home/TodayQuestion/QuestionSeven.vue";
import QuestionEight from "@/components/home/TodayQuestion/QuestionEight.vue";
import QuestionNine from "@/components/home/TodayQuestion/QuestionNine.vue";
import QuestionTen from "@/components/home/TodayQuestion/QuestionTen.vue";
import QuestionEleven from "@/components/home/TodayQuestion/QuestionEleven.vue";
import QuestionTwelve from "@/components/home/TodayQuestion/QuestionTwelve.vue";
import QuestionThirteen from "@/components/home/TodayQuestion/QuestionThirteen.vue";
import QuestionFourteen from "@/components/home/TodayQuestion/QuestionFourteen.vue";
import QuestionFifteen from "@/components/home/TodayQuestion/QuestionFifteen.vue";
import QuestionSixteen from "@/components/home/TodayQuestion/QuestionSixteen.vue";
import QuestionSeventeen from "@/components/home/TodayQuestion/QuestionSeventeen.vue";

//오늘의 추천 결과
import SandEggmayo from "@/components/home/TodayResult/SandEggmayo.vue";
import SandTuna from "@/components/home/TodayResult/SandTuna.vue";
import SandStake from "@/components/home/TodayResult/SandStake.vue";
import SandKbarbecue from "@/components/home/TodayResult/SandKbarbecue.vue";
import SandMushroom from "@/components/home/TodayResult/SandMushroom.vue";
import SandVeggie from "@/components/home/TodayResult/SandVeggie.vue";
import SandHam from "@/components/home/TodayResult/SandHam.vue";
import SandShrimp from "@/components/home/TodayResult/SandShrimp.vue";
import SandChickenslice from "@/components/home/TodayResult/SandChickenslice.vue";
import SandChickenteriyaki from "@/components/home/TodayResult/SandChickenteriyaki.vue";
import SandPulledpork from "@/components/home/TodayResult/SandPulledpork.vue";
import SandBlt from "@/components/home/TodayResult/SandBlt.vue";
import SandItalianbmt from "@/components/home/TodayResult/SandItalianbmt.vue";
import SandSpicyitalian from "@/components/home/TodayResult/SandSpicyitalian.vue";
import SandChickenbaconavo from "@/components/home/TodayResult/SandChickenbaconavo.vue";
import SandTurkeybaconavo from "@/components/home/TodayResult/SandTurkeybaconavo.vue";
import SandSubweyclub from "@/components/home/TodayResult/SandSubweyclub.vue";
import SandTurkey from "@/components/home/TodayResult/SandTurkey.vue";
import SandRoastedchicken from "@/components/home/TodayResult/SandRoastedchicken.vue";
import SandRotisserieBarbecue from "@/components/home/TodayResult/SandRotisserieBarbecue.vue";

export default {
  name: "RecommendTodayView",
  components: {
    RecommendTodayDetail,
    BottomNav,

    QuestionOne,
    QuestionTwo,
    QuestionThree,
    QuestionFour,
    QuestionFive,
    QuestionSix,
    QuestionSeven,
    QuestionEight,
    QuestionNine,
    QuestionTen,
    QuestionEleven,
    QuestionTwelve,
    QuestionThirteen,
    QuestionFourteen,
    QuestionFifteen,
    QuestionSixteen,
    QuestionSeventeen,

    SandEggmayo,
    SandTuna,
    SandStake,
    SandKbarbecue,
    SandMushroom,
    SandVeggie,
    SandHam,
    SandShrimp,
    SandChickenslice,
    SandChickenteriyaki,
    SandPulledpork,
    SandBlt,
    SandItalianbmt,
    SandSpicyitalian,
    SandChickenbaconavo,
    SandTurkeybaconavo,
    SandSubweyclub,
    SandTurkey,
    SandRoastedchicken,
    SandRotisserieBarbecue,
  },
  data() {
    return {
      currentComponent: "RecommendTodayDetail",
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    goNextQuestion(value) {
      console.log("자식에게 받은 값: ", value);
      if (this.currentComponent == "RecommendTodayDetail") {
        this.currentComponent = "QuestionOne";
      } else if (this.currentComponent == "QuestionOne") {
        if (value == 1) {
          this.currentComponent = "QuestionTwo";
        } else {
          this.currentComponent = "QuestionThree";
        }
      } else if (this.currentComponent == "QuestionTwo") {
        if (value == 1) {
          this.currentComponent = "QuestionFour";
        } else {
          this.currentComponent = "SandEggmayo";
        }
      } else if (this.currentComponent == "QuestionThree") {
        if (value == 1) {
          this.currentComponent = "QuestionFive";
        } else {
          this.currentComponent = "QuestionSix";
        }
      } else if (this.currentComponent == "QuestionFour") {
        if (value == 1) {
          this.currentComponent = "QuestionSeven";
        } else {
          this.currentComponent = "QuestionEight";
        }
      } else if (this.currentComponent == "QuestionFive") {
        if (value == 1) {
          this.currentComponent = "QuestionNine";
        } else {
          this.currentComponent = "QuestionTen";
        }
      } else if (this.currentComponent == "QuestionSix") {
        if (value == 1) {
          this.currentComponent = "QuestionEleven";
        } else if (value == 2) {
          this.currentComponent = "SandTuna";
        } else {
          this.currentComponent = "QuestionTwelve";
        }
      } else if (this.currentComponent == "QuestionSeven") {
        if (value == 1) {
          this.currentComponent = "QuestionThirteen";
        } else {
          this.currentComponent = "QuestionFourteen";
        }
      } else if (this.currentComponent == "QuestionEight") {
        if (value == 1) {
          this.currentComponent = "SandStake";
        } else {
          this.currentComponent = "SandKbarbecue";
        }
      } else if (this.currentComponent == "QuestionNine") {
        if (value == 1) {
          this.currentComponent = "SandMushroom";
        } else {
          this.currentComponent = "SandVeggie";
        }
      } else if (this.currentComponent == "QuestionTen") {
        if (value == 1) {
          this.currentComponent = "QuestionFifteen";
        } else if (value == 2) {
          this.currentComponent = "SandHam";
        } else {
          this.currentComponent = "SandShrimp";
        }
      } else if (this.currentComponent == "QuestionEleven") {
        if (value == 1) {
          this.currentComponent = "SandChickenslice";
        } else {
          this.currentComponent = "SandChickenteriyaki";
        }
      } else if (this.currentComponent == "QuestionTwelve") {
        if (value == 1) {
          this.currentComponent = "SandPulledpork";
        } else {
          this.currentComponent = "SandBlt";
        }
      } else if (this.currentComponent == "QuestionThirteen") {
        if (value == 1) {
          this.currentComponent = "SandItalianbmt";
        } else {
          this.currentComponent = "SandSpicyitalian";
        }
      } else if (this.currentComponent == "QuestionFourteen") {
        if (value == 1) {
          this.currentComponent = "SandChickenbaconavo";
        } else {
          this.currentComponent = "SandTurkeybaconavo";
        }
      } else if (this.currentComponent == "QuestionFifteen") {
        if (value == 1) {
          this.currentComponent = "QuestionSixteen";
        } else {
          this.currentComponent = "QuestionSeventeen";
        }
      } else if (this.currentComponent == "QuestionSixteen") {
        if (value == 1) {
          this.currentComponent = "SandTurkey";
        } else {
          this.currentComponent = "SandSubweyclub";
        }
      } else if (this.currentComponent == "QuestionSeventeen") {
        if (value == 1) {
          this.currentComponent = "SandRoastedchicken";
        } else {
          this.currentComponent = "SandRotisserieBarbecue";
        }
      }
    },
  },
};
</script>

<style scoped>
.top {
  margin: 10px;
  position: fixed;
  width: 100%;
}
.bottom {
  position: fixed;
  width: 100%;
  bottom: 0;
}
</style>
