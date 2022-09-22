<template>
  <div>
    <div class="title">회원가입</div>
    <v-form class="form" @submit.prevent="signup">
      <v-file-input prepend-icon="mdi-account"  @change="selectFile"></v-file-input>
      <div class="nickname">
        <v-text-field label="닉네임" v-model="credentials.username"></v-text-field>
        <v-btn class="main_btn" @click="checkId">닉네임 중복검사</v-btn>
      </div>
      <div class="gender">
        성별
        <v-radio-group v-model="credentials.gender" row class="radio">
          <v-radio
            label="남자"
            value="radio-1"
          ></v-radio>
          <v-radio
            label="여자"
            value="radio-2"
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
</template>

<script>
// import axios from 'axios'

export default {
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
        birthYear: ''
      },
      items : items,
      formData: formData
    }
  },

  methods: {
    checkId () {
      //axios로 요청보내서 검사
    },
    signup () {
      this.formData.append("username", this.credentials.username)
      this.formData.append("gender", this.credentials.gender)
      this.formData.append("birthYear", this.credentials.birthYear)
      //formData를 axios로 서버로 보냄
    },
    selectFile (event) {
      console.log(event)
      this.formData.append('profile_img', event)
    }
  }
}
</script>

<style scoped>
@import "@/scss/common.scss";
div {
  margin: 10px;
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
</style>