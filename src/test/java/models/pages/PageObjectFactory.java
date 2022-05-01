package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageObjectFactory {

    private final AppiumDriver<MobileElement> appiumDriver;

    public PageObjectFactory(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(accessibility = "input-email")
    @iOSXCUITFindBy(iOSNsPredicate = "aaaa")
    private MobileElement emailElem;

    @AndroidFindBy(accessibility = "input-password")
    private MobileElement passwordElem;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private MobileElement loginBtnElem;

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailElem.sendKeys(email);
        }
    }

    public void inputPassword(String password) {
        if (!password.isEmpty()) {
            passwordElem.sendKeys(password);
        }
    }

    public void clickOnLoginBtn() {
        loginBtnElem.click();
    }

    // We can mix the normal Page Object Model here
    public void sth() {

    }
}
