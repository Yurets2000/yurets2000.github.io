<template>
  <div class="offerings-container" v-if="offerings">
    <ProductBlock v-for="offering in sortedOfferings" v-bind:key="offering.id"
                  v-bind:data="offering" v-bind:data-type="'Offering'"/>
    <div class="banner-container" v-if="banner">
      <img class="banner-image" v-if="banner.imageUrl" v-bind:src="banner.imageUrl" alt="Banner"/>
    </div>
  </div>
</template>

<script>
import ProductBlock from "@/components/product-block/ProductBlock";
import OfferingService from '@/services/offering.service';
import BannerService from '@/services/banner.service';
import {sortArray} from "@/utils/list-utils";

let worker;
if (window.Worker) {
  const blobURL = URL.createObjectURL(new Blob(['(',
        function () {
          self.onmessage = () => {
            /*Some hard computations here*/
            let counter = 0;
            setInterval(() => {
              if (counter++ === 1000) {
                counter = 0;
              }
              postMessage(counter);
            }, 1000);
          };
        }.toString(),
        ')()'],
      {type: 'application/javascript'}));
  worker = new Worker(blobURL);
}

export default {
  name: "Offerings",
  components: {ProductBlock},
  data() {
    return {
      banner: undefined,
      offerings: undefined
    }
  },
  created() {
    this.retrieveOfferings();
  },
  mounted() {
    if (worker) {
      worker.onmessage = (e) => {
        let counter = e.data;
        if (counter % 10 === 0) {
          this.loadBanner();
        }
      };
      worker.postMessage('');
    }
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
    loadBanner() {
      BannerService.getRandom()
          .then(response => {
            this.banner = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  computed: {
    sortedOfferings() {
      return sortArray(this.offerings, 'name');
    }
  }
}
</script>


<style scoped src="./Offerings.css"/>
