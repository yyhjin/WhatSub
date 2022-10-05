<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-8"><h3>꿀조합 등록</h3></v-col>
      </v-row>
    </div>
    <div class="pt-20" align="center">
      <input id="imgUpload" type="file" @change="selectFile">
      <v-img
        height="100"
        width="250"
        :src="imgUrl"
        alt="sandwitch"
      ></v-img>
      <div class="pt-3"><h2 style="font-size: 17px">{{ name }}</h2></div>
      <div class="pt-1 pb-8" style="font-size: 15px">{{ com.price }}원</div>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div>
      <v-tabs v-model="tab" fixed-tabs>
        <v-tabs-slider color="#239347"></v-tabs-slider>
        <v-tab class="tab_text_color" v-for="item in items" :key="item">
          <h3>{{ item }}</h3>
        </v-tab>
      </v-tabs>
      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item">
          <v-card class="mb-3" v-if="item == '조합정보'" flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-regist-info :combination="com.combinationId"></combi-regist-info>
            </div>
          </v-card>
          <v-card class="mb-3" v-else flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-regist-nutrition :com="com"></combi-regist-nutrition>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div class="pa-5">
      <div style="font-size: 15px; font-weight: bold">꿀조합 이름</div>
      <v-text-field outlined solo dense v-model="title"></v-text-field>
      <div style="font-size: 15px; font-weight: bold">꿀조합 설명</div>
      <v-textarea style="font-size: 15px" height="200" outlined solo v-model="content"></v-textarea>
    </div>
    <div class="mt-n3" align="center">
      <v-btn class="main_btn" rounded @click.prevent="registCombi">꿀조합 등록하기</v-btn>
    </div>
    <br />
    <br />
    <br />
    <br />
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from "@/components/common/BottomNav.vue";
import CombiRegistInfo from '../../components/combination/regist/CombiRegistInfo.vue';
import CombiRegistNutrition from '../../components/combination/regist/CombiRegistNutrition.vue';
import { mapActions, mapGetters } from 'vuex';
import axios from 'axios';

export default {
  name: "RegistCombinationView",
  components: { BottomNav, CombiRegistInfo, CombiRegistNutrition },
  props: {
    imgUrl: String,
    name: String,
    combinationId: String,
    combi:String
  },
  data() {
    var  formData = new FormData()
    return {
      tab: null,
      items: ["조합정보", "영양정보"],
      title: '',
      content: '',
      formData: formData

    };
  },

  computed: {
    ...mapGetters(['profile', 'username']),
    com () {
      return JSON.parse(this.combi)
    }
  },

  methods: {
    ...mapActions(['fetchProfile']),
    selectFile (event) {
      console.log(event.target.files[0])
      this.formData.append("file", event.target.files[0])
    },
    goBack() {
      this.$router.go(-1);
    },

    registCombi () {
      // const frm = new FormData()
      // const photoFile = document.getElementById("imgUpload")
      const data = {
          "combName": this.title,
          "combinationId": this.combinationId,
          "content": this.content,
          "userId": this.profile.userId
        }
      // frm.append("combPostRequest", new Blob([JSON.stringify(data)] , {type: "application/json"}))
      // frm.append("file", photoFile.files[0])
      this.formData.append("combPostRequest", new Blob([JSON.stringify(data)] , {type: "application/json"}))
      // this.formData.append("combPostRequest", data)
      this.formData.append("file", 'sdfsd')
      // console.log(this.formData.values())
      axios({
        url: "https://j7a105.p.ssafy.io/api/v1/comb/board",
        method: 'post',
        data: this.formData,
        headers:{
          'Content-Type':'multipart/form-data'
        }
      }).then(res => {
        console.log(res)
        this.$router.push({name:'home'})
      }).catch(err => 
      console.error(err))
    }
  },

  mounted () {
    this.fetchProfile({username:this.username})
  }
};
</script>

<style scoped>
.top {
  padding: 10px;
  position: fixed;
  width: 100%;
  z-index: 2;
}
</style>
