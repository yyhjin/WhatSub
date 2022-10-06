<template>
  <div class="vege">
    <input type="checkbox"  v-model="isVege" class="multiChoose" @click="select($event, vege)">
    <div class="title">{{ vege.name }}</div>
    <div class="price">+{{ vege.price }}원</div>
  </div>
  
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name: 'VegeItem',

  data () {
    return {
      isVege:false
    }
  },

  props:{
    vege:Object
  },

  computed: {
    ...mapGetters(['selectedVege'])
  },

  methods: {
    ...mapActions(['selectVege', 'removeVege']),

    select (event, vege) {
      console.log(event.target)
      if (event.target.checked) {
        this.selectVege(vege)
      } else {
        this.removeVege(vege) 
      }
    }
  },

  mounted () {
    this.selectedVege.forEach(each => {
      if (each.ingredientId === this.vege.ingredientId) {
        this.isVege = true  
      }
    })
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