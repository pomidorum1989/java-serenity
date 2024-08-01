package io.dorum.pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target USER_NAME_FIELD = Target.the("user name field").locatedBy("//*[@id = 'user-name']");
    public static final Target PASSWORD_FIELD = Target.the("password field").locatedBy("//*[@id = 'password']");
    public static final Target LOGIN_BUTTON = Target.the("login button").locatedBy("//*[@id = 'login-button']");
    public static final Target LOGIN_LOGO = Target.the("login logo").locatedBy("//div[@class = 'login_logo']");
}
