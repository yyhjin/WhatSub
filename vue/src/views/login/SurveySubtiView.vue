<template>
  <div class="body">
    <div class="title">
      썹bti
    </div>
    <div class="backbar">
      <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
      <progress value="2" max="2"></progress>
    </div>
    <v-card class="home_card_b" elevation="3" outlined>
      <h3>썹BTI 란?</h3>
      <h5><p>내 입맛에 어울리는 서브웨이 조합은?!</p><p>나의 입맛 그룹을 진단받고, </p><p>나와 같은 입맛을 가진 사람들이 </p>선호하는 메뉴를 추천받을 수 있습니다!</h5>
    </v-card>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>찐 감자를 먹을 때 소금보다는 설탕에 찍어 먹는 것을 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question1" value="1" v-model="question1" class="radiobtn mbbtn left">
            <input type="radio" name="question1" value="2" v-model="question1" class="radiobtn bbtn left">
            <input type="radio" name="question1" value="3" v-model="question1" class="radiobtn mbtn left">
            <input type="radio" name="question1" value="4" v-model="question1" class="radiobtn sbtn">
            <input type="radio" name="question1" value="5" v-model="question1" class="radiobtn mbtn right">
            <input type="radio" name="question1" value="6" v-model="question1" class="radiobtn bbtn right">
            <input type="radio" name="question1" value="7" v-model="question1" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>파스타는 오일보다는 꾸덕한 크림파스타가 더 맛있다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question2" value="1" v-model="question2" class="radiobtn mbbtn left">
            <input type="radio" name="question2" value="2" v-model="question2" class="radiobtn bbtn left">
            <input type="radio" name="question2" value="3" v-model="question2" class="radiobtn mbtn left">
            <input type="radio" name="question2" value="4" v-model="question2" class="radiobtn sbtn">
            <input type="radio" name="question2" value="5" v-model="question2" class="radiobtn mbtn right">
            <input type="radio" name="question2" value="6" v-model="question2" class="radiobtn bbtn right">
            <input type="radio" name="question2" value="7" v-model="question2" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>부드러운 카스테라보다는 바게트를 더 선호한다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question3" value="1" v-model="question3" class="radiobtn mbbtn left">
            <input type="radio" name="question3" value="2" v-model="question3" class="radiobtn bbtn left">
            <input type="radio" name="question3" value="3" v-model="question3" class="radiobtn mbtn left">
            <input type="radio" name="question3" value="4" v-model="question3" class="radiobtn sbtn">
            <input type="radio" name="question3" value="5" v-model="question3" class="radiobtn mbtn right">
            <input type="radio" name="question3" value="6" v-model="question3" class="radiobtn bbtn right">
            <input type="radio" name="question3" value="7" v-model="question3" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>엽떡은 무조건 매운맛이다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question4" value="1" v-model="question4" class="radiobtn mbbtn left">
            <input type="radio" name="question4" value="2" v-model="question4" class="radiobtn bbtn left">
            <input type="radio" name="question4" value="3" v-model="question4" class="radiobtn mbtn left">
            <input type="radio" name="question4" value="4" v-model="question4" class="radiobtn sbtn">
            <input type="radio" name="question4" value="5" v-model="question4" class="radiobtn mbtn right">
            <input type="radio" name="question4" value="6" v-model="question4" class="radiobtn bbtn right">
            <input type="radio" name="question4" value="7" v-model="question4" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>팝콘은 고소하고 짭짤한 오리지날 보다는 달콤한 카라멜이 진리다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question5" value="1" v-model="question5" class="radiobtn mbbtn left">
            <input type="radio" name="question5" value="2" v-model="question5" class="radiobtn bbtn left">
            <input type="radio" name="question5" value="3" v-model="question5" class="radiobtn mbtn left">
            <input type="radio" name="question5" value="4" v-model="question5" class="radiobtn sbtn">
            <input type="radio" name="question5" value="5" v-model="question5" class="radiobtn mbtn right">
            <input type="radio" name="question5" value="6" v-model="question5" class="radiobtn bbtn right">
            <input type="radio" name="question5" value="7" v-model="question5" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>아메리카노보다는 휘핑크림 잔뜩 들어간 커피가 더 좋다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question6" value="1" v-model="question6" class="radiobtn mbbtn left">
            <input type="radio" name="question6" value="2" v-model="question6" class="radiobtn bbtn left">
            <input type="radio" name="question6" value="3" v-model="question6" class="radiobtn mbtn left">
            <input type="radio" name="question6" value="4" v-model="question6" class="radiobtn sbtn">
            <input type="radio" name="question6" value="5" v-model="question6" class="radiobtn mbtn right">
            <input type="radio" name="question6" value="6" v-model="question6" class="radiobtn bbtn right">
            <input type="radio" name="question6" value="7" v-model="question6" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>탕수육은 눅눅한 부먹보다 바삭한 찍먹이다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question7" value="1" v-model="question7" class="radiobtn mbbtn left">
            <input type="radio" name="question7" value="2" v-model="question7" class="radiobtn bbtn left">
            <input type="radio" name="question7" value="3" v-model="question7" class="radiobtn mbtn left">
            <input type="radio" name="question7" value="4" v-model="question7" class="radiobtn sbtn">
            <input type="radio" name="question7" value="5" v-model="question7" class="radiobtn mbtn right">
            <input type="radio" name="question7" value="6" v-model="question7" class="radiobtn bbtn right">
            <input type="radio" name="question7" value="7" v-model="question7" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <div class="subti">
      <div class="question">
        <div class="statement">
          <span>불닭볶음면을 자주 즐겨 먹는다.</span>
        </div>
        <div class="decision">
          <div class="agree">동의</div>
          <div class="radio">
            <input type="radio" name="question8" value="1" v-model="question8" class="radiobtn mbbtn left">
            <input type="radio" name="question8" value="2" v-model="question8" class="radiobtn bbtn left">
            <input type="radio" name="question8" value="3" v-model="question8" class="radiobtn mbtn left">
            <input type="radio" name="question8" value="4" v-model="question8" class="radiobtn sbtn">
            <input type="radio" name="question8" value="5" v-model="question8" class="radiobtn mbtn right">
            <input type="radio" name="question8" value="6" v-model="question8" class="radiobtn bbtn right">
            <input type="radio" name="question8" value="7" v-model="question8" class="radiobtn mbbtn right">
          </div>
          <div class="disagree">비동의</div>
        </div>
      </div>
    </div>
    <v-btn class="main_btn" @click="submitSubti">완료</v-btn>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from '../../components/common/BottomNav.vue';
