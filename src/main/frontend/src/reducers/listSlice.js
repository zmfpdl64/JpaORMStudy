import {createAsyncThunk, createSlice, current} from "@reduxjs/toolkit";
import Card from "../components/ProductCard";
import axios from 'axios';


const asyncUpFetch = createAsyncThunk(
    'listSlice/getList2',
    async () => {
        const resp = axios.get('http://localhost:8080/items')

        return resp;
    }
)
const asyncgetList = createAsyncThunk(
    'listSlice/getList',
    async() =>{
        return axios.get('http://localhost:8080/items')
    }
)

const ListSlice = createSlice({
    name:'list',
    initialState:{
        items:[]
    },
    reducers:{
        reloadItems:function(state, action){
        }
    },
    extraReducers: (builder)=>{
        builder.addCase(asyncUpFetch.fulfilled, (state, action) => {
            const response = action;
            let itemlist = [];
            // itemlist.push(
            //     <thead key='thead'>
            //     <tr key="0">
            //         <th>id</th>
            //         <th>제품명</th>
            //         <th>가격</th>
            //         <th>재고</th>
            //     </tr>
            //     </thead>
            // )
            let tr = []
            for (let i = 0; i < response.payload.data.length; i++) {
                var data = response.payload.data[i];
                tr.push(
                    <Card title={data.name} price={data.price} stockQuantity={data.stockQuantity}></Card>
                    // <tr key={data.id}>
                    //     <td>{data.id}</td>
                    //     <td>{data.name}</td>
                    //     <td>{data.price}</td>
                    //     <td>{data.stockQuantity}</td>
                    //     {/*<td>*/}
                    //     {/*    <a type="button" href={"http://localhost:8080/items/remove/"+datas[i].id}*/}
                    //     {/*       onClick={function(e) {*/}
                    //     {/*           e.preventDefault();*/}
                    //     {/*       }}*/}
                    //     {/*    >삭제하기</a>*/}
                    //     {/*</td>*/}
                )

            }
            // itemlist.push(<tbody key='tbody'>{tr}</tbody>)
            state.items = tr;
            // console.log(state.items);
            document.title = "상품 리스트 조회"
        })
    }
})
export default ListSlice;
export const {reloadItems} = ListSlice.actions;
export { asyncUpFetch }

