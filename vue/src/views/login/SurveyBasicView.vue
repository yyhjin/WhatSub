<template>
  <div>
    <div class="title">
      기본 취향 파악
    </div>
    <div>
      <v-btn>뒤로가기</v-btn>
      <progress value="1" max="2"></progress>
    </div>
    <div class="vegetable">
      <h4>못먹거나 싫어하는 음식을 선택해 주세요</h4>
      <div class="con" >
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
        </button>
        <button class="vege">
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
  name: 'SurveyBasicView'
}
</script>

<style>
.title {
  width: 100%;
  height: 46px;
}
.vegetable {
  width: 90%;
  margin: auto;
  height: 380px;
  display: flex;
  flex-direction: column;
  
  align-items: center;
}

.vege {
  height: 80px; 
  width: 80px;
  border-radius: 50%;
  border-style: solid;
  background-image: url("https://www.subway.co.kr/images/menu/img_recipe_v01.jpg");
  background-size: 100% 100%;
  
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
  height: 240px;
  display: flex;
  flex-direction: column;
  
  align-items: center;
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