import React from 'react';
import store from './reducers/configure'
import Header from './components/Header';
import Card from './components/ProductCard'
import { useSelector, useDispatch} from 'react-redux';
import { asyncUpFetch } from "./reducers/listSlice";
import ListSlice from "./reducers/listSlice";
import CounterSlice from "./reducers/CounterSlice";
import Cards from "./components/Cards";
import Page from "./components/Page";

function App2(){
    let dispatch = useDispatch();
    return (

        <div>
            {/*<Card title= num={items[0].price}></Card>*/}
            {/* <Header></Header> */}

            <Page></Page>
            <button onClick={function(e){
                // console.log(items)
                dispatch(asyncUpFetch());
                // dispatch(CounterSlice.actions.up(10));
            }}>reload</button>
        </div>

    );
}

export default App2;

