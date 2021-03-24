import Vue from 'vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';
import VueMaterial from 'vue-material';
import App from './App.vue';
import 'vue-material/dist/vue-material.min.css';
import {constants} from "./constants";
import Offerings from "@/components/offerings/Offerings";
import Categories from "@/components/categories/Categories";
import MarketMap from "@/components/market-map/MarketMap";
import VueGeolocation from 'vue-browser-geolocation';
import * as VueGoogleMaps from 'vue2-google-maps';
import Search from "@/components/search/Search";

Vue.config.productionTip = false

Vue.use(VueMaterial);
Vue.use(Vuex);
Vue.use(VueRouter);
Vue.use(VueGeolocation);
Vue.use(VueGoogleMaps, {
    load: {
        key: 'AIzaSyCW2GRy2xASNOjT5U4vvmDM76J1a95hhkk'
    },
    installComponents: false
});
Vue.component('google-map', VueGoogleMaps.Map);
Vue.component('google-map-marker', VueGoogleMaps.Marker);

const store = new Vuex.Store({
    state: {
        user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : constants.DEFAULT_USER
    },
    mutations: {
        updateUser(state, userValue) {
            localStorage.setItem('user', JSON.stringify(userValue));
            state.user = userValue;
        }
    }
});

const routes = [
    {path: '/', component: Offerings},
    {path: '/categories', component: Categories},
    {path: '/map', component: MarketMap},
    {path: '/search', component: Search}
];

const router = new VueRouter({
    mode: 'history',
    routes: routes
});

new Vue({
    render: h => h(App),
    store: store,
    router: router
}).$mount('#app');
