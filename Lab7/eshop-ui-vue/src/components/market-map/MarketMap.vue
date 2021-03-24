<template>
  <div class="markets-container">
    <h1>🗺️ Find Us On Map 🗺️</h1>
      <google-map
          class="google-map"
          v-bind:center="coordinates"
          v-bind:zoom="10"
          ref="mapRef">
        <google-map-marker
            v-for="market in markets"
            v-bind:key="market.id"
            v-bind:position="{lat: market.latitude, lng: market.longitude}"
            v-bind:clickable="true"
            v-bind:draggable="false"
            class="google-map-marker"/>
      </google-map>
  </div>
</template>

<script>
import MarketService from "@/services/market.service";

export default {
  name: "MarketMap",
  data() {
    return {
      markets: undefined,
      coordinates: {
        lat: 50.45,
        lng: 30.52
      }
    }
  },
  created() {
    this.retrieveMarkets();
  },
  methods: {
    retrieveCoordinates() {
      this.$getLocation({})
          .then(coordinates => {
            this.coordinates = coordinates;
          })
          .catch(e => {
            console.log(e);
          });
    },
    retrieveMarkets() {
      MarketService.getAll()
          .then(response => {
            this.markets = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
  }
}
</script>

<style scoped src="./MarketMap.css"/>
