package NK.BookMyShow.service;

import NK.BookMyShow.entity.Movie;
import NK.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

     public  Movie addMovie(Movie movie){
         return movieRepository.save(movie);
     }
     public List<Movie> getAllMovie(){
         return movieRepository.findAll();
     }
     public Movie getMovieById(Long id){
         return movieRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Movie Not Find By This id :"+id));
     }
     public List<Movie>  getMovieByGenre(String genre){
         return movieRepository.findByGenre(genre);
     }
    public List<Movie>  getMovieByLanguage(String language){
         return movieRepository.findByLanguage(language);
    }
    public List<Movie>  getMovieByRating(Double rating){
         return movieRepository.findByRating(rating);
    }
   public  List<Movie>  getMovieByTitleContainingIgnoreCase(String title){
         return movieRepository.findByTitleContainingIgnoreCase(title);
   }
   //update Movie
    //Delete Movie
}
