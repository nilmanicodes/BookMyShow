package NK.BookMyShow.service;

import NK.BookMyShow.entity.City;
import NK.BookMyShow.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
     public City addCity(City city){
         return cityRepository.save(city);
     }
     public List<City> getAllCity(){
         return cityRepository.findAll();
     }
     public City getCityById(Long id){
         return cityRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("City Not Found: "+ id));
     }
}
