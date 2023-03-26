import { configureStore } from "@reduxjs/toolkit";
import ListSlice from "./listSlice";
import CounterSlice from "./CounterSlice";

const store = configureStore({
    reducer:{
        listSlice: ListSlice.reducer,
        counterSlice: CounterSlice.reducer
    }
})
export default store;
