<!-- eslint-disable max-len -->
<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- <a class="navbar-brand" href="">Employee Management System</a> -->
    <router-link to="/" class="navbar-brand"
      >Employee Management System</router-link
    >
  </nav>
  <br />
  <br />
  <div class="container">
    <div class="row">
      <div
        class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card"
      >
        <h1 class="text-center">Create New Employee</h1>
        <div class="card-body">
          <form @submit.prevent="save">
            <div class="form-group">
              <label>Employee Name</label>
              <input
                type="text"
                v-model="employees.name"
                placeholder="Enter Employee Name"
                class="form-control"
                :v-validate="'required'"
              />
            </div>

            <div class="form-group">
              <label>Email</label>
              <input
                type="text"
                v-model="employees.email"
                placeholder="Enter Student Email"
                class="form-control"
                v-validate="required | email"
              />
            </div>
            <div class="form-group">
              <label> Employee Mobile Number</label>
              <input
                type="text"
                v-model="employees.mobile"
                placeholder="Enter Employee Mobile Number"
                class="form-control"
                v-validate="required"
              />
            </div>
            <div class="box-footer">
              <button class="btn btn-primary" type="submit">Submit</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script set>
// import EmployeeService from '@/service/EmployeeService';
import axios from "axios";

export default {
  name: "EmployeesA",
  data() {
    return {
      employees: {
        id: "",
        name: "",
        email: "",
        mobile: "",
      },
    };
  },
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
  // setup() {
  //   const employees = ref([]);
  //   onMounted(() => {
  //     axios
  //       .get("http://localhost:8081/api/getAllEmployee")
  //       .then((response) => {
  //         console.log(response.data);
  //         employees.value = response.data;
  //       })
  //       .catch((error) => {
  //         console.log(error);
  //       });
  //   });
  //   return {
  //     employees, // 將響應式數據返回，這樣組件可以正確地使用employees數據
  //   };
  // },
  // add() {
  //   this.$router.push({
  //     name: "AddEmployee",
  //   });
  // },

  methods: {
    save() {
      if (this.employees.id == "") {
        this.saveData();
      } else {
        this.updateData();
      }
    },
    saveData() {
      if (this.employees.name === "") {
        this.employees.name = " ";
      }
      axios
        .post("http://localhost:8081/api/save", this.employees)
        .then((response) => {
          console.log(response);
          this.employees.id = "";
          this.employees.name = "";
          this.employees.email = "";
          this.employees.mobile = "";
        });
      this.$router.push({
        name: "Employee",
      });
    },
  },
};
</script>
