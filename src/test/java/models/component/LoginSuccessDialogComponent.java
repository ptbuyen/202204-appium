package models.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginSuccessDialogComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By loginSuccessTxtSel = MobileBy.id("android:id/message");
    private final static By okBtnSel = MobileBy.id("android:id/button1");

    public LoginSuccessDialogComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement loginSuccessTxtElem() {
        return appiumDriver.findElement(loginSuccessTxtSel);
    }

    public MobileElement okBtnElem() {
        return appiumDriver.findElement(okBtnSel);
    }

    public String getLoginSuccessTxtStr() {
        return loginSuccessTxtElem().getText().trim();
    }

    public void clickOnOkBtn() {
        okBtnElem().click();
    }
}
