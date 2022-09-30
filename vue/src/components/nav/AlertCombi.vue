<template>
  <v-dialog class="modal_st" :value="openAlert" @input="openAlert = $event">
    <v-card class="modal_st al" align="center" height="220" outlined>
      <h4 class="pt-15 pb-6" style="font-size: 15px">
        등록된 꿀조합이 없습니다.<br />직접 등록하시겠습니까?
      </h4>
      <div>
        <v-btn class="green_btn" small rounded @click="goRegistCombi">꿀조합 등록</v-btn>
      </div>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "AlertCombi",
  props: {
    value: {
      type: Boolean,
      required: true,
    },
  },
  computed: {
    openAlert: {
      get() {
        return this.value;
      },
      set(value) {
        this.$emit("input", value);
      },
    },
  },
  methods: {
    goRegistCombi() {
      this.$router.push({ name: "registcombination" });
    },
  },
};
</script>

<style>
.al.v-sheet.v-card {
  border-color: #f4c41f !important;
  border-width: 5px;
}
.modal_st {
  background: rgba(255, 255, 255, 0.9);
}
</style>
