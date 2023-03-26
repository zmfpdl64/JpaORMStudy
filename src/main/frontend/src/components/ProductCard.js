import React from "react";
const Card = function (props) {
    return (
        <div className="frame-13-RVA">
        <div className="rectangle-21-n4p">
        </div>
        <div className="component-32-8Pa">
          <div className="auto-group-9smh-fPW">
            <div className="rectangle-25-oEp">
            </div>
            <div className="title-8nt">제목: {props.title}</div>
          </div>
          <div className="createdby-4gY">가격: {props.price}</div>
          <div className="createdat-BmA">수량: {props.stockQuantity}</div>
        </div>
      </div>
    )
}
export default Card;