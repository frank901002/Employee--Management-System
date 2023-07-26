<!-- eslint-disable max-len -->
<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="#">Employee Management System</a>
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
      <th>Employee Name</th>
      <th>Employee Email</th>
      <th>Employee Mobile</th>
      <th>Action</th>
    </thead>
    <tbody>
      <tr v-for="employee in employees" :key="employee.id">
        <td>{{ employee.id }}</td>
        <td>{{ employee.name }}</td>
        <td>{{ employee.email }}</td>
        <td>{{ employee.mobile }}</td>
        <td>
          <button class="btn btn-warning" @click="save(employee)">Edit</button>
          <span class="space"></span>
          <button class="btn btn-danger" @click="removeEmployee(employee)">
            Delete
          </button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
// import EmployeeService from '@/service/EmployeeService';
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
export default {
  name: "EmployeesA",
  // add() {
  //   this.$router.push({
  //     name: 'AddEmployee',
  //   });
  // },
  setup() {
    const router = useRouter();
    const employees = ref([]);
    const fetchEmployees = () => {
      axios
        .get("http://localhost:8081/api/getAllEmployee")
        .then((response) => {
          console.log(response.data);
          employees.value = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    };
    onMounted(fetchEmployees);

    const removeEmployee = (employee) => {
      axios
        .delete(`http://localhost:8081/api/remove/${employee.id}`)
        .then((response) => {
          console.log(response.data);
          alert("已刪除");
          // After successful removal, fetch all employees again
          fetchEmployees(); //重新取得資料
        })
        .catch((error) => {
          console.log(error);
        });
    };
    const add = () => {
      router.push({
        name: "AddEmployee",
      });
    };
    const save = (employee) => {
      router.push({
        name: "EditEmployee",
        params: {
          id: employee.id,
          name: employee.name,
          email: employee.email,
          mobile: employee.mobile,
        },
      });
    };
    return {
      employees,
      removeEmployee, // 將響應式數據返回，這樣組件可以正確地使用employees數據
      add,
      save,
    };
  },
  // methods: {
  //   add() {
  //     this.$router.push({
  //       name: "AddEmployee",
  //     });
  //   },
  //   employeeload() {
  //     axios
  //       .get("http://localhost:8081/api/getAllEmployee")
  //       .then(({ data }) => {
  //         console.log(data);
  //         this.result = data;
  //       })
  //       .catch((error) => {
  //         console.log(error);
  //       });
  //   },
  //   remove(employee) {
  //     axios
  //       .delete(`http://localhost:8081/api/remove/${employee.id}`)
  //       .then((response) => {
  //         console.log(response.data);
  //       })
  //       .catch((error) => {
  //         console.log(error);
  //       });
  //     this.setup();
  //   },
  // },
};
</script>

<style>
.space {
  margin-right: 20px; /* Adjust the value as needed */
}
</style>
