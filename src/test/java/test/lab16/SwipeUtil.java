package test.lab16;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class SwipeUtil {

    private AppiumDriver<MobileElement> driver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;

    public SwipeUtil(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        touchAction = new TouchAction(driver);
    }

    public void swipeUp (Dimension windowSize) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeUp (Dimension windowSize, int percentage) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = percentage * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeDown (Dimension windowSize) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint = 10 * screenHeight / 100;
        int yEndPoint = 50 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeDown (Dimension windowSize, int percentage) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 50 * screenWidth / 100;

        int yStartPoint =  10 * screenHeight / 100;
        int yEndPoint = percentage * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeRightToLeft (Dimension windowSize) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 70 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeRightToLeft (Dimension windowSize, int percentage) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = percentage * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeLeftToRight (Dimension windowSize) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = 70 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(endPoint)
                .moveTo(startPoint)
                .release()
                .perform();
    }

    public void swipeLeftToRight (Dimension windowSize, int percentage) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = percentage * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        touchAction
                .longPress(endPoint)
                .moveTo(startPoint)
                .release()
                .perform();
    }
}
