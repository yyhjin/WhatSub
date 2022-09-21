<template>
  <div>
    <v-app-bar color="white" elevation="0">
      <router-link :to="{ name: 'home' }">
        <img class="navbar__logo" src="@/assets/logo_nav.png" alt="logo" />
      </router-link>
      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon color="grey darken-1">mdi-cart-outline</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-account-circle-outline</v-icon>
      </v-btn>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  name: "TopNav",
};
</script>

<style>
/* .class {
  margin: 0;
}
a {
  text-decoration: none;
  color: black;
}

.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
  padding: 8px 12px;
} */
.navbar__logo {
  margin-top: 3px;
  height: 25px;
}
.navbar-active {
  color: black !important;
}
</style>
