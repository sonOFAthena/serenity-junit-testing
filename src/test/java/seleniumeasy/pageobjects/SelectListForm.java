package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class SelectListForm  extends SeleniumEasyForm{

    private static final By DAY_OF_THE_WEEK = By.id("select-demo");

    public String selectedDay() {
        return $(DAY_OF_THE_WEEK).getSelectedValue();
    }

    public void selectDay(String day) {
        $(DAY_OF_THE_WEEK).select().byValue(day);
    }
}
