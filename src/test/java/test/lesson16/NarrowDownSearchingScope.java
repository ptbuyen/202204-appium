package test.lesson16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav form button
            MobileElement navSwipeBtnElem = driver.findElement(MobileBy.AccessibilityId("Swipe"));
            navSwipeBtnElem.click();

            // Wait until on forms screen
            WebDriverWait wait = new WebDriverWait(driver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text, \"Swipe horizontal\")]")));

            // Get Mobile window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 0 * screenHeight / 100;
            int yEndPoint = 80 * screenHeight / 100;

            // Convert coordinates --> PointOption
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .press(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            Map<String, String> notifications = new HashMap<>();
            List<MobileElement> notificationElems = driver.findElements(MobileBy.id("android:id/notification_headerless_view_column"));
            for (MobileElement notificationElem : notificationElems) {
                try {
                    MobileElement titleElem = notificationElem.findElement(MobileBy.id("android:id/title"));
                    String titleText = titleElem.getText();
                    MobileElement contentElem = notificationElem.findElement(MobileBy.id("android:id/text"));
                    String contentText = contentElem.getText();
                    notifications.put(titleText, contentText);
                } catch (Exception ignored) {
                }
            }

            if (notifications.keySet().isEmpty()) {
                throw new RuntimeException("[ERR] There is no notification to test!");
            } else {
                // Verify here
                for (String title : notifications.keySet()) {
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + notifications.get(title));
                }
            }

            // Swipe up to dismiss notification bar
            for (int i = 0; i < 2; i++) {
                touchAction
                        .press(endPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                        .moveTo(startPoint)
                        .release()
                        .perform();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
