<template>
  <div>
    <div class="cheese">
      <button class="oneChoose cheeseChoose"  @click="select($event, chee)"></button>
      <div class="title">{{ chee.name }}</div>
      <div class="price">+{{ chee.price }}원</div>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'CheeseItem',

  props: {
    chee: Object
  },

  methods: {
    ...mapActions(['selectCheese']),
    select (event, chee) {
      document.querySelectorAll('.cheeseChoose').forEach(each => {
        each.classList.remove('checked')
        })
      event.target.classList.add('checked')
      this.selectCheese(chee)

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