package serenityswag.authentication;

import net.serenitybdd.core.Serenity;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenLogginOn extends UIInteractionSteps {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void usersCanLogOnViaTheHomePage(){
        login.as(STANDARD_USER);

        Serenity.recordReportData()
                .withTitle("User credentials")
                .andContents("User: " + STANDARD_USER);

        //Shoud see product catalog
        Serenity.reportThat("The inventory page should be displayed with the correct title",
            () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
        );

    }
}
