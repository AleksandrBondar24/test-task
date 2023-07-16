package bond.MyWay.test.Task.views;

import bond.MyWay.test.Task.data.entity.Click;
import bond.MyWay.test.Task.data.service.ClickService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;

@PageTitle("Test")
@Route("")
public class MainView extends VerticalLayout {

    public MainView(ClickService service) {
        TextField input = new TextField("Результат");
        Button button = new Button("Кнопка");
        button.addClickListener(e -> {
            if (input.getValue().isEmpty()) {
                service.saveNumber(new Click());
            } else {
                final Long num = Long.parseLong(input.getValue());
                service.saveNumber(Click
                        .builder()
                        .number(num)
                        .timestamp(LocalDateTime.now())
                        .build());
            }
        });

        button.addClickListener(e -> input.setValue(String.valueOf(service.getNumber())));
        add(input, new HorizontalLayout(button));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
