import './root.component.css';
import {constants} from "../../constants";
import {v4 as uuid_v4} from "uuid";
import UserService from "../../services/user.service";
import React, {Component} from "react";
import Header from "../header/header.component";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Offerings from "../offerings/offerings.component";
import Categories from "../categories/categories.component";
import Footer from "../footer/footer.component";
import {GlobalContext} from "../../context-provider";

export default class Root extends Component {

    static contextType = GlobalContext;

    constructor(props) {
        super(props);
        this.loginAnonymous = this.loginAnonymous.bind(this);
        this.login = this.login.bind(this);
        this.logout = this.logout.bind(this);
    }

    componentDidMount() {
        if (!this.context.user || !this.context.user.id) {
            this.loginAnonymous();
        } else {
            console.log('retrieved from cache user: ' + JSON.stringify(this.context.user));
        }
    }

    loginAnonymous() {
        const anonymousUser = constants.DEFAULT_USER;
        anonymousUser.username = 'Anonymous User';
        anonymousUser.email = uuid_v4();
        anonymousUser.password = uuid_v4();
        UserService.create(anonymousUser)
            .then(response => {
                console.log('loginAnonymous: ' + JSON.stringify(response.data));
                this.context.setUser(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    login(email, password) {
        UserService.findByEmailAndPassword(email, password)
            .then(response => {
                console.log('login: ' + response.data);
                this.context.setUser(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    logout() {
        console.log('logout');
        this.context.setUser(constants.DEFAULT_USER);
    }

    render() {
        return <div className="body-wrapper">
            <Header/>
            <main>
                <div className="content-container">
                    <Router>
                        <Switch>
                            <Route exact path="/">
                                <Offerings/>
                            </Route>
                            <Route path="/categories">
                                <Categories/>
                            </Route>
                        </Switch>
                    </Router>
                </div>
            </main>
            <Footer/>
        </div>
    }
}
