package models.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By emailSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailTxtSel =
            MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPasswordTxtSel =
            MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement emailElem() {
        return appiumDriver.findElement(emailSel);
    }

    public MobileElement passwordElem() {
        return appiumDriver.findElement(passwordSel);
    }

    public MobileElement loginBtnElem() {
        return appiumDriver.findElement(loginBtnSel);
    }

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailElem().sendKeys(email);
        }
    }

    public void inputPassword(String password) {
        if (!password.isEmpty()) {
            passwordElem().sendKeys(password);
        }
    }

    public String getInvalidEmailStr(){
        return appiumDriver.findElement(incorrectEmailTxtSel).getText().trim();
    }

    public String getInvalidPasswordStr(){
        return appiumDriver.findElement(incorrectPasswordTxtSel).getText().trim();
    }

    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }

}
