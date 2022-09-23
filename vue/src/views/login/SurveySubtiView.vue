<template>
  <div>
    <div class="title">
      썹bti
    </div>
    <div class="backbar">
      <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
      <progress value="2" max="2"></progress>
    </div>
    <v-card class="home_card_b" elevation="3" outlined>
      <h3>썹BTI 란?</h3>
      <h5>본인이 원ㄴ하는 영양 정보를 통해 샌드위치를 추천 받을 수 있습니다.</h5>
    </v-card>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question1"  class="radiobtn mbbtn left">
            <input type="radio" name="question1"  class="radiobtn bbtn left">
            <input type="radio" name="question1"  class="radiobtn mbtn left">
            <input type="radio" name="question1"  class="radiobtn sbtn">
            <input type="radio" name="question1"  class="radiobtn mbtn right">
            <input type="radio" name="question1"  class="radiobtn bbtn right">
            <input type="radio" name="question1"  class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question2" class="radiobtn mbbtn left">
            <input type="radio" name="question2" class="radiobtn bbtn left">
            <input type="radio" name="question2" class="radiobtn mbtn left">
            <input type="radio" name="question2" class="radiobtn sbtn">
            <input type="radio" name="question2" class="radiobtn mbtn right">
            <input type="radio" name="question2" class="radiobtn bbtn right">
            <input type="radio" name="question2" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question3" class="radiobtn mbbtn left">
            <input type="radio" name="question3" class="radiobtn bbtn left">
            <input type="radio" name="question3" class="radiobtn mbtn left">
            <input type="radio" name="question3" class="radiobtn sbtn">
            <input type="radio" name="question3" class="radiobtn mbtn right">
            <input type="radio" name="question3" class="radiobtn bbtn right">
            <input type="radio" name="question3" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question4" class="radiobtn mbbtn left">
            <input type="radio" name="question4" class="radiobtn bbtn left">
            <input type="radio" name="question4" class="radiobtn mbtn left">
            <input type="radio" name="question4" class="radiobtn sbtn">
            <input type="radio" name="question4" class="radiobtn mbtn right">
            <input type="radio" name="question4" class="radiobtn bbtn right">
            <input type="radio" name="question4" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question5" class="radiobtn mbbtn left">
            <input type="radio" name="question5" class="radiobtn bbtn left">
            <input type="radio" name="question5" class="radiobtn mbtn left">
            <input type="radio" name="question5" class="radiobtn sbtn">
            <input type="radio" name="question5" class="radiobtn mbtn right">
            <input type="radio" name="question5" class="radiobtn bbtn right">
            <input type="radio" name="question5" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question6" class="radiobtn mbbtn left">
            <input type="radio" name="question6" class="radiobtn bbtn left">
            <input type="radio" name="question6" class="radiobtn mbtn left">
            <input type="radio" name="question6" class="radiobtn sbtn">
            <input type="radio" name="question6" class="radiobtn mbtn right">
            <input type="radio" name="question6" class="radiobtn bbtn right">
            <input type="radio" name="question6" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <v-btn class="main_btn">완료</v-btn>
    
  </div>
</template>

<script>
export default {
  name: 'SurveySubtiView',

  methods: {
    goBack() {
      this.$router.go(-1);
    },
    // changeBtn (event) {
    //   console.log(event.target)
    //   console.dir(enve)
    // }
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
h3 {
  margin: 10px;
}
h5 {
  width: 80%;
  margin: auto;
}
.home_card_b {
  height: 230px;
  width: 90%;
  margin: auto;
  text-align: center;
}
.subti {
  width: 90%;
  margin: auto;
  margin-top: 20px;
  border-bottom: solid 1px;
}
.statement {
  text-align: center;
  line-height: 1.5;
  font-weight: 600;
}
.decision {
  align-items: center;
  display: flex;
  justify-content: center;
  margin: 30px 0 20px;
}
.radio {
  align-items: center;
  display: flex;
  justify-content: space-between;
}
[type="radio"].right:checked {
  border: 0.4em solid #239347;
}
[type="radio"].left:checked {
  border: 0.4em solid #f4c41f;
}
.radiobtn {
  margin: 5px;
}
.mbbtn {
  height: 30px;
  width: 30px;
}
.bbtn {
  height: 25px;
  width: 25px;
}
.mbtn {
  height: 20px;
  width: 20px;
}
.sbtn {
  height: 15px;
  width: 15px;
}
.left {
  appearance: none;
  border:2px solid #f4c41f;
  accent-color: #f4c41f;
  border-radius: 50%;
}
.right {
  appearance: none;
  border:2px solid #239347;
  accent-color: #239347;
  border-radius: 50%;
}
.main_btn {
  width: 185px;
  height: 30px;
  border-radius: 15px;
  display: block;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>