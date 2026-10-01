package NK.BookMyShow.controller;

import NK.BookMyShow.dto.ShowRequest;
import NK.BookMyShow.entity.Show;
import NK.BookMyShow.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @GetMapping
  private ResponseEntity<List<Show>> getAllShow(    ShowRequest request){
      return ResponseEntity.ok(showService.getAllShow());
  }
  @GetMapping("/{id}")
  private ResponseEntity<Show> getShowById(@PathVariable Long id){
        return ResponseEntity.ok(showService.getShowById(id));
  }
  @GetMapping("/movie/{movieId}")
  private ResponseEntity<List<Show>>  getShowByMovieId(@PathVariable Long movieId){
        return ResponseEntity.ok(showService.getShowByMovieId(movieId));
  }
  @GetMapping("/screen'/{screenId}")
  private ResponseEntity<List<Show>> getShowByScreenId(@PathVariable Long screenId){
        return ResponseEntity.ok(showService.getShowByScreenId(screenId));
  }
  @GetMapping("/movie/{movieId}/date")
  private ResponseEntity<List<Show>>   getShowByMovieAndDate(@PathVariable Long movieId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
  {
      return ResponseEntity.ok(showService.getShowByMovieIdAndShowDate(movieId,date));
  }

}
