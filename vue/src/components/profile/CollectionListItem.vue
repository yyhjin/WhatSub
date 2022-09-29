<template>
  <div>
    <v-card align="center" height="120" width="100" elevation="0">
      <div class="pa-1">
        <v-avatar color="grey lighten-1" size="60" tile><img src="" alt="rank image" /></v-avatar>
      </div>
      <div>
        <h5>
          {{ collectionInfoItem.menu }}
        </h5>
        <h5>{{ collectionInfoItem.date }}&nbsp;&nbsp;{{ collectionInfoItem.rank }}위</h5>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "CollectionListItem",
  props: {
    collectionInfoItem: Object,
  },
};
</script>

<style>
.collec_card {
  margin-left: 15px;
  margin-top: 10px;
  margin-bottom: 20px;
}
.collec_card:last-child {
  margin-right: 15px;
}
</style>
