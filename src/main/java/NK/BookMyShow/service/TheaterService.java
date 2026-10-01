package NK.BookMyShow.service;

import NK.BookMyShow.dto.TheaterRequest;
import NK.BookMyShow.entity.City;
import NK.BookMyShow.entity.Theater;
import NK.BookMyShow.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final TheaterRepository theaterRepository;
    private final CityService cityService;

      public Theater addTheater(TheaterRequest request){
          City city=cityService.getCityById(request.getCityId());
          Theater theater= Theater.builder()
                  .name(request.getName())
                  .address(request.getAddress())
                  .city(city)
                  .build();
          return theaterRepository.save(theater);
      }
      public List<Theater> getAllTheater(){
          return theaterRepository.findAll();
      }
      public Theater getTheaterById(Long id){
          return theaterRepository.findById(id)
                  .orElseThrow(()->new RuntimeException("Theater Not found With id: "+id));
      }
      public List<Theater> getTheaterByCity(Long cityId){
          return theaterRepository.findCityById(cityId);
      }

}
