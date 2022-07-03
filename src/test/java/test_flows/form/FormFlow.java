package test_flows.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_flows.BaseFlow;

import java.time.Duration;

public class FormFlow extends BaseFlow {

    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void fillTheForm() {
        // Wait until on forms screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text, \"Form components\")]")));

        // Get Mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Calculate Touch points
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        // Convert coordinates --> PointOption
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        // Using TouchAction to swipe
        TouchAction touchAction = new TouchAction(appiumDriver);

        // Swipe up
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();

        // Swipe down
        touchAction
                .longPress(endPoint)
                .moveTo(startPoint)
                .release()
                .perform();

        // Swipe up again
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void verifyFormDisplay() {

    }
}
