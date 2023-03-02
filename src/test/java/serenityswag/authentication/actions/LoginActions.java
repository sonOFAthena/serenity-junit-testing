package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        find("[data-test='username']").sendKeys(user.getUsername());
        $("[data-test='password']").sendKeys(user.getPassword());
        find("[data-test='login-button']").click();
    }

}
