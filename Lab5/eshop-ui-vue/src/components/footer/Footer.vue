<template>
  <footer>
    <div class="footer-head">
      <div class="contact-us-email">
        <div class="footer-info-block icon-text">
          <div class="icon-container left">
            <img src="@/assets/img/icons/icon-mail.png" alt="Mail Icon"/>
          </div>
          <div class="description-container">
            <h2>Do you have any question?</h2>
            <p>eshop@gmail.com</p>
          </div>
        </div>
      </div>
      <div class="contact-us-phone">
        <div class="footer-info-block icon-text">
          <div class="icon-container">
            <img src="@/assets/img/icons/icon-phone.png" alt="Phone Icon"/>
          </div>
          <div class="description-container">
            <h2>+380972071553</h2>
            <p>Mon-Fri: 9:00-18:00</p>
          </div>
        </div>
      </div>
    </div>
    <div class="footer-body">
      <div class="footer-general-info">
        <div class="footer-info-block">
          <img class="main-logo" src="@/assets/img/logo.png" alt="Main Logo"/>
          <h2>Kiev, Ukraine</h2>
          <p>Phone: +380972071553</p>
          <p>Email: eshop@gmail.com</p>
        </div>
      </div>
      <div class="footer-company-info">
        <div class="footer-info-block">
          <h2>Company Info</h2>
          <ul class="footer-list">
            <li><a href="#">About Us</a></li>
            <li><a href="#">Delivery Information</a></li>
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Contact Us</a></li>
          </ul>
        </div>
      </div>
      <div class="footer-personal-info">
        <div class="footer-info-block">
          <h2>Additional Info</h2>
          <ul class="footer-list">
            <li><a href="#">My Account</a></li>
            <li><a href="#">My Wish List</a></li>
            <li><a href="#">My Orders</a></li>
            <li><a href="#">Newsletter</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-bottom">
      <p class="footer-copyright">
        Copyright © 2021, EShop, All Rights Reserved.
      </p>
    </div>
  </footer>
</template>

<script>
export default {
  name: "Footer"
}
</script>

<style scoped src="./Footer.css"/>
