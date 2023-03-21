package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.FormPage;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */
@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    @Managed( driver = "chrome", uniqueSession = true)
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    SingleInputFieldForm singleInputFieldForm;

    @Test
    public void basicForms() {
//        singleInputFieldForm.open();
        navigate.to(FormPage.SingleInputFieldForm);
        singleInputFieldForm.enterMessage("Hi There");
        singleInputFieldForm.showMessage();

        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi There");
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    TwoInputfielForm twoInputfielForm;

    @Test
    public void basicFormsWithMultipleFields() {
        navigate.to(FormPage.TwoInputfielForm);

        twoInputfielForm.enterA("2");
        twoInputfielForm.enterB("3");
        twoInputfielForm.getTotal();

        assertThat(twoInputfielForm.displayedTotal()).isEqualTo("5");

    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * http://demo.seleniumeasy.com/basic-checkbox-demo.html
     */

    CheckboxForm checkboxForm;

    @Test
    public void singleCheckbox() {
        navigate.to(FormPage.CheckboxForm);
        checkboxForm.setAgeSelected();
        assertThat( checkboxForm.ageText()).isEqualTo("Success - Check box is checked");
    }

    private static final List<String> ALL_THE_OPTIONS = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4" );

    @Test
    public void multipleCheckboxes() {
        checkboxForm.open();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> !checkboxForm.optionIsCheckedFor(option)
        );

        checkboxForm.checkAll();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> checkboxForm.optionIsCheckedFor(option)
        );
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * http://demo.seleniumeasy.com/basic-radiobutton-demo.html
     */
    RedioButtonsForm radioButtonsForm;
    @Test
    public void radioButtons() {
        radioButtonsForm.open();

        radioButtonsForm.selectOption("Male");
        radioButtonsForm.getCheckedValue();

        assertThat( radioButtonsForm.getResult()).isEqualTo("Radio button 'Male' is checked");
    }

    MultipleRadioButtonsForm multipleRadioButtonsForm;
    @Test
    public void multipleRadioButtons() {
        multipleRadioButtonsForm.open();

        multipleRadioButtonsForm.selectGender("Female");
        multipleRadioButtonsForm.selectAgeGroup("15 - 50");
        multipleRadioButtonsForm.getValues();
        assertThat(multipleRadioButtonsForm.getResults())
                .contains("Sex : Female")
                .contains("Age group: 15 - 50");
    }

    /**
     * Dropdown lists
     * http://demo.seleniumeasy.com/basic-select-dropdown-demo.html
     */
    SelectListForm selectListForm;
    @Test
    public void selectList() {
        selectListForm.open();

        assertThat(selectListForm.selectedDay()).isEmpty();

        selectListForm.selectDay("Wednesday");

        assertThat( selectListForm.selectedDay()).isEqualTo("Wednesday");
    }

    /**
     * Multi-Select Dropdown lists
     * http://demo.seleniumeasy.com/basic-select-dropdown-demo.html
     */
    MultiSelectListForm multiSelectListForm;
    @Test
    public void multiSelectList() {
        multiSelectListForm.open();

        assertThat( multiSelectListForm.selectedState()).isEmpty();

        multiSelectListForm.selectStates("Florida", "Ohio", "Texas");
        assertThat( multiSelectListForm.selectedState()).containsExactly("Florida", "Ohio", "Texas");
    }

    HoverPage hoverPage;
    @Test
    public void hover(){
        hoverPage.open();

        hoverPage.hoverOverfigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();
        hoverPage.captionForFigure(1).shouldContainText("user1");

        hoverPage.hoverOverfigure(2);
        hoverPage.captionForFigure(2).shouldBeVisible();
        hoverPage.captionForFigure(2).shouldContainText("user2");
    }
}
