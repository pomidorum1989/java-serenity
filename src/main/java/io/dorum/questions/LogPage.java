package io.dorum.questions;

import io.dorum.pages.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LogPage {
    public static Question<String> logoText() {
        return Text.of(LoginPage.LOGIN_LOGO).describedAs("login logo");
    }
}
