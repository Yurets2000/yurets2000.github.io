import React, { Component } from "react";
import {constants} from "./constants";

export const GlobalContext = React.createContext();

export class ContextProvider extends Component {
    setUser = user => {
        localStorage.setItem('user', JSON.stringify(user));
        this.setState({ user: user });
    };

    state = {
        user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : constants.DEFAULT_USER,
        setUser: this.setUser
    };

    render() {
        return (
            <GlobalContext.Provider value={this.state}>
                {this.props.children}
            </GlobalContext.Provider>
        )
    }
}
