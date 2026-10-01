package NK.BookMyShow.service;

import NK.BookMyShow.dto.ShowRequest;
import NK.BookMyShow.entity.Movie;
import NK.BookMyShow.entity.Screen;
import NK.BookMyShow.entity.Show;
import NK.BookMyShow.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    //addShow
    private Show addShow(ShowRequest request){
        Movie movie=movieService.getMovieById(request.getMovieId());
        Screen screen=screenService.getScreenById(request.getScreenId());
        Show show=Show.builder()
                .movie(movie)
                .screen(screen)
                .showDate(request.getShowDate())
                .startTime(LocalTime.from(request.getStartTime()))
                .endTime(LocalTime.from(request.getEndTime()))
                .ticketPrice(request.getTicketPrice())
                .build();
        return showRepository.save(show);
    }
    public Show getShowById(Long id){
        return showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Show Not Found :"+id));
    }
    public List<Show> getAllShow(){
        return showRepository.findAll();
    }
    public List<Show> getShowByMovieId(Long movieId){
        return showRepository.findByMovieId(movieId);
    }
   public  List<Show> getShowByScreenId(Long screenId){
        return showRepository.findByScreenId(screenId);
    }
   public List<Show> getShowByMovieIdAndShowDate(Long movieId, LocalDate showDate){
           return showRepository.findByMovieIdAndShowDate(movieId,showDate);
   }

}
