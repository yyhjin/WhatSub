<template>
  <div>
    <div class="store">
      서브웨이 역삼점
    </div>
    <div class="orderCheck">
      주문내역
      <div class="menuCheck">

      </div>
      <div class="otherCheck">

      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  name: "OrderDetail",

  computed: {
    ...mapGetters(['selectedMenu', 'selectedBread', 'selectedCheese', 
    'selectedSauce', 'selectedVege', 'selectedMoreMeat', 'selectedMore', 'selectedStore'])
  }
};
</script>

<style>
.store{
  height: 50px;
  width: 100%;
  background-color: #F5F5F5;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2px;
}
.orderCheck{
  width: 100%;
  background-color: #F5F5F5;
}
</style>
