<template>
  <div>
    <div class="title">
      기본 취향 파악
    </div>
    <div class="backbar">
      <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
      <progress value="1" max="2"></progress>
    </div>
    <div class="vegetable">
      <h4>못먹거나 싫어하는 음식을 선택해 주세요</h4>
      <div class="con" >
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v01.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v02.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v03.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v04.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v05.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v06.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v07.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v08.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v09.jpg);
              background-size: 100% 100%;">
        </button>
      </div>
      <hr>
    </div>
    <div class="allergie">
      <h4>알레르기 유발하는 음식을 선택해주세요.</h4>
      <div class="allcon">
        <div class="allrow">
          <button class="aller">계란</button>
          <button class="aller">우유</button>
          <button class="aller">대두</button>
          <button class="aller">토마토</button>
        </div>
        <div class="allrow">
          <button class="aller">쇠고기</button>
          <button class="aller">돼지고기</button>
          <button class="aller">닭고기</button>
          <button class="aller">새우</button>
        </div>
        <div class="allrow">
          <button class="aller">조개류</button>
          <button class="aller">아황산</button>
        </div>
      </div>
    <hr>
    </div>
    <div class="diet">
      <h4>식단 관리 중이라면 체크해주세요.</h4>
      <button class="dietbtn">식단 관리 중</button>
    </div>
    <v-btn class="main_btn next_btn">다음</v-btn>
  </div>
</template>

<script>
export default {
  name: 'SurveyBasicView',

  data () {
    let vegetables = []
    let allergies = []
    return {
      allergies : allergies,
      vegetables : vegetables,

    }
  },

  methods: {
    goBack() {
      this.$router.go(-1);
    },
  }
}
</script>

<style scoped>
.title {
  height:46px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.backbar {
  width: 90%;
  margin: auto;
  display: flex;
  align-items: center;
}
progress {
  display: block;
  height: 25px;
  width: 80%;
}
.vegetable {
  width: 90%;
  margin: auto;
  height: 360px;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-bottom: 1px solid;
  margin-bottom: 20px;
}

.vege {
  height: 80px; 
  width: 80px;
  border-radius: 50%;
  border-style: solid;
  
  
}
/* .vege img {
  width: 100%;
  border-radius: 50%;
} */
.con {
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  display: grid;
  grid-gap: 20px;
  grid-template-rows: 80px 80px 80px;
  grid-template-columns: 80px 80px 80px;
  justify-content: center;
}
.allergie {
  width: 90%;
  margin: auto;
  height: 220px;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-bottom: 1px solid;
  margin-bottom: 20px;
}
.allcon {
  
  display: flex;
  flex-direction: column;
  justify-content:space-evenly;
  align-items:center
}
.allrow {
  margin-top: 10px;
  margin-bottom: 10px;
}
.aller {
  border-style: solid;
  width: 70px;
  height: 30px;
  border-radius: 15px;
  margin: 5px;
}

.diet {
  width: 90%;
  margin: auto;
  display: flex;
  flex-direction: column;
  
  align-items: center;
}
.dietbtn {
  border-style: solid;
  width: 100px;
  height: 30px;
  border-radius: 15px;
  margin: auto;
  margin-top: 15px;
}
.next_btn {
  width: 185px;
  height: 30px;
  border-radius: 13px;
  display: block;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
}


</style>