<template>
  <div class="main_card">
    <!-- <v-card-title>
        <h3 style="font-size: 20px">{{ sand.menuName }}</h3>
      </v-card-title> -->
    <!-- <div class="imgwrap">
        <img :src="sand.imgUrl" alt="" />
      </div> -->
    <!-- <v-row>
        <v-col class="pt-15" align="center"
          ><v-img src="@/assets/collection/silver.png" width="50"></v-img>
          <div>{{ sand.data[1].userName }}</div>
          <div>{{ sand.data[1].cnt }}개</div></v-col
        >
        <v-col align="center"
          ><v-img src="@/assets/collection/gold.png" width="50"></v-img
          >{{ sand.data[0].userName }}</v-col
        >
        <v-col class="pt-15" align="center"
          ><v-img src="@/assets/collection/bronze.png" width="50"></v-img
          >{{ sand.data[2].userName }}</v-col
        >
      </v-row> -->
    <!-- <v-expansion-panels v-model="panel" :disabled="disabled" multiple>
      <v-expansion-panel>
        <v-expansion-panel-header>
          <v-img :src="sand.imgUrl" max-width="150" alt="" /> {{ sand.menuName }}
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          <v-row align="center">
            <v-col>
              <v-img src="@/assets/collection/gold.png" width="40"></v-img>
            </v-col>
            <v-col>
              {{ sand.data[0].userName }}
            </v-col>
            <v-col>
              {{ sand.data[0].cnt }}
            </v-col>
          </v-row>
        </v-expansion-panel-content>
        <v-expansion-panel-content> Some content </v-expansion-panel-content>
        <v-expansion-panel-content> Some content </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels> -->
    <v-expansion-panels focusable multiple>
      <v-expansion-panel v-for="(sandItem, i) in sand" :key="i">
        <v-expansion-panel-header style="font-size: 18px">
          <v-row>
            <v-col>
              <div class="mb-5">
                {{ sandItem.menuName }}
              </div>
              <br />
              <br />
            </v-col>
          </v-row>
          <div class="shadow_img mt-7 ml-100" style="position: absolute">
            <v-img class="img_rank" :src="sandItem.imgUrl" max-width="120" alt="" />
          </div>
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          <v-row class="mt-1" align="center">
            <v-col cols="3" class="pa-0">
              <!-- <v-avatar><v-img :src="sandItem.data[0].profileImg"></v-img></v-avatar> -->
              <v-img src="@/assets/collection/gold.png" width="50"></v-img>
            </v-col>
            <v-col cols="6" align="left">
              {{ sandItem.data[0].userName }}
            </v-col>
            <v-col align="right"> {{ sandItem.data[0].cnt }}개 </v-col>
          </v-row>
        </v-expansion-panel-content>
        <v-divider></v-divider>
        <v-expansion-panel-content>
          <v-row class="mt-2" align="center">
            <v-col cols="3" class="pa-0">
              <v-img src="@/assets/collection/silver.png" width="50"></v-img>
            </v-col>
            <v-col cols="6" align="left">
              {{ sandItem.data[1].userName }}
            </v-col>
            <v-col align="right"> {{ sandItem.data[1].cnt }}개 </v-col>
          </v-row>
        </v-expansion-panel-content>
        <v-divider></v-divider>
        <v-expansion-panel-content>
          <v-row class="mt-2" align="center">
            <v-col cols="3" class="pa-0">
              <v-img src="@/assets/collection/bronze.png" width="50"></v-img>
            </v-col>
            <v-col cols="6" align="left">
              {{ sandItem.data[2].userName }}
            </v-col>
            <v-col align="right"> {{ sandItem.data[2].cnt }}개 </v-col>
          </v-row>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
    <br />
    <br />
    <br />
  </div>
</template>

<script>
// import ModalRanking from '@/components/rank/ModalRanking.vue'

export default {
  name: "UserRankingItem",

  props: {
    sand: Object,
    index: Number,
  },

  // components: { ModalRanking },

  methods: {},
};
</script>

<style scoped>
.main_card {
  margin: 20px;
  width: 90%;
  height: 250px;
}
.imgwrap img {
  display: block;
  height: 110px;
  width: auto;
}
.imgwrap {
  /* border-radius: 20px !important; */
  /* height: 200px !important;
  width: 200px !important; */
}
.home_card_b {
  height: 100%;
  width: 100%;
  /* display: flex; */
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
.rollingbanner {
  position: relative;
  width: 380px;
  height: 300px;
  font-size: 0.875rem;
  letter-spacing: -1px;
  padding: 7px 15px;
  box-sizing: border-box;
  background-color: #f0f0f0;
  border-radius: 16px;
}
.rollingbanner > .title {
  font-weight: bold;
  float: left;
  padding-right: 10px;
}
.rollingbanner > .wrap {
  position: relative;
  width: auto;
  height: 100%;
  box-sizing: border-box;
  overflow: hidden;
}
.rollingbanner h5 {
  position: absolute;
  top: -36px;
  left: 0;
}
.rollingbanner h5.prev {
  top: 36px;
  transition: top 0.5s ease;
}
.rollingbanner h5.current {
  top: 0;
  transition: top 0.5s ease;
}
.rollingbanner h5.next {
  top: -36px;
}
.ml-100 {
  margin-left: 120px;
}
</style>
