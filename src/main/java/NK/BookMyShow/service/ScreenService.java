package NK.BookMyShow.service;

import NK.BookMyShow.dto.ScreenRequest;
import NK.BookMyShow.entity.Screen;
import NK.BookMyShow.entity.Theater;
import NK.BookMyShow.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;
     public  Screen addScreen(ScreenRequest request){
         Theater theater=theaterService.getTheaterById(request.getTheaterId());
         Screen screen=Screen.builder()
                         .name(request.getName())
                                 .totalSeats(request.getTotalSeats())
                                         .theater(theater)
                 .build();
         return screenRepository.save(screen);
     }
     public List<Screen> getAllScreen(){
         return screenRepository.findAll();
     }
     public Screen getScreenById(Long id){
         return screenRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Screen Is Not Found By This Id :"+id));
     }
     public List<Screen>  getScreenByTheaterId(Long theaterId){
         return screenRepository.findByTheaterId(theaterId);

}

}

