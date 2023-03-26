import React from 'react';
import ReactDOM from 'react-dom/client';
// import App from './App';
import App2 from "./App2";
import store from "./reducers/configure";
import {Provider} from "react-redux";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Provider store={store}>
        {/*// <App />*/}
    <App2></App2>
    </Provider>

);

