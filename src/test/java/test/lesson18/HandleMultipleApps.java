package test.lesson18;

import driver.AppPackage;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class HandleMultipleApps {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Login then input credentials > click on login btn
            // Find and click on nav login button
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Fill the form
            MobileElement usernameElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            usernameElem.sendKeys("teo@sth.com");
            passwordElem.sendKeys("12345678");
            loginBtnElem.click();

            // Put the app into background || similar with pressing home btn
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            // Turn wi-fi off || switch to another app
            appiumDriver.activateApp(AppPackage.settings);
            By networkLabelSel = MobileBy.xpath("//*[@text=\"Mobile, Wi‑Fi, hotspot\"]");
            By wifiLabelSel = MobileBy.xpath("//*[@text=\"Internet\"]");
            By wifiStatusSel = MobileBy.id("android:id/switch_widget");

            // Navigate to network
            MobileElement internetLabelElem = appiumDriver.findElement(networkLabelSel);
            internetLabelElem.click();

            // Navigate to wi-fi list
            MobileElement wifiLabelElem = appiumDriver.findElement(wifiLabelSel);
            wifiLabelElem.click();

            // Trigger on/off wi-fi logic
            MobileElement wifiStatusElem = appiumDriver.findElement(wifiStatusSel);
            String wifiStatusStr = wifiStatusElem.getAttribute("checked");
            boolean isWiFiOn = wifiStatusStr.equalsIgnoreCase("true");

            if (isWiFiOn) {
                wifiStatusElem.click();
            }

            // Come back to app > interact with other elements
            appiumDriver.activateApp(AppPackage.wdio);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            // DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
