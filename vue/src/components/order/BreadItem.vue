<template>
  <div class="bread">
    <button class="oneChoose breadchoose" @click="select($event, bread)" name="bread"></button>
    <div class="title">{{ bread.name }}</div>
    <div class="price">+{{ bread.price }}원</div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'BreadItem',

  props:{
    bread:Object
  },

  methods: {
    ...mapActions(['selectBread']),
    select (event, bread) {
      document.querySelectorAll('.breadchoose').forEach(each => {
        each.classList.remove('checked')
        })
      event.target.classList.add('checked')
      this.selectBread(bread)

    }
  }
}
</script>

<style scoped>
.bread {
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