package NK.BookMyShow.controller;

import NK.BookMyShow.dto.TheaterRequest;
import NK.BookMyShow.entity.Theater;
import NK.BookMyShow.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping("/request")
    private ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest request){
        return ResponseEntity.ok(theaterService.addTheater(request));
    }
    @GetMapping
    private ResponseEntity<List<Theater>> getAllTheater(){
        return ResponseEntity.ok(theaterService.getAllTheater());
    }
    @GetMapping("/{id}")
    private ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }
    @GetMapping("/city/{cityId}")
    private ResponseEntity<List<Theater>> getTheaterByCityId(@PathVariable Long cityId){
        return ResponseEntity.ok(theaterService.getTheaterByCity(cityId));
    }

}
