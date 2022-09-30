<template>
  <div class="container">
    <div class="logo">
      <img src="@/assets/logonav.png" alt="">
    </div>
    <div class="login_btn">
      <img src="@/assets/kakao_login_medium_narrow.png" @click="loginWithKakao">
    </div>
  </div>
</template>

<script>
// import axios from "axios"


export default {
  name: 'LoginView',
  
  // created() {
  //   console.log(process.env.VUE_APP_JAVASCRIPT_KEY)
  // },

  methods: {
    loginWithKakao() {
      console.log(window.Kakao)
      window.Kakao.Auth.authorize({
        scope: 'profile_nickname, profile_image',
        redirectUri: 'http://localhost:8080/signup',
      });
    }
  }

}
</script>

<style scoped>
.logo {
  position: relative;
  top: 30%;
  width: 80%;
  margin: auto;
  z-index: 1;
}
.logo img{
	display:block;
	width:100%;
	height:auto;
  
}

.container {
  height: 100%;
  width: 100%;
  position: relative;
  z-index: 1;
  
}

.container::before {
  content: "";
  width: 100%;
  height: 100%;
  opacity: 0.5;
  background: url('@/assets/subway.jpg');
  background-size : cover;
  background-repeat : no-repeat;
  position: absolute;
  z-index: -1;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

.login_btn img{
  display:block;
	width: 80%;
  margin: auto;
  
}
.login_btn {
  position: relative;
  top: 50%;
  margin: auto;
  width: 80%;
  z-index: 1;
}


</style>