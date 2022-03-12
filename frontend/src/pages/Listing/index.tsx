import axios from "axios";
import MovieCard from "components/MovieCard/MovieCard";
import Pagination from "components/Pagination/Pagination";
import { BASE_URL } from "utils/requests";

function Listing() {

    axios.get(`${BASE_URL}/movies?page=1&size=12`)
        .then(response => {
           console.log(response.data) ;
        });

    return (
        <>
            <Pagination/>
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3">
                        <MovieCard/>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Listing;
