package bond.MyWay.test.Task.data.service;

import bond.MyWay.test.Task.data.entity.Click;

public interface ClickService {
    void saveNumber(Click click);

    Long getNumber();
}
