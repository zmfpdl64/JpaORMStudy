import React from "react";
import Card from "./ProductCard";
import { useSelector } from 'react-redux';
const CardLine = function() {
    const items = useSelector((state) => state.listSlice.items);
    const cards = items;
    return (
        <div className="frame-14-Htk">
            {cards}
            {/*<Card></Card>*/}
            {/*<Card></Card>*/}
            {/*<Card></Card>*/}
            {/*<Card></Card>*/}
        </div>
    )
}

export default CardLine;
