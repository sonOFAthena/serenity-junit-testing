package serenityswag.authentication.actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        $("#user-name").sendKeys(user.getUsername());
        $("#password").sendKeys(user.getPassword());
        $("#login-button").click();
    }

}
