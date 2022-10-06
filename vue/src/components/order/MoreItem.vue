<template>
  <div class="more">
    <input
      type="checkbox"
      v-model="isMore"
      name="more"
      class="multiChoose"
      @click="select($event, mo)"
    />
    <div class="title">{{ mo.name }}</div>
    <div class="price">+{{ mo.price | comma }}원</div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "MoreItem",

  data() {
    return {
      isMore: false,
    };
  },

  computed: {
    ...mapGetters(["selectedMore"]),
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  props: {
    mo: Object,
  },

  methods: {
    ...mapActions(["selectMore", "removeMore"]),

    select(event, more) {
      if (event.target.checked) {
        this.selectMore(more);
      } else {
        this.removeMore(more);
      }
    },
  },

  mounted() {
    this.selectedMore.forEach((each) => {
      if (each.ingredientId === this.mo.ingredientId) {
        this.isMore = true;
      }
    });
  },
};
</script>

<style scoped>
.more {
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

  border: 8px solid #d9d9d9;
  margin-right: 5px;
}
.multiChoose:checked {
  accent-color: #239347;
}
</style>
