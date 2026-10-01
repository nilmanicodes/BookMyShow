package NK.BookMyShow.dto;

import NK.BookMyShow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequest {
    private String seatNumber;
    private String row;
    private String col;
    private SeatType seatType;
    private Long screenId;

}
