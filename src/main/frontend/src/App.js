import React, {useEffect, useState} from 'react';
// import { Route} from "react-router-dom";
import axios from 'axios';
import Header from './components/Header';
// import Item from './components/Item';
// import Main from './components/Main';
// import Product from './components/Product';

function App(props){
    let [lists, setLists] = useState([]);
    let [mode, setMode] = useState(0);
    useEffect(function() {
        let arr = [];

        if(mode === 1){
            axios.get('http://localhost:8080/items')
                .then(function(response) {
                    var data = response.data;
                    for(let i = 0; i < data.length; i++) {
                        arr.push(
                            <tr key={i}>
                                id: {data[i].id}
                                name: {data[i].name} <br></br>
                                price: {data[i].price} <br></br>
                                stockQuantity: {data[i].stockQuantity} <br></br>
                            </tr>);
                    }
                    setLists(arr);
                })
                .catch(error => console.log(error))
        }else{
            setLists(null);
        }

    }, [mode]);
    return (
      <div>
          <h1>hello</h1>
          <table>{lists}</table>
          <Header></Header>

          <a type="button" href={"http://localhost:3000/"} onClick={function(event) {
              event.preventDefault();
              if(mode === 0) {
                  setMode(1);
              }else{
                  setMode(0);
              }
          }
          }>button</a>

      </div>
  );
}

export default App;
