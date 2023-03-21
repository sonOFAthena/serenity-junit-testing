package serenityswag.cart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.ProductList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static serenityswag.authentication.User.*;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Before
    public void login(){
        login.as(STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartBadge;

    @Steps
    CartActions cart;

    @Test
    public void theCorrectItemCountShouldBeShown(){
        //Check that the shopping cart badge is empty
        Serenity.reportThat("The shopping cart badge should be empty",
                () -> assertThat(shoppingCartBadge.badgeCount()).isEmpty()
        );

        // Add 1 items to the cart
        cart.addItem("Sauce Labs Backpack");

        // The shopping cart badge shoull be "1"
        Serenity.reportThat("The shopping cart should now be 1",
                () ->  assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1")
        );
    }

    ProductList productList;

    @Test
    public void allTheItemsShouldAppearInTheCart(){
        //Add several items to the cart
        List<String> selectedItems = firstThreePrdouctTitlesDisplayed();

        // Open the cart page
        cart.addItems(selectedItems);

        String cartBadgeCount = Integer.toString(selectedItems.size());
        Serenity.reportThat("The shopping cart should now be " + cartBadgeCount,
                () ->  assertThat(shoppingCartBadge.badgeCount()).isEqualTo(cartBadgeCount)
        );


        cart.openCart();

        // Should see all of the items listed
        Serenity.reportThat("Should see all of the items listed",
                () -> assertThat( cart.displayedItems()).containsExactlyElementsOf(selectedItems)
        );

    }

    CartPageObject cartPage;

    @Test
    public void pricesForEachItemShouldBeShownInTheCart(){
        //add items to the shopping cart
        cart.addItems(firstThreePrdouctTitlesDisplayed());

        //Open the cart page
        cartPage.open();

        // Check that each item in the cart has a price
        List<CartItem> items = cartPage.items();
        items.forEach(System.out::println);

        assertThat(items).hasSize(3)
                .allMatch(item -> item.price() > 0.0 );
    }

    private List<String> firstThreePrdouctTitlesDisplayed() {
        return productList.titles().subList(0, 3);
    }
}
