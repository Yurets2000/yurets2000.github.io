<template>
  <div class="offerings-container" v-if="offerings">
    <ProductBlock v-for="offering in sortedOfferings" v-bind:key="offering.id"
                  v-bind:data="offering" v-bind:data-type="'Offering'"/>
  </div>
</template>

<script>
import ProductBlock from "@/components/product-block/ProductBlock";
import OfferingService from '@/services/offering.service';
import sortArray from "@/utils/list-utils";

export default {
  name: "Offerings",
  components: {ProductBlock},
  data() {
    return {
      offerings: undefined
    }
  },
  created() {
    this.retrieveOfferings();
  },
  methods: {
    retrieveOfferings() {
      OfferingService.getAll()
          .then(response => {
            this.offerings = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
  },
  computed: {
    sortedOfferings() {
      return sortArray(this.offerings, 'name');
    }
  }
}
</script>

<style scoped src="./Offerings.css"/>
