<template>
  <div class="categories">
    <div class="filtering-block">
      <div class="categories-block">
        <h3 class="categories-head">Categories</h3>
        <ul class="product-categories">
          <li v-for="productCategory in sortedProductCategories"
              v-bind:key="productCategory.id"
              v-bind:class="{selectedItem: productCategory.id === selectedProductCategory.id}">
            <a v-bind:href="'./categories?selected=' + productCategory.id">{{productCategory.name}}</a>
          </li>
        </ul>
      </div>
      <div class="filters-block">
        <h3 class="filters-head">Additional Filters</h3>
        <ul class="filters-categories">
          <li>
            <div id="color-category" class="filter-category">
              <h4 class="filter-category-head">Color</h4>
              <ul class="filter-subcategories">
                <li>
                  <input type="checkbox" id="white" name="color" value="White">
                  <label for="white">White</label>
                </li>
                <li>
                  <input type="checkbox" id="black" name="color" value="Black">
                  <label for="black">Black</label>
                </li>
                <li>
                  <input type="checkbox" id="gold" name="color" value="Gold">
                  <label for="gold">Gold</label>
                </li>
                <li>
                  <input type="checkbox" id="red" name="color" value="Red">
                  <label for="red">Red</label>
                </li>
              </ul>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <ProductBlock v-bind:data="selectedProductCategory" v-bind:data-type="'ProductCategory'"/>
  </div>
</template>

<script>
import ProductCategoriesService from '@/services/product-category.service';
import getParameterByName from "@/utils/url-utils";
import ProductBlock from "@/components/product-block/ProductBlock";
import sortArray from "@/utils/list-utils";

export default {
  name: "Categories",
  components: {ProductBlock},
  data() {
    return {
      productCategories: undefined,
      selectedProductCategory: undefined
    }
  },
  created() {
    this.retrieveProductCategories();
    this.retrieveSelectedProductCategory();
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
    retrieveSelectedProductCategory() {
      const id = getParameterByName('selected');
      if (id) {
        ProductCategoriesService.getById(id)
            .then(response => {
              this.selectedProductCategory = response.data;
            })
            .catch(e => {
              console.log(e);
            });
      } else {
        ProductCategoriesService.getDefault()
            .then(response => {
              this.selectedProductCategory = response.data;
            })
            .catch(e => {
              console.log(e);
            });
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

<style src="./Categories.css"/>