import api from '@/api/api'
import axios from 'axios'
import { mapActions, mapGetters } from 'vuex'
import swal from 'sweetalert'
export default {
  components: { BottomNav },
  name: 'SurveySubtiView',

  data () {
    return {
      question1 : 0,
      question2 : 0,
      question3 : 0,
      question4 : 0,
      question5 : 0,
      question6 : 0,
      question7 : 0,
      question8 : 0
    }
  },

  computed: {
    ...mapGetters(['authHeader', 'profile']),
    lvi () {
      return (parseInt(this.question2) + parseInt(this.question6)) >= 8 ? "I":"L"
    },
    svc () {
      return (parseInt(this.question3) + parseInt(this.question7)) >= 8 ? "C":"S"
    },
    ave () {
      return (parseInt(this.question1) + parseInt(this.question5)) >= 8 ? "E":"A"
    },
    hvm () {
      return (parseInt(this.question4) + parseInt(this.question8)) >= 8 ? "H":"M"
    },
    subti () {
      return this.lvi + this.svc + this.ave + this.hvm
    }
  },

  methods: {
    ...mapActions(['fetchProfile']),
    goBack() {
      this.$router.go(-1);
    },

    submitSubti () {
      //axios로 섭티에 대한 정보 백으로 보내기 => 잘 넘어갔으면 홈으로 보내기
      if (this.question1 !== 0 && this.question2 !== 0 && this.question3 !== 0 && this.question4 !== 0 &&
      this.question5 !== 0 && this.question6 !== 0 && this.question7 !== 0 && this.question8 !== 0) {
        axios({
          url: api.accounts.subti(),
          method: 'post',
          data: {
            "subti": this.subti,
            "userId": this.profile.userId,
          },
          headers: this.authHeader
        }).then( res => {
          console.log(res)
          swal(`당신의 SUBTI는 ${this.subti}입니다!`)
          this.$router.push({name:'home'})
        }).catch( err => {
          console.error(err)
        })
      } else {
        swal('문항을 모두 기입해주세요')
      }
    }
  },

  mounted () {
    this.fetchProfile()
  }
}
</script>

<style scoped>
.body {
  padding-top: 46px;
  padding-bottom: 60px;
}
.title {
  height:46px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  background-color: white;
  z-index: 5;
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
  border-color: yellowgreen;
  
}
.sbtn:checked {
  accent-color: yellowgreen;
  border-color: yellowgreen
  
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