<template>
  <div class="productItem">
    <div class="product-image-container">
      <img class="product-image" v-bind:src="product.imageUrl" alt="Product Item">
    </div>
    <div class="product-info-description">
      <p class="product-name">{{ product.name }}</p>
      <div class="product-info">
        <div class="product-responses">
          <div class="product-rating">
            <StarRating v-bind:value="retrieveRating(product)" v-bind:total="5" v-bind:star-size="20"/>
          </div>
          <div class="product-comments">
            <a href="#" class="comment">
              <i class="fa fa-comment"></i>
              <span class="comment-value">{{ retrieveCommentsCount(product) }}</span>
            </a>
          </div>
        </div>
        <div class="product-price">
          <span class="price-value">{{ product.price }} $</span>
        </div>
        <div class="product-actions">
          <md-button v-bind:style="{backgroundColor: isInWishlist ? 'salmon' : '#e0e0e0'}" v-on:click="onWishlist">
            <i class="fa fa-heart"/>
          </md-button>
          <md-button v-bind:style="{backgroundColor: isInCart ? 'salmon' : '#e0e0e0'}" v-on:click="onCart">
            <i class="fa fa-shopping-cart"/>
          </md-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from "@/components/start-rating/StarRating";
import UserService from "@/services/user.service";

export default {
  name: "ProductItem",
  components: {StarRating},
  props: ["product"],
  data() {
    return {
      isInWishlist: false,
      isInCart: false
    }
  },
  created() {
    this.isInWishlist = this.$store.state.user.wishlist
        .findIndex(product => product.id === this.product.id) >= 0;
    this.isInCart = this.$store.state.user.cart
        .findIndex(product => product.id === this.product.id) >= 0;
  },
  methods: {
    retrieveRating(product) {
      if (!product.ratingSum || !product.ratingCount) return 0;
      if (product.ratingCount >= 1) {
        return product.ratingSum / product.ratingCount;
      }
      return 0;
    },
    retrieveCommentsCount(product) {
      const comments = product.productComments;
      return comments ? comments.length : 0;
    },
    onWishlist() {
      const user = this.$store.state.user;
      console.log('user: ' + JSON.stringify(user));
      if (user) {
        const index = user.wishlist.findIndex(product => product.id === this.product.id);
        if (index === -1) {
          user.wishlist.push(this.product);
          this.isInWishlist = true;
        } else {
          user.wishlist.splice(index, 1);
          this.isInWishlist = false;
        }
        this.$store.commit('updateUser', user);
        UserService.update(user).then();
      }
    },
    onCart() {
      const user = this.$store.state.user;
      if (user) {
        const index = user.cart.findIndex(product => product.id === this.product.id);
        if (index === -1) {
          user.cart.push(this.product);
          this.isInCart = true;
        } else {
          user.cart.splice(index, 1);
          this.isInCart = false;
        }
        this.$store.commit('updateUser', user);
        UserService.update(user).then();
      }
    }
  }
}
</script>

<style scoped src="./ProductItem.css"/>
