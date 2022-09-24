<template>
  <div class="container">
    <img src="@/assets/kakao_login_medium_narrow.png" @click="loginWithKakao">
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
.container {
  height: 100vh;
  background-image: url('@/assets/subway.jpg');
  background-size : cover;
  background-repeat : no-repeat;
  opacity: 0.6;
}


</style>