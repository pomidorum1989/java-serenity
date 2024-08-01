package io.dorum.questions;

import io.dorum.pages.ProductPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ProdPage {
    public static Question<Boolean> cartIsVisible() {
        return Visibility.of(ProductPage.SHOPPING_CART_ICON).describedAs("shopping cart icon");
    }
}
