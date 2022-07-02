package test.lesson19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest_TestNG {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
//        Map<String, String> credData = new HashMap<>();
//        credData.put("teo@", "12345678");
//        credData.put("teo@sth.com", "1234567");
//        credData.put("teo@xyz.com", "12345678");

        try {
//            for (String email : credData.keySet()) {
//                LoginFlow loginFlow = new LoginFlow(appiumDriver, email, credData.get(email));
//                loginFlow.goToLoginScreen();
//                loginFlow.login();
//                loginFlow.verifyLogin();
//            }

                String email = loginCredData.getEmail();
                String password = loginCredData.getPassword();
                LoginFlow loginFlow = new LoginFlow(appiumDriver, email, password);
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }

    @DataProvider
    public LoginCredData[] loginCredData(){
        // Build support method to convert form JSON -> Array of Object

        // Return an array of objects

        LoginCredData loginCredData01 = new LoginCredData("teo@", "12345678");
        LoginCredData loginCredData02 = new LoginCredData("teo@sth.com", "1234567");
        LoginCredData loginCredData03 = new LoginCredData("teo@xyz.com", "12345678");
        return new LoginCredData[]{loginCredData01, loginCredData02, loginCredData03};
    }
}
