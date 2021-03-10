/* eslint-disable jsx-a11y/anchor-is-valid */
import './footer.component.css';
import iconMail from '../../assets/img/icons/icon-mail.png';
import iconPhone from '../../assets/img/icons/icon-phone.png';
import logo from '../../assets/img/logo.png';
import React, {Component} from "react";

export default class Footer extends Component {
    render() {
        return <footer>
            <div className="footer-head">
                <div className="contact-us-email">
                    <div className="footer-info-block icon-text">
                        <div className="icon-container left">
                            <img src={iconMail} alt="Mail Icon"/>
                        </div>
                        <div className="description-container">
                            <h2>Do you have any question?</h2>
                            <p>eshop@gmail.com</p>
                        </div>
                    </div>
                </div>
                <div className="contact-us-phone">
                    <div className="footer-info-block icon-text">
                        <div className="icon-container">
                            <img src={iconPhone} alt="Phone Icon"/>
                        </div>
                        <div className="description-container">
                            <h2>+380972071553</h2>
                            <p>Mon-Fri: 9:00-18:00</p>
                        </div>
                    </div>
                </div>
            </div>
            <div className="footer-body">
                <div className="footer-general-info">
                    <div className="footer-info-block">
                        <img className="main-logo" src={logo} alt="Main Logo"/>
                        <h2>Kiev, Ukraine</h2>
                        <p>Phone: +380972071553</p>
                        <p>Email: eshop@gmail.com</p>
                    </div>
                </div>
                <div className="footer-company-info">
                    <div className="footer-info-block">
                        <h2>Company Info</h2>
                        <ul className="footer-list">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Delivery Information</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Contact Us</a></li>
                        </ul>
                    </div>
                </div>
                <div className="footer-personal-info">
                    <div className="footer-info-block">
                        <h2>Additional Info</h2>
                        <ul className="footer-list">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">My Wish List</a></li>
                            <li><a href="#">My Orders</a></li>
                            <li><a href="#">Newsletter</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="footer-bottom">
                <p className="footer-copyright">
                    Copyright © 2021, EShop, All Rights Reserved.
                </p>
            </div>
        </footer>
    }
}
