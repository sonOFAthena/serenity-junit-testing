package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.AlertMessagePage;
import seleniumeasy.pageobjects.DynamicDataPage;
import seleniumeasy.pageobjects.ModeldialogPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {
    @Managed( driver = "chrome", uniqueSession = true)
    WebDriver driver;

    ModeldialogPage modeldialogPage;

    @Test
    public void waitingforAModalDialog(){
        modeldialogPage.open();

        modeldialogPage.saveChangesButton().shouldNotBeVisible();
        modeldialogPage.openModal();
        modeldialogPage.saveChangesButton().shouldBeVisible();
        modeldialogPage.saveChanges();
        modeldialogPage.saveChangesButton().shouldNotBeVisible();

    }

    AlertMessagePage alertMessagePage;

    @Test
    public void waitingForAMessageToClose(){
        alertMessagePage.open();

        alertMessagePage.openSuccessMessage();

        assertThat( alertMessagePage.alertSuccessMessageText())
                .contains("I'm an autocloseable success message.");

        alertMessagePage.waitForMessageToDisappear();
        alertMessagePage.alertSuccessMessage().shouldNotBeVisible();
    }

    DynamicDataPage dynamicDataPage;

    @Test
    public void waitingForElementsToAppear(){
        dynamicDataPage.open();

        dynamicDataPage.getNewUser();

        assertThat(dynamicDataPage.userDescription())
                .contains("First Name")
                .contains("Last Name");
    }

}
