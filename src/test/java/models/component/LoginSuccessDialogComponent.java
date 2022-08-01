package models.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginSuccessDialogComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
//    private final static By loginSuccessTxtSel = MobileBy.id("android:id/message");
//    private final static By okBtnSel = MobileBy.id("android:id/button1");

    public LoginSuccessDialogComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Success\"")
    public MobileElement msgTitleElem;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"OK\"")
    private MobileElement okBtnElem;

//    public MobileElement loginSuccessTxtElem() {
//        return appiumDriver.findElement(loginSuccessTxtSel);
//    }
//
//    public MobileElement okBtnElem() {
//        return appiumDriver.findElement(okBtnSel);
//    }

    public String getLoginSuccessTxtStr() {
        return msgTitleElem.getText().trim();
    }

    public void clickOnOkBtn() {
        okBtnElem.click();
    }
}
