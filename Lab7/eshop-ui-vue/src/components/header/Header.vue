<template>
  <header>
    <div class="header-container">
      <div class="header-body">
        <div class="logo-container">
          <a href="./">
            <img class="main-logo" src="@/assets/img/logo.png" alt="Main Logo"/>
          </a>
        </div>
        <div class="market-nav-container">
          <div class="market-nav">
            <div class="searchbar-container">
              <div class="searchbar">
                <input type="text" class="searchbar-text" placeholder="Search" v-model="searchbarText">
                <button type="submit" class="searchbar-button" v-on:click="search">
                  <i class="fa fa-search"></i>
                </button>
              </div>
            </div>
            <ul class="market-nav-link-list">
              <li>
                <a href="#">My Account</a>
              </li>
              <li>
                <a href="#">Wish List</a>
              </li>
              <li>
                <a href="#">Shopping Cart</a>
              </li>
              <li>
                <a href="#">Checkout</a>
              </li>
            </ul>
          </div>
        </div>
        <div class="personal-nav-container">
          <div class="personal-nav">
            <a href="./map" class="map"><i class="fa fa-globe"></i></a>
            <a href="#" class="my-account"><i class="fa fa-user"></i></a>
            <div id="cart-block">
              <div id="cart-heading">
                <i id="cart-count"><span id="total-count">{{ getTotalCount() }}</span></i>
                <a href="#" class="shopping-cart"><i class="fa fa-shopping-cart"></i></a>
                <p><span id="total-price">${{ getTotalPrice() }}</span></p>
              </div>
              <div id="cart-content">
                <div id="cart-content-ajax">
                  <div class="empty">Your shopping cart is empty!</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="header-menu-container">
        <div class="menu">
          <div class="menu-head">
            <p>Navigation</p>
            <md-button class="md-icon-button" v-on:click="openCloseCategories">
              <i class="fa fa-bars"></i>
            </md-button>
          </div>
          <ul class="product-categories" v-if="productCategories" v-bind:class="{hidden: !isCategoriesOpen}">
            <li v-for="productCategory in sortedProductCategories" v-bind:key="productCategory.id">
              <a v-bind:href="'./categories?selected=' + productCategory.id">{{ productCategory.name }}</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import {sortArray} from "@/utils/list-utils";
import ProductCategoriesService from "@/services/product-category.service";

export default {
  name: "Header",
  data() {
    return {
      isCategoriesOpen: false,
      productCategories: undefined,
      searchbarText: undefined
    }
  },
  created() {
    this.retrieveProductCategories();
  },
  methods: {
    openCloseCategories() {
      this.isCategoriesOpen = !this.isCategoriesOpen;
    },
    getTotalPrice() {
      const user = this.$store.state.user;
      if (user.cart.length > 0) {
        return user.cart
            .map(product => product.price)
            .reduce((a, b) => a + b);
      } else {
        return 0;
      }
    },
    getTotalCount() {
      const user = this.$store.state.user;
      return user.cart.length;
    },
    retrieveProductCategories() {
      ProductCategoriesService.getAll()
          .then(response => {
            this.productCategories = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
    search() {
      if (this.searchbarText) {
        window.location = `./search?name=${this.searchbarText}&page=0`;
      }
    }
  },
  computed: {
    sortedProductCategories() {
      return sortArray(this.productCategories, 'name');
    }
  }
}
</script>

<style scoped src="./Header.css"/>
