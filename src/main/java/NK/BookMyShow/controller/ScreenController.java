package NK.BookMyShow.controller;

import NK.BookMyShow.dto.ScreenRequest;
import NK.BookMyShow.entity.Screen;
import NK.BookMyShow.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @PostMapping("/request")
    public ResponseEntity<Screen> addScreen(@RequestBody ScreenRequest request) {
        return ResponseEntity.ok(screenService.addScreen(request));
    }
@GetMapping
private ResponseEntity<List<Screen>> getAllScreen(){
    return ResponseEntity.ok(screenService.getAllScreen());
}
@GetMapping("/{id}")
private ResponseEntity<Screen> getScreenById(@PathVariable Long id){
    return ResponseEntity.ok(screenService.getScreenById(id));
}
@GetMapping("/theater/{theaterId}")
private ResponseEntity<List<Screen>> getScreenByTheaterId(@PathVariable Long theaterId){
    return ResponseEntity.ok(screenService.getScreenByTheaterId(theaterId));
}


}
