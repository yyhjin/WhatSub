<template>
  <div class="container">
    
  </div>
</template>

<script>
export default {
  name: 'LoginView',

}
</script>

<style>
.container {
  height: 100vh;
  background-image: url('@/assets/subway.jpg');
  background-size : cover;
  background-repeat : no-repeat;
}
.container::before {
  background-image: url('@/assets/subway.jpg');
  background-size : cover;
  background-repeat : no-repeat;
  opacity: 0.3;
}
</style>