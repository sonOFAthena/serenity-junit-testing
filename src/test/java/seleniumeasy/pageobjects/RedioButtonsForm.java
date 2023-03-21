package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://demo.seleniumeasy.com/basic-radiobutton-demo.html")
public class RedioButtonsForm extends SeleniumEasyForm{

    public void selectOption(String value) {
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        $("#buttoncheck").click();
    }

    public String getResult() {
        return $(".radiobutton").getText();
    }
}
