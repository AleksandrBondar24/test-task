package bond.MyWay.test.views;

import bond.MyWay.test.data.entity.Click;
import bond.MyWay.test.data.service.ClickService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PageTitle("Test")
@Route("")
@PermitAll
public class MainView extends VerticalLayout {
    private final ClickService service;
    private final TextField input;
    private final Binder<Click> binder;
    private final Grid<Click> grid;
    private final Button button;

    public MainView(ClickService service) {
        this.service = service;
        grid = new Grid<>(Click.class);
        input = new TextField("Результат");
        add(grid);
        button = new Button("Кнопка");
        binder = new Binder<>(Click.class);
        binder.forField(input)
                .withConverter(new StringToLongConverter("Not a number"))
                .bind(Click::getNumber, Click::setNumber);
        click();
        add(input, new HorizontalLayout(button));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private void saveClick() throws ValidationException {
        if (input.getValue().isEmpty()) {
            service.saveClick(new Click());
        } else {
            final Click click = new Click();
            binder.writeBean(click);
            service.saveClick(click);
        }
    }

    private void updateNumber(Click click) {
        click.setNumber(click.getNumber() + 1);
        binder.readBean(click);
    }

    private void updateTest() {
        grid.setItems(service.findAll());
    }

    private void click() {
        button.addClickListener(e -> {
            try {
                saveClick();
                updateNumber(service.getClick());
                updateTest();
            } catch (ValidationException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
