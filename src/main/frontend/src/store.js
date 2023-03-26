import {configureStore} from '@reduxjs/toolkit';
import listSlice from './reducers/listSlice';

const store = configureStore({
    reducer:{
        listSlice:listSlice.reducer
    }
})
export default store;