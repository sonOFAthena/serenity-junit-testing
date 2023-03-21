package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.ResolvableElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ProductList  extends PageObject {

    public static By addToCartButtonFor(String itemName) {
        return By.xpath("//div[@class = 'inventory_item'][contains(.,'" + itemName + "')]//button");
    }

    public List<String> titles() {
        List<String> titles = findAll(".inventory_item_name").textContents();

        return titles;
    }

    public String imageTextForProduct(String productName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }

    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }
}
