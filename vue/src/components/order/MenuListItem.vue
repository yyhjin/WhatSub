<template>
  <div class="container" @click.prevent="select($event, menu)">
    <div class="imgwrap">
      <img :src="menu.imgUrl" alt="">
    </div>
    <div class="content">
      <div class="title">{{ menu.menuName }}
      </div>
      <div class="ingred">{{ menu.ingredients }}
      </div>
    </div>
    <div class="price">{{ menu.price }}원
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name: "MenuListItem",

  computed: {
    ...mapGetters(['selectedMenu']),
  },

  props: {
    menu: Object
  },

  methods: {
    ...mapActions(['selectMenu']),
    select (event, menu) {
      if (this.selectedMenu === menu) {
        event.currentTarget.classList.remove('select')
        this.selectMenu()
      } else {
        this.removeSelect()
        event.currentTarget.classList.add('select')
        this.selectMenu(menu)
      }
    },

    removeSelect () {
      document.querySelectorAll(".container").forEach(select =>{
          select.classList.remove('select')
        })
    }
  }
}
</script>

<style scoped>
.container {
  width: 100%;
  height: 90px;
  display: flex;
  border-bottom: 1px solid;
  justify-content: space-between;
  align-items: center;
}
.imgwrap img {
  display:block;
	height:100%;
	width:auto;
}
.imgwrap {
  height: 100%;
}
.content {
  text-align: center;
}
.title {
  font-size: 15px;
  font-weight: 700;
}
.ingred {
  font-size: 10px;
  font-weight: 400;
}
.price {
  font-size: 13px;
}
.select {
  border: 2px solid #239347;
}
</style>