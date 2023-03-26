import { createSlice } from "@reduxjs/toolkit";
const CounterSlice = createSlice({
    name:'counter',
    initialState:{value:0},
    reducers:{
        up:function(state, action){
            state.value = state.value + action.payload
        },
        down:function(state, action){
            state.value = state.value - action.payload
        }
    }
});
export default CounterSlice;
export const {up, down} = CounterSlice.actions;