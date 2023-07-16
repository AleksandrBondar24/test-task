package bond.MyWay.test.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clicks")
@Builder
public class Click {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private Long number = 0L;
    @Column(name = "timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}
