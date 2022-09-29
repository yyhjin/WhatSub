<template>
  <div class="vege">
    <input type="checkbox"  class="multiChoose" @click="select($event, vege)">
    <div class="title">{{ vege.name }}</div>
    <div class="price">+{{ vege.price }}원</div>
  </div>
  
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'VegeItem',

  props:{
    vege:Object
  },

  methods: {
    ...mapActions(['selectVege', 'removeVege']),

    select (event, vege) {
      if (event.target.checked) {
        this.selectVege(vege)
      } else {
        this.removeVege(vege)
      }
    }
  }
}
</script>

<style scoped>
.vege {
  margin-top: 10px;
  margin-bottom: 10px;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.price {
  position: relative;
  right: 0;
  margin-left: auto;
}
.title {
  width: 70%;
}
.multiChoose {
  width: 25px;
  height: 25px;
  margin-right: 5px;
}
.multiChoose:checked{
  accent-color: #239347;
  
}
</style>