<!-- eslint-disable max-len -->
<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <router-link to="/" class="navbar-brand"
      >Employee Management System</router-link
    >
  </nav>
  <div class="container">
    <h1 class="text-center">Employee List</h1>
  </div>
  <div class="row">
    <div class="col-lg-3">
      <button class="btn btn-primary btn-sm" @click="add()">
        Add Employee
      </button>
    </div>
  </div>
  <br />
  <table class="table table-striped">
    <thead>
      <th>Employee Id</th>
      <th>Employee First name</th>
      <th>Employee Last name</th>
      <th>Employee Email</th>
    </thead>
    <tbody>
      <tr v-for="employee in employees" :key="employee.id">
        <td>{{ employee.id }}</td>
        <td>{{ employee.firstName }}</td>
        <td>{{ employee.lastName }}</td>
        <td>{{ employee.email }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
// import EmployeeService from '@/service/EmployeeService';
import axios from "axios";
import { ref, onMounted } from "vue";

export default {
  name: "EmployeesB",
  //   data() {
  //     return {
  //       employees: [], // Initialize the employees property as an empty array
  //     };
  //   },

  // add() {
  //   this.$router.push({
  //     name: 'AddEmployee',
  //   });
  // },
  setup() {
    const employees = ref([]);
    onMounted(() => {
      axios
        .get("http://localhost:8081/api/employees")
        .then((response) => {
          console.log(response.data);
          employees.value = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    });
    return {
      employees, // 將響應式數據返回，這樣組件可以正確地使用employees數據
    };
  },
  add(employee) {
    this.$router.push({
      name: "AddEmployee",
    });
  },
};
</script>
