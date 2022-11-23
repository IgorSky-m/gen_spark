package week_2.day_1.holidays;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private static final String RATING_PG = "PG";

    private String title;
    private String studio;
    private String rating;


    public Movie(String title, String studio, String rating) {
        this.title = title;
        this.studio = studio;
        this.rating = rating;
    }

    public Movie(String title, String studio) {
        this.title = title;
        this.studio = studio;
        this.rating = RATING_PG;
    }

    public Movie[] getPG(Movie[] movies){
        if (movies == null) {
            throw new IllegalArgumentException("array can't be empty");
        }

        List<Movie> movieList = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie == null) {
                throw new IllegalArgumentException("movie can't be empty");
            }

            if (RATING_PG.equals(movie.rating)){
                movieList.add(movie);
            }

        }

        return movieList.toArray(Movie[]::new);
    }

}
