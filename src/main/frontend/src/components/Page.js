import Navbar from "./Navbar";
import Cards from "./Cards";


const page = function() {
    return(
        <div>
            <div className="listpage-znc">
                <Navbar></Navbar>
                <Cards></Cards>
            </div>
        </div>
    )
};
export default page;