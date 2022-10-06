<template>
  <div>
    <v-card class="sand_big_card">
      <div class="first">
        <div class="imgwrap">
          <img :src="imgUrl" alt="">
        </div>
        <div class="title">
          {{ name }}
        </div>
      </div>
      <div class="second">
        <div class="ingre">
          <div class="menu">
            메뉴: {{ menu }}
          </div>
          <div class="more">
            추가재료: {{ more }}
          </div>
          <div class="sauce">
            소스: {{ sauce }}
          </div>
        </div>
        <v-btn class="green_btn" v-if="isRegisted" rounded small @click="goRegistForm">리뷰등록</v-btn>
        <v-btn class="green_btn" v-else rounded small @click="goRegistForm">조합등록</v-btn>
        <!-- <v-btn class="main_btn" rounded small>상세보기</v-btn> -->
      </div>
    </v-card>
    <alert-combi :imgUrl="imgUrl" :name="name" :combinationId="combination.combinationId" :combi="combi"     :value="openAlert" @input="openAlert = $event"></alert-combi>
  </div>
</template>

<script>
import AlertCombi from "@/components/nav/AlertCombi.vue";
import api from '@/api/api'
import axios from 'axios'
import { mapGetters } from 'vuex';
export default {
  name: 'SandByOrder',

  components: { AlertCombi },

  props: {
    combination: Object,
  },
  data() {
    return {
      isRegisted: false,
      openAlert: false,
      combinationPostId: null,
      imgUrl: this.combination.menu.imgUrl,
      name: this.combination.menu.menuName,
      menu: this.combination.menu.menuName,
      combi: null
    };
  },

  computed: {
    ...mapGetters(['profile']),
    more () {
      let more = ''
      this.combination.ingredients.forEach(each => {
        if (each.category === '추가' || each.category === '치즈추가' || each.category === '미트추가') {
          more += each.name + ', '
        }
      })
      return more.slice(0, -2)
    },

    sauce () {
      let sauce = ''
      this.combination.ingredients.forEach(each => {
        if (each.category === '소스') {
          sauce += each.name + ', '
        }
      })
      
      return sauce.slice(0, -2)
    }
  },

  watch : {
    isRegisted () {
      if (this.isRegisted) {
        axios({
          url: api.comb.comb.read(this.combinationPostId, this.profile.userId),
          method:'get'
        }).then(res=> {
          this.imgUrl = res.data.data.imgUrl
          this.name = res.data.data.combName
        }).catch(err => {
          console.error(err)
        })
      } 
    }

  },


  methods: {
    goRegistForm() {
      //꿀조합 여부 확인

      //리뷰 등록할 꿀조합이 있다면 리뷰 등록 화면으로 이동
      if (this.isRegisted) {
        this.$router.push({ name: "registreview", params: {combinationPostId: parseInt(this.combinationPostId)} });
      } else {
        //리뷰 등록할 꿀조합이 없다면 AlertCombi 띄워주기
        this.openAlert = true;
      }
    },
  },

  mounted () {
    axios({
      url: api.comb.comb.exist(this.combination.combinationId),
      method: 'get'
    }).then(res => {
      // console.log(res.data)
      console.log(typeof(res.data.data))
      if (typeof(res.data.data) === "number") {
        this.isRegisted = true
        this.combinationPostId = res.data.data
      } else {
        this.combi = res.data.data
      }
    }).catch(err => {
      console.error(err)
    })
  }
};
</script>

<style scoped>
.sand_big_card {
  height: 140px;
  width: 90%;
  margin: auto;
  margin-bottom: 20px;
  display: flex;
}
.sand_big_card:last-child {
  margin-bottom: 25px;
}
.first {
  width: 40%;
}
.second {
  width: 60%;
}
.imgwrap img {
  display:block;
	height:100%;
	width:auto;
}
.imgwrap {
  height: 60%;
}
</style>