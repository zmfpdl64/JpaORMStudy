import CardLine from './CardLine';
import { useSelector } from 'react-redux'
const Cards = function () {
    const items = useSelector(function(state){
        return state.listSlice.items;
    })

    return (
        <div className="auto-group-qofz-Y7J">
        <CardLine></CardLine>
        {/* <CardLine></CardLine> */}
        </div>
    )
};
export default Cards;