<template>
  <div>
    <v-card class="sand_big_card">
      <div class="close">
        <v-btn class="c_btn pa-0" text >
          <v-icon>mdi-close</v-icon>
        </v-btn>
      </div>
      <div class="content">
        <div class="first">
          <div class="imgwrap">
            <img :src="sand.imgUrl" alt="">
          </div>
          <div class="title">
            {{ sand.combName }}
          </div>
        </div>
        <div class="second">
          <div class="ingre">
            <div class="menu">
              메뉴: {{ sand.menuName }}
            </div>
            <div class="more">
              추가재료: {{ more }}
            </div>
            <div class="sauce">
              소스: {{ sauce }}
            </div>
          </div>
          <v-btn class="green_btn" rounded small>바로주문</v-btn>
          <v-btn class="main_btn" rounded small>상세보기</v-btn>
        </div>
      </div>
    </v-card>
    <combi-modal
      :combiListItem="sandListItem"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import CombiModal from "@/components/common/CombiModal.vue";

export default {
  name: "SandBigListItem",
  components: { CombiModal },
  props: {
    sandListItem: Object,
  },
  data() {
    return {
      dialogRecoCombi: false,
    };
  },

  computed: {
    sand () {
      return this.sandListItem.combinationPostDto
    },

    more () {
      let more = ''
      const moremap = {
        '5a' : '아메리칸 치즈',
        '5b' : '슈레드 치즈',
        '5c' : '모차렐라 치즈',
        '6a' : '에그마요',
        '6b' : '베이컨',
        '6c' : '아보카도',
        '6d' : '오믈렛',
        '6e' : '페퍼로니',
        '7a' : '스테이크/치즈',
        '7b' : '치킨베이컨',
        '7c' : 'k-바비큐',
        '7d' : '로스트 치킨',
        '7e' : '로티세리 치킨',
        '6f' : '풀드포크',
        '7g' : '쉬림프',
        '7h' : '클럽',
        '7i' : '치킨 데리야끼',
        '7j' : '스파이시 이탈리안',
        '7k' : '비엠티',
        '7l' : '비엘티',
        '7m' : '치킨슬라이스',
        '7n' : '머쉬룸',
        '7o' : '참치',
        '7p' : '햄',
      }
      for (let i = 0; i < this.sand.combination.combinationId.length ; i ++) {
        if(this.sand.combination.combinationId[i] === '5' || 
        this.sand.combination.combinationId[i] === '6' || 
        this.sand.combination.combinationId[i] === '7') {
          more += moremap[this.sand.combination.combinationId[i] + this.sand.combination.combinationId[i+1]] + ', '
        }
      }
      return more.slice(0, -2) 
    },

    sauce () {
      let sauce = ''
      const saucemap = {
        '4a' : '랜치',
        '4b' : '마요네즈',
        '4c' : '스위트 어니언',
        '4d' : '허니 머스타드',
        '4e' : '스위트 칠리',
        '4f' : '핫 칠리',
        '4g' : '사우스웨스트 치폴레',
        '4h' : '머스타드',
        '4i' : '홀스래디쉬',
        '4j' : '올리브 오일',
        '4k' : '레드와인식초',
        '4l' : '소금',
        '4m' : '후추',
        '4n' : '스모크 바비큐',
      }
      for (let i = 0; i < this.sand.combination.combinationId.length ; i ++) {
        if(this.sand.combination.combinationId[i] === '4') {
          sauce += saucemap[this.sand.combination.combinationId[i] + this.sand.combination.combinationId[i+1]] + ', '
        }
      }
      return sauce.slice(0, -2) 
    },
  }
};
</script>

<style >
.sand_big_card {
  height: 140px;
  width: 90%;
  margin: auto;
  margin-bottom: 20px;
  display: block;
}
.sand_big_card:last-child {
  margin-bottom: 25px;
}
.close {
  float: right;
}
.content {
  display: flex;
  height: 100%;
}
.first {
  width: 40%;
}
.second {
  width: 60%;
}
.imgwrap img {
  display:block;
	/* height:100%; */
	width:auto;
  object-fit: cover;
}
.imgwrap {
  height: 60%;
}
</style>
