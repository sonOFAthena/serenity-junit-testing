package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class MultiSelectListForm  extends SeleniumEasyForm {

    public static final By STATE = By.id("multi-select");

    public List<String> selectedState() {
        return $(STATE).getSelectedValues();
    }

    public void selectStates(String... states) {
        for (String state : states)
            $(STATE).select().byValue(state);
    }
}
