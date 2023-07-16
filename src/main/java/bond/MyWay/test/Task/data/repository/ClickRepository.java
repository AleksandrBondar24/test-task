package bond.MyWay.test.Task.data.repository;

import bond.MyWay.test.Task.data.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepository extends JpaRepository<Click, Long> {
    Click findFirstByOrderByTimestampDesc();
}
