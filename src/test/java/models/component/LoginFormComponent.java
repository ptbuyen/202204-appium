package models.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By emailSel = MobileBy.AccessibilityId("input-email");
//    private final static By incorrectEmailTxtSel =
//            MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
//    private final static By incorrectPasswordTxtSel =
//            MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    public MobileElement emailElem() {
        return appiumDriver.findElement(emailSel);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Please enter a valid email address')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter a valid email address\"")
    public MobileElement incorrectEmailTxtElem;

    public MobileElement passwordElem() {
        return appiumDriver.findElement(passwordSel);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Please enter at least 8 characters')]")
    @iOSXCUITFindBy(accessibility = "Please enter at least 8 characters")
    public MobileElement incorrectPasswordTxtElem;


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
        return incorrectEmailTxtElem.getText().trim();
    }

    public String getInvalidPasswordStr(){
        return incorrectPasswordTxtElem.getText().trim();
    }

    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }

}
