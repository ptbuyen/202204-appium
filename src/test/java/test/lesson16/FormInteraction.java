package test.lesson16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {

    public static void main(String[] args) {

        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav login button
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Fill the form
            MobileElement usernameElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            usernameElem.sendKeys("teo@sth.com");
            passwordElem.sendKeys("12345678");
            loginBtnElem.click();

            // Get text from login dialog
            By loginDialogTitleSel = MobileBy.id("android:id/alertTitle");

            WebDriverWait wait = new WebDriverWait(driver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginDialogTitleSel));

            MobileElement loginDialogTitleElem = driver.findElement(loginDialogTitleSel);
            System.out.println("Title: " + loginDialogTitleElem.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}
