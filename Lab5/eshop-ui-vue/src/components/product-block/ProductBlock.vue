<template>
  <div v-if="data" class="product-block">
    <div v-if="dataType === 'Offering'">
      <h1 class="product-block-header">{{ data.name }}</h1>
      <ul v-if="productCategories" class="product-categories">
        <li v-for="productCategory in sortedProductCategories" v-bind:key="productCategory.id">
          <md-button class="product-categories-item"
                     v-on:click="onProductCategoryItemClick(productCategory.id)"
                     v-bind:style="{backgroundColor: filteringCategories.findIndex(categoryId => categoryId === productCategory.id) >= 0 ? 'gray' : 'initial'}">
            {{ productCategory.name }}
          </md-button>
        </li>
      </ul>
    </div>
    <div class="productItems"
         v-bind:class="{mainItems: dataType === 'Offering', filteredItems: dataType === 'ProductCategory'}">
      <ProductItem v-for="product in products" v-bind:key="product.id" v-bind:product="product"/>
    </div>
  </div>
</template>

<script>
import ProductCategoriesService from "@/services/product-category.service";
import ProductItem from "@/components/product-item/ProductItem";
import sortArray from "@/utils/list-utils";

export default {
  name: "ProductBlock",
  props: ["data", "dataType"],
  components: {
    ProductItem
  },
  data() {
    return {
      productCategories: [],
      filteringCategories: []
    }
  },
  created() {
    this.retrieveProductCategories();
  },
  methods: {
    retrieveProductCategories() {
      ProductCategoriesService.getAll()
          .then(response => {
            this.productCategories = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
    onProductCategoryItemClick(productCategoryId) {
      console.log(this.$store.state.count);
      const index = this.filteringCategories.findIndex(categoryId => categoryId === productCategoryId);
      if (index >= 0) {
        this.filteringCategories.splice(index, 1);
      } else {
        this.filteringCategories.push(productCategoryId);
      }
    }
  },
  computed: {
    sortedProductCategories() {
      return sortArray(this.productCategories, 'name');
    },
    products() {
      if (this.filteringCategories && this.filteringCategories.length > 0) {
        return this.data.products.filter(product => this.filteringCategories.indexOf(product.categoryId) !== -1);
      } else {
        return this.data.products;
      }
    }
  }
}
</script>

<style scoped src="./ProductBlock.css"/>
