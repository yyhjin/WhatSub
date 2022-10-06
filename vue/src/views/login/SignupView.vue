<template>
  <div class="body">
    <div class="snow"></div>
    <div class="container">
      <div class="title">회원가입</div>
      <v-form class="form" @submit.prevent="signup">
        <div class="image">
          <v-avatar>
            <img :src="imgUrl" alt="" id="preview">
          </v-avatar>
          <v-file-input
            accept="image/png, image/jpeg, image/bmp, image/jpg"
            placeholder="Pick an avatar"
            prepend-icon="mdi-camera"
            label="Avatar"
            @change="selectFile"
          ></v-file-input>
        </div>
        <div class="nickname">
          <div style="display:flex;">
            <v-text-field label="닉네임" v-model="credentials.username" class="nameInput"></v-text-field>
            <v-icon v-if="checked">mdi-check</v-icon>
          </div>
          <v-btn class="main_btn name_btn" @click="checkId(credentials.username)">닉네임 중복검사</v-btn>
        </div>
        <div class="gender">
          성별
          <v-radio-group v-model="credentials.gender" row class="radio">
            <v-radio
              label="남자"
              value="1"
            ></v-radio>
            <v-radio
              label="여자"
              value="0"
            ></v-radio>
          </v-radio-group>
        </div>
        <div class="birth">
          <v-select          
            v-model="credentials.birthYear"
            :items="items"
            
            label="출생년도"
            data-vv-name="select"
            required></v-select>
        </div>
        <v-btn class="main_btn" @click="signup">회원가입</v-btn>
      </v-form>
    </div>
    <div class="botton">
      <bottom-nav></bottom-nav>
    </div>
    <div class="snow"></div>
  </div>
</template>

<script>
import axios from 'axios'
import api from '@/api/api'
import BottomNav from '../../components/common/BottomNav.vue'
import { mapActions } from 'vuex'

export default {
  components: { BottomNav },
  name: 'SignupView',

  data () {
    var now = new Date()
    var year = now.getFullYear()
    let items = []
    for (let i = 0; i< 100; i++) {
      items.push(year-i)
    }
    
    const formData =new FormData()
    return {
      credentials: {
        username: '',
        gender: '',
        birthYear: null
      },
      items : items,
      formData: formData,
      code: '',
      accessToken : '',
      imgUrl: '',
      checked: 0
    }
  },

  methods: {
    ...mapActions(['saveToken', 'saveUserName']),
    checkId (username) {
      //axios로 요청보내서 검사
      axios({
        method: 'get',
        url: api.accounts.check(username),
      }).then(res => {
        console.log(res)
        if (res.data.data === false) {
          alert('가능')
          this.checked = true
        } else {
          this.checked=false
          alert('있는 아이디')
        }
      }).catch(err => console.error(err))
    },

    signup () {
      if (!this.checked) {
        alert('중복검사 실시')
      } else {
        this.formData.append("userName", this.credentials.username)
        this.formData.append("gender", this.credentials.gender)
        this.formData.append("birthYear", this.credentials.birthYear)
        //formData를 axios로 서버로 보냄
        this.formData.append('email', '')
        this.$store.dispatch('signup', this.formData)
      }
     
    },

    selectFile (input) {
      var reader = new FileReader();
      reader.onload = function(e) {
      document.getElementById('preview').src = e.target.result;
    };
    console.log(input)
    console.dir(input)
    reader.readAsDataURL(input);
    this.formData.append('profileImg', input)
  },


    // getToken () {
    //   axios({
    //     methods:'post',
    //     url:'https://kauth.kakao.com/oauth/token',
    //     headers :{
    //       'Content-type': 'application/x-www-form-urlencoded;charset=utf-8',
    //     },
    //     params:{
    //       grant_type: 'authorization_code',
    //       client_id: process.env.VUE_APP_KAKAO_API_KEY,
    //       redirect_uri: 'http://localhost:8080/signup',
    //       code: this.code,
    //     }
    //   })
    //   .then(res => {
    //     console.log(res)
    //     this.accessToken = res.data.access_token,
    //     console.log(res.data.access_token)
    //     this.refreshToken = res.data.refresh_token
    //     window.Kakao.Auth.setAccessToken(res.data.access_token);
    //     window.Kakao.API.request({
    //         url: '/v2/user/me', // 사용자 정보 가져오기
    //       })
    //         .then(function(response) {
    //           console.log(response)
    //         })
    //         .catch(function(error) {
    //           console.error(error)
    //         })
    //   })
    // }

    getToken () {
      axios({
        method:'get',
        url: api.accounts.login(),
        params:{
          code:this.code
        },
      }).then(res => {
        this.imgUrl = res.data.data.profileImage
        console.log(res)
        this.saveToken(res.data.data.accessToken)
        this.formData.append('userId', res.data.data.userId)
        
        // this.fetchCurrentUser(res.data.data.userName)
        if (res.data.data.result === 1) {
          this.$router.push('/')
        } else {
          this.credentials.username = res.data.data.userName
        }
      })
      .catch(err => 
      console.error(err))
    },

    createSnow () {
      const el = document.createElement("div")
      el.classList.add('snow')
      el.style.position = 'relative'
      el.style.animation = 'snow'
      // el.style.top = 0
      el.style.left = this.randomPosition() + 'px'
      
      const body = document.querySelector(".body")
      body.appendChild(el)
    },

    randomPosition () {
      return Math.floor(Math.random() * window.innerWidth)
    },

  
  },
  mounted () {
    setInterval(this.createSnow, 1000)

  },

  created() {
    this.code = this.$route.query.code
    this.getToken()
  }
}
</script>

<style scoped>
@import "@/scss/common.scss";
/* div {
  margin: 10px;
} */
.image {
  display: flex;
  flex-direction: row;
  align-items: center;
}
.body {
  height: 100vh;
  width: 100vw;
  /* background: radial-gradient(#f4c41f, #239347); */
  position: relative;
  display: flex;
  align-items: center;
  overflow: hidden;
  padding-bottom: 60px;
}
.body::after {
  content: "";
  background: radial-gradient(#f4c41f, #239347);
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  opacity: 0.4;
}
.v-select{
  padding-top: 0px;
  margin-top: 0px;
}
.container {
  height: 600px;
  width: 80%;
  margin: auto;
  border: 1px solid;
  border-radius: 20px;
  z-index: 1;
}
.title {
  height:46px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.form {
  width: 80%;
  margin: auto;
}
.main_btn {
  display: flex;
  justify-content: end;
}
.name_btn {
  margin-left: auto;
}
.snow {
  position: relative;
  animation: snow 10s linear infinite;
  /* left: 100px; */
}
.snow::after {
  content: "";
  height: 30px;
  width: 30px;
  background-image: url('@/assets/bread.png');
  background-size: cover;
  
  position: absolute;
  top: 0;
  left: 0; 
}
@keyframes snow {
  0%{
    opacity: 0;
    transform: translateY(-50vh);
  }
  20%{
    opacity: 1;
    transform: translate(-15px,-30vh);
  }
  40%{
    opacity: 1;
    transform: translate(15px,-10vh);
  }
  60%{
    opacity: 1;
    transform: translate(-15px,10vh);
  }
  80%{
    opacity: 1;
    transform: translate(15px,30vh);
  }
  100%{
    opacity: 1;
    transform: translateY(50vh);
  }
}
</style>