package test.lab16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class FormComponentsInteraction{

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on Forms button
            MobileElement navFormsBtnElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsBtnElem.click();

            // Wait until on forms screen
            WebDriverWait wait = new WebDriverWait(driver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text, \"Form components\")]")));

            // Fill Input field
            MobileElement inputFieldElem = driver.findElement(MobileBy.AccessibilityId("text-input"));
            inputFieldElem.sendKeys("I have just inputted!!");

            // Get text from You have typed field
            MobileElement inputResultElem = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            System.out.println(inputResultElem.getText());

            // Click on Switch to SwitchON and get text
            MobileElement switchElem = driver.findElement(MobileBy.AccessibilityId("switch"));
            switchElem.click();

            MobileElement switchTextElem = driver.findElement(MobileBy.AccessibilityId("switch-text"));
            System.out.println(switchTextElem.getText());

            // Click on Switch to SwitchOFF and get text
            switchElem.click();
            System.out.println(switchTextElem.getText());

            // Click on Dropdown
            MobileElement dropdownElem = driver.findElement(MobileBy.AccessibilityId("Dropdown"));
            dropdownElem.click();

            // Wait until dialog display
            By selectDialogSel = MobileBy.id("com.wdiodemoapp:id/select_dialog_listview");
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectDialogSel));

            // Select an item from dialog
            MobileElement selectDialogElem = driver.findElement(selectDialogSel);
            List<MobileElement> listSelectItemElems = selectDialogElem.findElements(MobileBy.id("android:id/text1"));

            if (listSelectItemElems.isEmpty()) {
                throw new RuntimeException("[ERR] There is no select item to test!");
            }

            Random random = new SecureRandom();
            int randomIndex = random.nextInt(listSelectItemElems.size() - 1);
            MobileElement randomElem = listSelectItemElems.get(randomIndex);
            randomElem.click();

            // Get text have just selected from dropdown
            MobileElement dropdownTextElem = dropdownElem.findElement(MobileBy.xpath("//android.widget.EditText"));
            System.out.println(dropdownTextElem.getText());

            // Click on active button
            Dimension windowSize = driver.manage().window().getSize();
            SwipeUtil swipeUtil = new SwipeUtil(driver);
            swipeUtil.swipeUp(windowSize);
            driver.findElement(MobileBy.AccessibilityId("button-Active")).click();

            // Wait until the dialog display
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/parentPanel")));

            // Click on OK btn from dialog
            MobileElement okBtnElem = driver.findElement(MobileBy.id("android:id/button1"));
            okBtnElem.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
