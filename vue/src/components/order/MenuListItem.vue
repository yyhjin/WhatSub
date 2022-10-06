<template>
  <div class="container" @click.prevent="select($event, menu)">
    <div class="imgwrap">
      <img :src="menu.imgUrl" alt="" />
    </div>
    <v-row>
      <v-col cols="9">
        <div>
          <div class="pb-2">
            <h4 style="font-size: 16px">
              {{ menu.menuName }}
            </h4>
          </div>
          <div class="ingred">{{ menu.ingredients }}</div>
        </div>
      </v-col>
      <v-col class="pa-0 pt-4" cols="3">
        <div class="price">{{ menu.price | comma }}원</div>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "MenuListItem",

  computed: {
    ...mapGetters(["selectedMenu"]),
  },

  props: {
    menu: Object,
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions(["selectMenu"]),
    select(event, menu) {
      if (this.selectedMenu === menu) {
        event.currentTarget.classList.remove("select");
        this.selectMenu();
      } else {
        this.removeSelect();
        event.currentTarget.classList.add("select");
        this.selectMenu(menu);
      }
    },

    removeSelect() {
      document.querySelectorAll(".container").forEach((select) => {
        select.classList.remove("select");
      });
    },
  },

  mounted() {
    if (this.selectedMenu !== null && this.menu.menuId === this.selectedMenu.menuId) {
      this.$el.classList.add("select");
    }
  },
};
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
  display: block;
  height: 100%;
  width: auto;
}
.imgwrap {
  height: 80px;
}
.content {
  text-align: center;
}
.title {
  font-weight: 700;
}
.ingred {
  font-size: 12px;
  font-weight: 400;
}
.price {
  font-size: 13px;
}
.select {
  border: 2px solid #239347;
}
</style>
