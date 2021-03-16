<template>
  <div class="star-rating">
    <span v-for="n in total" v-bind:key="n" class="fa fa-star"
          v-bind:class="{checked: n < value}"
          v-bind:style="{fontSize: starSize}"></span>
  </div>
</template>

<script>
export default {
  name: "StarRating",
  props: {
    value: {
      type: Number,
      default: 0
    },
    total: {
      type: Number,
      default: 5
    },
    starSize: {
      type: Number,
      default: 20
    }
  }
}
</script>

<style scoped src="./StarRating.css"/>
