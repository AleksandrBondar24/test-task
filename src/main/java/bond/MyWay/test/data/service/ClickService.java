package bond.MyWay.test.data.service;

import bond.MyWay.test.data.entity.Click;

import java.util.List;

public interface ClickService {
    void saveClick(Click click);

    Click getClick();

    List<Click> findAll();
}
