<template>
  <div class="moreMeat">
    <button class="oneChoose moreMeatChoose" @click="select($event, moreMeat)"></button>
    <div class="title">{{ moreMeat.name }}</div>
    <div class="price">+{{ moreMeat.price | comma }}원</div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "MoreMeatItem",

  props: {
    moreMeat: Object,
  },

  computed: {
    ...mapGetters(["selectedMoreMeat"]),
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions(["selectMoreMeat", "removeMoreMeat"]),
    select(event, moreMeat) {
      document.querySelectorAll(".moreMeatChoose").forEach((each) => {
        each.classList.remove("checked");
      });
      if (moreMeat === this.selectedMoreMeat) {
        this.selectMoreMeat(null);
      } else {
        event.target.classList.add("checked");
        this.selectMoreMeat(moreMeat);
      }
    },
  },

  mounted() {
    if (
      this.selectedMoreMeat !== null &&
      this.moreMeat.ingredientId === this.selectedMoreMeat.ingredientId
    ) {
      this.$el.childNodes[0].classList.add("checked");
    }
  },
};
</script>

<style scoped>
.moreMeat {
  margin-top: 10px;
  margin-bottom: 10px;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.oneChoose {
  width: 24px;
  height: 24px;
  border-radius: 50%;
  border: 8px solid #d9d9d9;
  margin-right: 5px;
}
.price {
  position: relative;
  right: 0;
  margin-left: auto;
}
.title {
  width: 70%;
}
.checked {
  border-color: #239347;
  background-color: #f4c41f;
}
</style>
