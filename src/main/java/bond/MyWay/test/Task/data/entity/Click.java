package bond.MyWay.test.Task.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "numbers")
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
