package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.time.Duration;

@DefaultUrl("http://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html")
public class AlertMessagePage extends SeleniumEasyForm {

    private static final By ALERT_SUCCESS_MESSAGE = By.cssSelector(".alert-autocloseable-success");

    public void openSuccessMessage() {
        $("#autoclosable-btn-success").click();
    }

    public String alertSuccessMessageText() {
        return $(ALERT_SUCCESS_MESSAGE).getText();
    }

    public void waitForMessageToDisappear() {
        withTimeoutOf(Duration.ofSeconds(10)).waitForElementsToDisappear(ALERT_SUCCESS_MESSAGE);
//        waitForRenderedElementsToDisappear(ALERT_SUCCESS_MESSAGE);
    }

    public WebElementState alertSuccessMessage() {
        return $(ALERT_SUCCESS_MESSAGE);
    }
}
