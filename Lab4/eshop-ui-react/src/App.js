import './App.css';
import React, {Component} from "react";
import {ContextProvider} from "./context-provider";
import Root from "./components/root/root.component";

class App extends Component {
    render() {
        return <ContextProvider>
            <Root/>
        </ContextProvider>
    }
}

export default App;
