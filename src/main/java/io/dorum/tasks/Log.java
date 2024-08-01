package io.dorum.tasks;

import io.dorum.model.User;
import io.dorum.pages.LoginPage;
import io.dorum.pages.ProductPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Log {

    public static Task with(User user) {
        return Task.where("{0} tries to login as" + user.login(),
                Open.url("https://www.saucedemo.com"),
                Enter.theValue(user.login()).into(LoginPage.USER_NAME_FIELD),
                Enter.theValue(user.password()).into(LoginPage.PASSWORD_FIELD),
                Ensure.that(LoginPage.LOGIN_BUTTON).isDisplayed(),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static Task out() {
        return Task.where("user logout from prod page",
                WaitUntil.the(visibilityOfElementLocated(By.id("react-burger-menu-btn"))),
                Click.on(ProductPage.MENU_BUTTON),
                Click.on(ProductPage.LOGOUT_BUTTON)
        );
    }
}
