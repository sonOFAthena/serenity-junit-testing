package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@DefaultUrl("http://demo.seleniumeasy.com/dynamic-data-loading-demo.html")
public class DynamicDataPage extends SeleniumEasyForm {

    private static final By USER_DETAILS_PANEL = By.id("loading");

    public String userDescription() {
        System.out.println($(USER_DETAILS_PANEL).getText());
        return $(USER_DETAILS_PANEL).getText();
    }

    public void getNewUser() {
        $("#save").click();

        withTimeoutOf(Duration.ofSeconds(30))
                .waitFor(
                        invisibilityOfElementWithText(USER_DETAILS_PANEL, "loading...")
                );
    }
}
