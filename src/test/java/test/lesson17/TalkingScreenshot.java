package test.lesson17;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TalkingScreenshot {

    public static void main(String[] args) {
        // Add one more dependency: commons-io

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Whole screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("HomeScreen.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An area
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64loginFormData = loginFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(base64loginFormData, new File(loginFormFileLocation));

            // An element | button-LOGIN
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64loginBtnData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            String loginBtnFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginBtn.png");
            FileUtils.copyFile(base64loginBtnData, new File(loginBtnFileLocation));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
