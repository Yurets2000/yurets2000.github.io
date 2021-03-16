import Vue from 'vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';
import VueMaterial from 'vue-material';
import App from './App.vue';
import 'vue-material/dist/vue-material.min.css';
import {constants} from "./constants";
import Offerings from "@/components/offerings/Offerings";
import Categories from "@/components/categories/Categories";

Vue.config.productionTip = false

Vue.use(VueMaterial);
Vue.use(Vuex);
Vue.use(VueRouter);

const store = new Vuex.Store({
    state: {
        user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : constants.DEFAULT_USER
    },
    mutations: {
        updateUser (state, userValue) {
            localStorage.setItem('user', JSON.stringify(userValue));
            state.user = userValue;
        }
    }
});

const routes = [
    { path: '/', component: Offerings },
    { path: '/categories', component: Categories }
];

const router = new VueRouter({
    mode: 'history',
    routes: routes
});

new Vue({
    render: h => h(App),
    store: store,
    router: router
}).$mount('#app')
