import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {createStore} from "redux";
import {Provider} from "react-redux";
import userReducer from "./reducers/userReducer";

const store = createStore(userReducer);

store.subscribe(() => {
    localStorage.setItem('user', JSON.stringify(store.getState().user));
})

export default store;

ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);

reportWebVitals();
