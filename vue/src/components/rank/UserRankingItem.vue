<template>
  <div class="main_card">
    <v-card class="home_card_b" elevation="3" outlined>
      <div class="imgwrap">
        <img :src="sand.imgUrl" alt="">
      </div>
      <div class="rollingbanner">
        <h3 >{{ sand.menuName }}</h3>
        <div class="wrap">
          <h5 class="current">{{sand.data[0].ranking}}위 {{ sand.data[0].userName }} {{ sand.data[0].cnt }}개</h5>
          <h5 class="next">{{sand.data[1].ranking}}위 {{ sand.data[1].userName }} {{ sand.data[1].cnt }}개</h5>
          <h5 class="prev">{{sand.data[1].ranking}}위 {{ sand.data[1].userName }} {{ sand.data[1].cnt }}개</h5>
          <!-- <h5 class="prev">{{sand.rank4.ranking}}위 {{ sand.rank4.username }} {{ sand.rank4.cnt }}개</h5> -->
        </div>
      </div>
    </v-card>
    
  
  </div>
</template>

<script>
// import ModalRanking from '@/components/rank/ModalRanking.vue'

export default {
  name: "UserRankingItem",

  props:{
    sand: Object,
    index: Number
  },

  // components: { ModalRanking },
  

  methods : {
    rollingCallback () {
      //.prev 클래스 삭제
        document.querySelectorAll('.rollingbanner .prev').forEach(selected => 
        selected.classList.remove('prev'));

        //.current -> .prev
        let current = document.querySelectorAll('.rollingbanner .current');
        current.forEach(selected => {
          selected.classList.remove('current');
          selected.classList.add('prev')
          });

        //.next -> .current
        let next = document.querySelectorAll('.rollingbanner .next');
        
        //다음 목록 요소가 널인지 체크
        next.forEach(selected => {
          if(selected.nextElementSibling == null){
            document.querySelectorAll('.rollingbanner .wrap h5:first-child').forEach(sel =>
            sel.classList.add('next'));
            
          }else{
            //목록 처음 요소를 다음 요소로 선택
              selected.nextElementSibling.classList.add('next');
          }
          selected.classList.remove('next');
          selected.classList.add('current');
        })
    }
  },

  mounted () {
    window.addEventListener('load', ()=>{
      window.setInterval(this.rollingCallback, 3000);
    })
  }
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
.rollingbanner{
    position: relative;
    width: 380px;
    height: 32px;
    font-size: .875rem;
    letter-spacing: -1px;
    padding: 7px 15px;
    box-sizing: border-box;
    background-color: #f0f0f0;
    border-radius: 16px;
}
.rollingbanner > .title{
    font-weight: bold;
    float: left;
    padding-right: 10px;
}
.rollingbanner > .wrap{
    position: relative;
    width: auto;
    height: 100%;
    box-sizing: border-box;
    overflow: hidden;
} 
.rollingbanner h5{
    position: absolute;
    top: -36px;
    left: 0;
}
.rollingbanner h5.prev{
    top: 36px;
    transition: top 0.5s ease;
}   
.rollingbanner h5.current{
    top: 0;
    transition: top 0.5s ease;
}
.rollingbanner h5.next{
    top: -36px;
}

</style>