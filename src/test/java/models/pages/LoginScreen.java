package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.component.BottomNavComponent;
import models.component.LoginFormComponent;
import models.component.LoginSuccessDialogComponent;

public class LoginScreen {

    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent loginFormComponent() {
        return new LoginFormComponent(appiumDriver);
    }

    public LoginSuccessDialogComponent loginSuccessDialogComponent() {
        return new LoginSuccessDialogComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComponent() {
        return new BottomNavComponent(appiumDriver);
    }
}
