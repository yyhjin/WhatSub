<template>
  <div class="sauce">
    <input
      type="checkbox"
      v-model="isSauce"
      name="sauce"
      class="multiChoose"
      @click="select($event, sa)"
    />
    <div class="title" style="font-size: 16px !important">{{ sa.name }}</div>
    <div class="price">+{{ sa.price }}원</div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import swal from 'sweetalert';
export default {
  name: "SauceItem",

  data() {
    return {
      isSauce: false,
    };
  },

  props: {
    sa: Object,
  },

  computed: {
    ...mapGetters(["selectedSauce"]),
  },

  methods: {
    ...mapActions(["selectSauce", "removeSauce"]),

    select(event, sauce) {
      if (this.isSauce === false && this.selectedSauce.length === 3) {
        swal("3개만 고르세요");
        event.target.checked = false;
      } else {
        if (event.target.checked) {
          this.selectSauce(sauce);
        } else {
          this.removeSauce(sauce);
        }
      }
    },
  },

  mounted() {
    this.selectedSauce.forEach((each) => {
      if (each.ingredientId === this.sa.ingredientId) {
        this.isSauce = true;
      }
    });
  },
};
</script>

<style scoped>
.sauce {
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
  width: 20px;
  height: 20px;

  border: 8px solid #d9d9d9;
  margin-left: 5px;
  margin-right: 5px;
}
.multiChoose:checked {
  accent-color: #239347;
}
</style>
