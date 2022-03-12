import axios from "axios";
import MovieCard from "components/MovieCard/MovieCard";
import Pagination from "components/Pagination/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?page=1&size=12`)
        .then(response => {
            const data = response.data as MoviePage;
            setPageNumber(data.number);
           console.log(response.data) ;
        });
    }, []);

    return (
        <>
            <p>{pageNumber}</p>
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
