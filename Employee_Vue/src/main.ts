import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
// import axios from "axios";

import BootstrapVue3 from "bootstrap-vue-3";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue-3/dist/bootstrap-vue-3.css";
// main.js
// import VeeValidate from "vee-validate";
// import zhTW from "vee-validate/dist/locale/zh_TW";
// import VueI18n from "vue-i18n";

createApp(App).use(BootstrapVue3).use(router).mount("#app");
// Vue.use(VueI18n);

// const i18n = new VueI18n({
//   locale: "zhTW",
// });

// Vue.use(VeeValidate, {
//   events: "input|blur",
//   i18n,
//   dictionary: {
//     zhTW,
//   },
// });

// // 記得載入 i18n
// new Vue({
//   i18n,
//   router,
//   render: (h) => h(App),
// }).$mount("#app");
