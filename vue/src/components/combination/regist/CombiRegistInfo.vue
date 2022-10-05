<template>
  <div style="font-size: 14px">
    <v-row class="r_border" align="center">
      <v-col class="pa-0 pl-3" cols="2"
        ><v-img width="30" height="30" src="@/assets/combiInfo/bread.png" alt="Logo" />
      </v-col>
      <v-col class="c_border" align="center">
        <div >{{ bread }}</div>
      </v-col>
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/cheese.png" alt="Logo" />
      </v-col>
      <v-col cols="4" align="center">
        <div >{{ cheese }}</div>
      </v-col>
    </v-row>
    <v-row class="r_border" align="center">
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/vegetable.png" alt="Logo" />
      </v-col>
      <v-col cols="4" class="c_border" align="center">
        <div v-for="(vegeItem, index) in vege" :key="index">{{ vegeItem }}</div>
      </v-col>
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/sauce.png" alt="Logo" />
      </v-col>
      <v-col align="center">
        <div v-for="(sauceItem, index) in sauce" :key="index">{{ sauceItem }}</div>
      </v-col>
    </v-row>
    <v-row align="center">
      <v-col align="center" cols="4"> 추가재료 </v-col>
      <v-col cols="8" align="center"> <div v-for="(sauceItem, index) in more" :key="index">{{ sauceItem }}</div> </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'CombiRegistInfo',

  data () {
    return {
      bread: null,
      cheese: null,
      vege: [],
      sauce: [],
      more: [],
      mapDict: {
      '1a': '허니오트', '1b': '하티', '1c': '위트', '1d': '파마산 오레가노', 
      '1e': '화이트', '1f': '플랫브레드', '2a': '아메리칸치즈', '2b': '슈레드치즈', 
      '2c': '모차렐라치즈', '3a': '양상추', '3b': '토마토', '3c': '오이', '3d': '피망', 
      '3e': '양파', '3f': '피클', '3g': '올리브', '3h': '할라피뇨', '4a': '랜치', 
      '4b': '마요네즈', '4c': '스위트 어니언', '4d': '허니 머스타드', '4e': '스위트 칠리', '4f': '핫 칠리', 
      '4g': '사우스웨스트 치폴레', '4h': '머스타드', '4i': '홀스래디쉬', '4j': '올리브 오일', 
      '4k': '레드와인식초', '4l': '소금', '4m': '후추', 
      '4n': '스모크 바비큐', '5a': '아메리칸치즈', '5b': '슈레드치즈', 
      '5c': '모차렐라치즈', '6a': '에그마요', 
      '6b': '베이컨', '6c': '아보카도', '6d': '오믈렛', '6e': '페퍼로니', 
      '7a': '스테이크/치즈', '7b': '치킨베이컨',
      '7c': 'K-바비큐', '7d': '로스트 치킨', '7e': '로티세리 치킨', '6f': '풀드포크', 
      '7g': '쉬림프', '7h': '클럽(치킨)', '7i': '치킨 데리야끼', '7j': '스파이시 이탈리안', 
      '7k': '비엠티', '7l': '비엘티', '7m': '치킨슬라이스', 
      '7n': '머쉬룸', '7o': '참치', '7p': '햄'}
    }
  },

  props: {
    combination:String
  },

  mounted () {
    for (let i=0; i<this.combination.length; i ++) {
      if (this.combination[i] === '1') {
        let id = this.combination[i] + this.combination[i+1]
        this.bread = this.mapDict[id]
      } else if (this.combination[i] === '2') {
        let id = this.combination[i] + this.combination[i+1]
        this.cheese = this.mapDict[id]
      } else if (this.combination[i] === '3') {
        let id = this.combination[i] + this.combination[i+1]
        this.vege.push(this.mapDict[id])
      } else if (this.combination[i] === '4') {
        let id = this.combination[i] + this.combination[i+1]
        this.sauce.push(this.mapDict[id])
      } else if (this.combination[i] === '5' || (this.combination[i] === '6') || (this.combination[i] === '7')) {
        let id = this.combination[i] + this.combination[i+1]
        this.more.push(this.mapDict[id])
      }
    }
  }
}
</script>

<style>

</style>