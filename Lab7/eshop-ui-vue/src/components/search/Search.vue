<template>
  <div class="search-container">
    <ProductBlock v-bind:data="search"/>
  </div>
</template>

<script>
import ProductBlock from "@/components/product-block/ProductBlock";
import ProductService from "@/services/product.service";
import {getParameterByName} from "@/utils/url-utils";

export default {
  name: "Search",
  components: {ProductBlock},
  data() {
    return {
      search: {
        products: []
      }
    }
  },
  created() {
    this.retrieveSearch();
  },
  methods: {
    retrieveSearch() {
      const name = getParameterByName('name');
      let page = getParameterByName('page');
      if (!page) page = 0;
      if (name) {
        ProductService.search(name, page, 20)
            .then(response => {
              this.search = {
                products: response.data
              };
            })
            .catch(e => {
              console.log(e);
            });
      }
    }
  }
}
</script>

<style scoped src="./Search.css"/>
