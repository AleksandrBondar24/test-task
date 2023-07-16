package bond.MyWay.test.data.repository;

import bond.MyWay.test.data.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepository extends JpaRepository<Click, Long> {
    Click findFirstByOrderByTimestampDesc();
}
