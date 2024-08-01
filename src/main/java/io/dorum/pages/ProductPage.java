package io.dorum.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {
    public static final Target MENU_BUTTON = Target.the("menu button").located(By.id("react-burger-menu-btn"));
    public static final Target SHOPPING_CART_ICON = Target.the("shopping cart icon").locatedBy("//*[@id = 'shopping_cart_container']");
    public static final Target LOGOUT_BUTTON = Target.the("logout button").locatedBy("//*[@id = 'logout_sidebar_link']");
}
