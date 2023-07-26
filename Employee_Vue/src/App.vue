<template>
  <div id="app">
    <!-- <My-navbar></My-navbar>
    <Employee></Employee> -->
    <!-- <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div> -->
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script lang="ts">
// import MyNavbar from "@/components/MyNavbar.vue";
// import Employee from "@/components/Employee.vue";

export default {
  components: {
    // MyNavbar,
    // Employee,
  },
  // setup() {
  //   onMounted(() => {
  //     axios
  //       .get("http://localhost:8084/api/employees")
  //       .then((response) => {
  //         console.log(response);
  //       })
  //       .catch((error) => {
  //         console.log(error);
  //       });
  //   });
  // },
};
</script>
