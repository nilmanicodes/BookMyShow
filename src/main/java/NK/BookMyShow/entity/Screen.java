package NK.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="screens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;//aud1,aud2;

    @ManyToOne()
    @JoinColumn(name="theater_id")
    private Theater theater;

    private Integer totalSeats;

}
