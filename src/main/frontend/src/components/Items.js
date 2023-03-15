import React, {useEffect, useState} from "react";
import axios from "axios";

const Items = (props) => {
    let [items, setItems] = useState([]);
    useEffect(function () {
        axios.get("http://localhost:8080/items")
                .then(response => {
                    let itemlist = [];
                    itemlist.push(
                        <thead key='thead'>
                        <tr key="0">
                            <th>id</th>
                            <th>제품명</th>
                            <th>가격</th>
                            <th>재고</th>
                        </tr>
                        </thead>
                    )
                    let tr = []
                    for (let i = 0; i < response.data.length; i++) {
                        var data = response.data[i];
                        tr.push(
                            <tr key={data.id}>
                                <td>{data.id}</td>
                                <td>{data.name}</td>
                                <td>{data.price}</td>
                                <td>{data.stockQuantity}</td>
                                {/*<td>*/}
                                {/*    <a type="button" href={"http://localhost:8080/items/remove/"+datas[i].id}*/}
                                {/*       onClick={function(e) {*/}
                                {/*           e.preventDefault();*/}
                                {/*       }}*/}
                                {/*    >삭제하기</a>*/}
                                {/*</td>*/}
                            </tr>
                        )

                    }
                    itemlist.push(<tbody key='tbody'>{tr}</tbody>)
                    setItems(itemlist);
                    document.title = "상품 리스트 조회"
                })
                .catch(function() {
                    alert("현재 상품이 존재 하지 않습니다.")
                    console.log("현재 상품이 존재 하지 않습니다.")
                })
    }, [items]) //
    return (
        <table>
            {items}
        </table>
    )
}



export default Items;