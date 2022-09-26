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
        <!-- <button class="vege"   @click="fetchVege"
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
        </button> -->
        <input type="checkbox" class="vege" v-model="vege1"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v01.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege2"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v02.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege3"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v03.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege4"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v04.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege5"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v05.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege6"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v06.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege7"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v07.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege8"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v08.jpg);
              background-size: 100% 100%;">
        <input type="checkbox" class="vege" v-model="vege9"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v09.jpg);
              background-size: 100% 100%;">
              
      </div>
      <hr>
    </div>
    <div class="allergie">
      <h4>알레르기 유발하는 음식을 선택해주세요.</h4>
      <div class="allcon">
        <div class="allrow">
          <button class="aller" id="1" @click="changeAll">계란</button>
          <button class="aller" id="2" @click="changeAll">우유</button>
          <button class="aller" id="3" @click="changeAll">대두</button>
          <button class="aller" id="4" @click="changeAll">토마토</button>
        </div>
        <div class="allrow">
          <button class="aller" id="5" @click="changeAll">쇠고기</button>
          <button class="aller" id="6" @click="changeAll">돼지고기</button>
          <button class="aller" id="7" @click="changeAll">닭고기</button>
          <button class="aller" id="8" @click="changeAll">새우</button>
        </div>
        <div class="allrow">
          <button class="aller" id="9" @click="changeAll">조개류</button>
          <button class="aller" id="10" @click="changeAll">아황산</button>
        </div>
      </div>
    <hr>
    </div>
    <div class="diet">
      <h4>식단 관리 중이라면 체크해주세요.</h4>
      <button class="dietbtn" @click="changeDiet">식단 관리 중</button>
    </div>
    <v-btn class="main_btn next_btn" @click="next">다음</v-btn>
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
      vege1 : false,
      vege2 : false,
      vege3 : false,
      vege4 : false,
      vege5 : false,
      vege6 : false,
      vege7 : false,
      vege8 : false,
      vege9 : false,

      allergie1 : false,
      allergie2 : false,
      allergie3 : false,
      allergie4 : false,
      allergie5 : false,
      allergie6 : false,
      allergie7 : false,
      allergie8 : false,
      allergie9 : false,
      allergie10 : false,

      isDiet : false
    }
  },


  methods: {
    goBack() {
      this.$router.go(-1);
    },

    changeDiet (event) {
      this.isDiet = !this.isDiet
      if (this.isDiet) {
        console.log(this.isDiet)
        console.log(event.target.classList)
        event.target.classList.add("checked")
      } else {
        console.log(this.isDiet)
        console.log(event.target.classList)
        event.target.classList.remove("checked")
      }
    },

    changeAll (event) {
      // console.log(this["allergie" + event.target.id])
      // console.log(event.target.id)
      // console.log(eval("this.allergie" + event.target.id))
      this["allergie" + event.target.id] = !this["allergie" + event.target.id]
      if (this["allergie" + event.target.id]) {
        event.target.classList.add("checked")
      } else {
        event.target.classList.remove("checked")
      }
    },

    next () {
      //axios로 체크한거 백으로 요청 
      //다음 페이지로 넘기기
    }


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
.checked {
  border: 5px solid #f4c41f;
}

input[type='checkbox']:checked {
  
  background-color: #f4c41f;
  border: 5px solid #f4c41f;
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
  appearance: none;
  height: 80px; 
  width: 80px;
  border-radius: 50%;
  border-style: solid;
  border: 2px solid;
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