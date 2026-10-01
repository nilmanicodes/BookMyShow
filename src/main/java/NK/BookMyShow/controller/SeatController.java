package NK.BookMyShow.controller;

import NK.BookMyShow.entity.Seat;
import NK.BookMyShow.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor

public class SeatController {

        private final SeatService seatService;

        @GetMapping("/screen/{screenId}")
        public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Long screenId)
        {
            return ResponseEntity.ok(seatService.getSeatsByScreen(screenId));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Seat> getSeatById(@PathVariable Long id)
        {
            return ResponseEntity.ok(seatService.getSeatById(id));
        }

    }
