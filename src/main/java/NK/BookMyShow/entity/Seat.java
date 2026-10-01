package NK.BookMyShow.entity;

import NK.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String seatNumber;

    @Column(name="seats_row")
    private String row;

    @Column(name="seats_col")
    private Integer col;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name="screen_id" ,nullable = false)
    private Screen screen;
}
