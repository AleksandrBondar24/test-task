package bond.MyWay.test.Task.data.service;

import bond.MyWay.test.Task.data.entity.Click;
import bond.MyWay.test.Task.data.repository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClickServiceImpl implements ClickService {

    private final ClickRepository repository;

    @Override
    public void saveNumber(Click number) {
        Click click = repository.save(number);
    }

    @Override
    public Long getNumber() {
        return repository.findFirstByOrderByTimestampDesc()
                .getNumber() + 1;
    }
}
