<template>
  <div class="categories">
    <div class="filtering-block">
      <div class="categories-block">
        <h3 class="categories-head">Categories</h3>
        <ul class="product-categories">
          <li v-for="productCategory in sortedProductCategories"
              v-bind:key="productCategory.id"
              v-bind:class="{selectedItem: selectedProductCategory && productCategory.id === selectedProductCategory.id}">
            <a v-bind:href="'./categories?selected=' + productCategory.id">{{productCategory.name}}</a>
          </li>
        </ul>
      </div>
      <div class="filters-block" v-if="selectedProductCategory && selectedProductCategory.characteristicGroups">
        <h3 class="filters-head">Additional Filters</h3>
        <ul class="filters-categories">
          <li v-for="characteristicGroup in selectedProductCategory.characteristicGroups"
              v-bind:key="characteristicGroup.id">
            <div id="color-category" class="filter-category">
              <h4 class="filter-category-head">{{characteristicGroup.name}}</h4>
              <ul class="filter-subcategories">
                <li v-for="characteristic in characteristicGroup.characteristics"
                  v-bind:key="characteristic.id">
                  <input type="checkbox" v-bind:value="characteristic" v-model="selectedCharacteristics">
                  <label>{{characteristic.value}}</label>
                </li>
              </ul>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <ProductBlock v-bind:data="selectedProductCategory"
                  v-bind:filteringCharacteristics="selectedCharacteristics"
                  v-bind:key="selectedCharacteristicsKey"
                  v-bind:data-type="'ProductCategory'"/>
  </div>
</template>

<script>
import ProductCategoriesService from '@/services/product-category.service';
import {getParameterByName} from "@/utils/url-utils";
import ProductBlock from "@/components/product-block/ProductBlock";
import {sortArray} from "@/utils/list-utils";

export default {
  name: "Categories",
  components: {ProductBlock},
  data() {
    return {
      productCategories: undefined,
      selectedProductCategory: undefined,
      selectedCharacteristics: []
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
    },
    selectedCharacteristicsKey() {
      let res = '';
      if (this.selectedCharacteristics && this.selectedCharacteristics.length > 0) {
        res = this.selectedCharacteristics[0];
        this.selectedCharacteristics.forEach(c => {
          res = res + '|' + c.id;
        });
      }
      return res;
    }
  }
}
</script>

<style scoped src="./Categories.css"/>
