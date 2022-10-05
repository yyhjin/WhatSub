<template>
  <v-dialog scrollable :value="openMo" @input="openMo = $event">
    <v-card height="680">
      <v-card-title class="pt-3 pl-4">
        <v-row>
          <v-col>
          </v-col>
          <v-spacer></v-spacer>
          <v-col align="right">
            <v-btn class="c_btn pa-0" text @click.stop="openMo = false">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-card-title>
      <div class="date">
        {{date}}
      </div>
      <div class="store">

      </div>

      <v-card-text>
        <order-de  :menu="menu"  v-for="(menu, index) in orderMenu.combinationList" :key="index"></order-de>

      </v-card-text>
      <v-card-actions class="pl-5 pb-5">
        <div style="font-size: 18px; font-weight: 900">
           {{ orderMenu.orderPrice }}원
        </div>
        <v-spacer></v-spacer>
        <v-btn class="main_btn" width="180" elevation="0" rounded @click.prevent="goOrderCombi"
          >주문하러 가기</v-btn
        >
      </v-card-actions>
    </v-card>
    
  </v-dialog>
</template>

<script>
import OrderDe from './OrderDe.vue';


export default {
  components: { OrderDe },

  name: "OrderDetailModal",

  props: {
    value: {
      type: Boolean,
      required: true,
    },
    orderMenu: Object,
    date:String
  },

  computed: {
    openMo: {
      get() {
        return this.value;
      },
      set(value) {
        this.$emit("input", value);
      },
    },
  },

  method: {
    goOrderCombi() {

  }
  }
}
</script>

<style>
.c_btn {
  min-width: 0px !important;
}
.bill {
  
  width: 90%;
  border: 1px solid;
  margin: auto;
  margin-bottom: 10px;
  
}
.menuCheck {
  border-bottom: 1px solid;
}
.orderBox {
  width: 100%;
  margin: auto;
  background-color: white;
}
.cntPrice {
  display: flex;
  flex-direction: row;
  justify-content: space-around
}
.content {
  width: 90%;
}
</style>
