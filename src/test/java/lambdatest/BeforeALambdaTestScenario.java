package lambdatest;

import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.MutableCapabilities;

public class BeforeALambdaTestScenario implements BeforeAWebdriverScenario {

    @Override
    public MutableCapabilities apply(EnvironmentVariables environmentVariables,
                                     SupportedWebDriver supportedWebDriver,
                                     TestOutcome testOutcome,
                                     MutableCapabilities mutableCapabilities) {
        mutableCapabilities.setCapability("name", testOutcome.getCompleteName());
        return mutableCapabilities;
    }
}
