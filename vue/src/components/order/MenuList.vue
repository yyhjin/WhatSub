<template>
  <div>
    <menu-list-item :menu="menu" v-for="menu in menus" :key="menu.menu_id"></menu-list-item>
  </div>
</template>

<script>
import MenuListItem from './MenuListItem.vue'
import { mapGetters } from 'vuex';
export default {
  name: "MenuList",

  components: { MenuListItem },

  computed: {
    ...mapGetters(['menus']),
  },


}
</script>

<style>

</style>