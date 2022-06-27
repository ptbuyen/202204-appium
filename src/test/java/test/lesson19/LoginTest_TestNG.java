package test.lesson19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest_TestNG {

    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        Map<String, String> credData = new HashMap<>();
        credData.put("teo@", "12345678");
        credData.put("teo@sth.com", "1234567");
        credData.put("teo@xyz.com", "12345678");

        try {
            for (String email : credData.keySet()) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, email, credData.get(email));
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
