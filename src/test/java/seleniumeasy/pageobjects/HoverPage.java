package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    public static final String FIGURE_IMAGE = "(//*[@class = 'figure'])[{0}]";
    public static final String FIGURE_CAPTION = "(//*[@class = 'figcaption'])[{0}]";

    public void hoverOverfigure(int number) {
        WebElementFacade figure =  $(FIGURE_IMAGE, number);

        withAction()
                .moveToElement(figure)
                .perform();

        // Drag and Drop
//        withAction().dragAndDrop($(FIGURE_IMAGE,1), $(FIGURE_IMAGE,2)).perform();
    }

    public WebElementState captionForFigure(int number) {
        return $(FIGURE_CAPTION, number);
    }
}
