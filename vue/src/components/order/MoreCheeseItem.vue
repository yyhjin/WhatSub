<template>
<div class="cheese">
    <button class="oneChoose moreCheeseChoose" @click="select($event, moreChe)" ></button>
    <div class="title">{{ moreChe.name }}</div>
    <div class="price">+{{ moreChe.price }}원</div>
  </div>
  
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name: 'MoreCheeseItem',

  props: {
    moreChe:Object
  },

  computed: {
    ...mapGetters(['selectedMoreCheese'])
  },

  methods: {
    ...mapActions(['selectMoreCheese']),
    select (event, moreChe) {
      document.querySelectorAll('.moreCheeseChoose').forEach(each => {
        each.classList.remove('checked')
        })
      if (moreChe === this.selectedMoreCheese) {
        this.selectMoreCheese(null)
      } else {
        event.target.classList.add('checked')
        this.selectMoreCheese(moreChe)
      }
    }
  },

  mounted () {
    if (this.moreChe.ingredientId === this.selectedMoreCheese.ingredientId) {
      this.$el.childNodes[0].classList.add("checked")
    }
  }
}
</script>

<style scoped>
.cheese {
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
.oneChoose {
  width: 24px;
  height: 24px;
  border-radius: 50%;
  border: 8px solid  #D9D9D9;
  margin-right: 5px;
}
.checked {
  border-color: #239347;
  background-color: #f4c41f;
}

</style>