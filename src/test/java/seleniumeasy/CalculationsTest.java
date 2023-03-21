package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.TwoInputfielForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
//@Concurrent
@UseTestDataFrom("test-data/calculations.csv")
public class CalculationsTest {

    private String a;
    private String b;
    private String total;

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    TwoInputfielForm twoInputfielForm;

    @Qualifier
    public String qualifier(){
        return a + " + " + b + " should be equal to " + total;
    }

    @Test
    public void shouldCalculateTheCorrectTotal() {
        twoInputfielForm.open();

        twoInputfielForm.enterA(a);
        twoInputfielForm.enterB(b);
        twoInputfielForm.getTotal();

        assertThat(twoInputfielForm.displayedTotal()).isEqualTo(total);

    }
}
