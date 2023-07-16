package bond.MyWay.test.data.service;

import bond.MyWay.test.data.entity.Click;
import bond.MyWay.test.data.repository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClickServiceImpl implements ClickService {

    private final ClickRepository repository;

    @Override
    public void saveClick(Click number) {
        Click click = repository.save(number);
    }

    public Click getClick() {
        return repository.findFirstByOrderByTimestampDesc();
    }

    @Override
    public List<Click> findAll() {
        return repository.findAll();
    }
}
