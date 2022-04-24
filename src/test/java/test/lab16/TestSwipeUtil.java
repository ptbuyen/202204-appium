package test.lab16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSwipeUtil{

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav swipe button
            MobileElement navSwipeBtnElem = driver.findElement(MobileBy.AccessibilityId("Swipe"));
            navSwipeBtnElem.click();

            // Wait until on forms screen
            WebDriverWait wait = new WebDriverWait(driver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text, \"Swipe horizontal\")]")));

            // Get Mobile window size
            Dimension windowSize = driver.manage().window().getSize();
            SwipeUtil swipeUtil = new SwipeUtil(driver);

            // Swipe right to left
            swipeUtil.swipeRightToLeft(windowSize);
            swipeUtil.swipeRightToLeft(windowSize, 90);

            // Swipe left to right
            swipeUtil.swipeLeftToRight(windowSize);
            swipeUtil.swipeLeftToRight(windowSize, 90);

            // Swipe up
            swipeUtil.swipeUp(windowSize);
            swipeUtil.swipeUp(windowSize, 90);

            // Swipe down
            swipeUtil.swipeDown(windowSize);
            swipeUtil.swipeDown(windowSize, 90);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
