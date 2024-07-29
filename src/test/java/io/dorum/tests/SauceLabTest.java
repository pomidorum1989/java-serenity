package io.dorum.tests;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SauceLabTest extends BaseTest {

    @CastMember(name = "Tester")
    Actor tester;

    @DisplayName("Sauce demo login test")
    @ParameterizedTest
    @CsvSource({
            "standard_user, secret_sauce",
            "locked_out_user, secret_sauce",
            "problem_user, secret_sauce",
            "performance_glitch_user, secret_sauce",
            "error_user, secret_sauce",
            "visual_user, secret_sauce"
    })
    public void loginTest(String userName, String password) {
        Target loginBtn = Target.the("login button").locatedBy("//*[@id = 'login-button']");
        tester.attemptsTo(
                Open.url("https://www.saucedemo.com"),
                Enter.theValue(userName).into("//*[@id = 'user-name']"),
                Enter.theValue(password).into("//*[@id = 'password']"),
                Ensure.that(loginBtn).isDisplayed(),
                Click.on(loginBtn)
        );
//        boolean isShoppingCartVisible = tester.asksFor(Visibility.of("//*[@id = 'shopping_cart_container']"));
        tester.should(seeThat("Shopping cart visibility", Visibility.of("//*[@id = 'shopping_cart_container']"), equalTo(true)));
        tester.attemptsTo(
                WaitUntil.the(visibilityOfElementLocated(By.id("react-burger-menu-btn"))),
                Click.on("//*[@id = 'react-burger-menu-btn']"),
                Click.on("//*[@id = 'logout_sidebar_link']"));
        String logoText = tester.asksFor(Text.of("//div[@class = 'login_logo']"));
        assertThat(logoText).isEqualTo("Swag Labs");
    }
}
