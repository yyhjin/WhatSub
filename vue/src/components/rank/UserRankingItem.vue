<template>
  <div class="main_card">
    <v-card class="home_card_b" elevation="3" outlined>
      <div class="imgwrap">
        <img :src="sand.menu_imgurl" alt="">
      </div>
      <div class="rank">
        <h3 value="고기">{{ sand.menu }}</h3>
        <h5>{{sand.rank1.ranking}}위 {{ sand.rank1.username }} {{ sand.rank1.cnt }}개</h5>

      </div>
    </v-card>
  
  </div>
</template>

<script>
export default {
  name: "UserRankingItem",

  props:{
    sand: Object,
    index: Number
  },

  // data () {
  //   return {
  //     // ranking : this.index + 1
  //   }
  // },

  // computed : {
  //   ranking () {
  //     return this.index + 1
  //   },
  //   name1 () {
  //     return this.sand.rank1.username
  //   },
  //   name2() {
  //     return this.sand.rank2.username
  //   },
  //   name3 () {
  //     return this.sand.rank3.username
  //   },
  //   name4 () {
  //     return this.sand.rank4.username
  //   },
  //   cnt1 () {
  //     return this.sand.rank1.cnt
  //   },
  //   cnt2() {
  //     return this.sand.rank2.cnt
  //   },
  //   cnt3 () {
  //     return this.sand.rank3.cnt
  //   },
  //   cnt4 () {
  //     return this.sand.rank4.cnt
  //   }
  // },

  // mounted() {
  //   console.log(this.sand)
  //   console.log(this.ranking)
  //   let h = document.querySelector('h5')
  //   h.innerText = `${this.ranking}`
  // }
}
</script>

<style scoped>
.main_card {
  margin: 20px;
  width: 90%;
  height: 80px;

  
}
.imgwrap img {
  display:block;
	height:100%;
	width:auto;
}
.imgwrap {
  height: 100%;
}
.home_card_b {
  height:100%;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}

</style>