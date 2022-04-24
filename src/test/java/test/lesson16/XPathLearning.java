package test.lesson16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.List;

public class XPathLearning {

    public static void main(String[] args) {

        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav login button
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Find all matching elements
            List<MobileElement> credInputFieldElems = driver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credInputFieldElems.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credInputFieldElems.get(PASSWORD_INDEX).sendKeys("12345678");

            MobileElement loginInstructionElem =
                    driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));

            System.out.println(loginInstructionElem.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
