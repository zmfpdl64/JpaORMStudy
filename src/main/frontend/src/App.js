import React, {useEffect, useState} from 'react';
// import axios from 'axios';
import Header from './components/Header';
import Items from './components/Items';
import Navi from './components/NavigationBar';
// import { Provider, useSelector, useDispatch } from 'react-redux';
// import { reloadItems } from './reducers/listSlice';
function App(props){
    let [mode, setMode] = useState(0);
    let [items,setItems] = useState([]);
    useEffect(function () {
        if (mode === 1) {
            setItems(<Items/>);
            return;
        }
        setItems(null);
        document.title = "기본페이지";
    }, [mode])
    // const dispatch = useDispatch();
    // const item = useSelector(function(state) {
    //     if(state.mode === 1){
    //         dispatch(reloadItems())
    //     }else{
    //         dispatch
    //     }
    // })
    return (
      <div>
          <Navi> </Navi>
          <h1>hello</h1>
          {items}
          <Header></Header>
          <a type="button" href="http://localhost:3000/" onClick={function(event) {
              event.preventDefault();
              if(mode === 0) {
                  setMode(1);
              }else{
                  setMode(0);
              }
          }
          }>제품 조회</a>
      </div>
  );
}

export default App;

