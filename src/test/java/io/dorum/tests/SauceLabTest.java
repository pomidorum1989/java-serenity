package io.dorum.tests;

import io.dorum.model.User;
import io.dorum.questions.LogPage;
import io.dorum.questions.ProdPage;
import io.dorum.tasks.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.is;

public class SauceLabTest extends BaseTest {

    @CastMember(name = "Tester")
    Actor tester;

    @Tag("Saucelab")
    @DisplayName("Sauce demo login test")
    @ParameterizedTest
    @MethodSource("getUsers")
    public void loginTest(User user) {
        when(tester).attemptsTo(Log.with(user));
        then(tester).should(seeThat("Shopping cart is visible", ProdPage.cartIsVisible(), is(true)));
        when(tester).attemptsTo(Log.out());
        then(tester).should(seeThat(LogPage.logoText(), is("Swag Labs")));
    }

    private static Stream<User> getUsers() {
        return Stream.of(
                new User("standard_user", "secret_sauce"),
                new User("locked_out_user", "secret_sauce"),
                new User("problem_user", "secret_sauce"),
                new User("performance_glitch_user", "secret_sauce"),
                new User("error_user", "secret_sauce"),
                new User("visual_user", "secret_sauce"));
    }
}
