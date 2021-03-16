<template>
  <div id="app">
    <Header/>
    <main>
      <div class="content-container">
        <router-view/>
      </div>
    </main>
    <Footer/>
  </div>
</template>

<script>
import Footer from "@/components/footer/Footer";
import Header from "@/components/header/Header";
import UserService from "@/services/user.service";
import {v4 as uuid_v4} from "uuid";
import {constants} from "./constants";

export default {
  name: 'App',
  components: {Header, Footer},
  created() {
    const user = this.$store.state.user;
    if (!user || !user.id) {
      this.loginAnonymous();
    } else {
      console.log('retrieved from cache user: ' + JSON.stringify(user));
    }
  },
  methods: {
    loginAnonymous() {
      const anonymousUser = constants.DEFAULT_USER;
      anonymousUser.username = 'Anonymous User';
      anonymousUser.email = uuid_v4();
      anonymousUser.password = uuid_v4();
      UserService.create(anonymousUser)
          .then(response => {
            console.log('loginAnonymous: ' + JSON.stringify(response.data));
            this.$store.commit('updateUser', response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    login(email, password) {
      UserService.findByEmailAndPassword(email, password)
          .then(response => {
            console.log('login: ' + response.data);
            this.$store.commit('updateUser', response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    logout() {
      console.log('logout');
      this.$store.commit('updateUser', constants.DEFAULT_USER);
    }
  }
}
</script>

<style>
</style>
