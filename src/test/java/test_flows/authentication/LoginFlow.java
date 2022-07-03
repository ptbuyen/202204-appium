package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.component.LoginFormComponent;
import models.component.LoginSuccessDialogComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;
    private String emailStr;
    private String passwordStr;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String emailStr, String passwordStr) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.emailStr = emailStr;
        this.passwordStr = passwordStr;
    }

    public void login() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();
        if (!emailStr.isEmpty()) {
            MobileElement emailElem = loginFormComponent.emailElem();
            emailElem.clear();
            emailElem.sendKeys(emailStr);
        }

        if (!passwordStr.isEmpty()) {
            MobileElement passwordElem = loginFormComponent.passwordElem();
            passwordElem.clear();
            passwordElem.sendKeys(passwordStr);
        }

        loginFormComponent.clickOnLoginBtn();
    }

    public void verifyLogin() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(emailStr);
        boolean isPasswordValid = passwordStr.length() >= 8;

        System.out.printf("Email: %s, %b | Password: %s, %b\n", emailStr, isEmailValid, passwordStr, isPasswordValid);

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();
        LoginSuccessDialogComponent loginSuccessDialogComponent = loginScreen.loginSuccessDialogComponent();


        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds(loginSuccessDialogComponent);
        }

        if (!isEmailValid) {
            verifyIncorrectEmailStr(loginFormComponent);
        }

        if (!isPasswordValid) {
            verifyIncorrectPasswordStr(loginFormComponent);
        }

        System.out.println("=================\n");
    }

    //*[@text='Please enter a valid email address']
    //[contains(@text,"Please enter at least 8 characters")]
    private void verifyCorrectLoginCreds(LoginSuccessDialogComponent loginSuccessDialogComponent) {
        // TODO: Homework;
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.visibilityOf(loginSuccessDialogComponent.loginSuccessTxtElem()));

        String actualLoginSuccessTxtStr = loginSuccessDialogComponent.getLoginSuccessTxtStr();
        String expectedLoginSuccessTxtStr = "You are logged in!";

        // Verification
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLoginSuccessTxtStr, expectedLoginSuccessTxtStr,
                "[ERR] Login success str incorrect");
        softAssert.assertAll();

        loginSuccessDialogComponent.clickOnOkBtn();
    }

    private void verifyIncorrectEmailStr(LoginFormComponent loginFormComponent) {
        String actualInvalidEmailStr = loginFormComponent.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address.";

        // Verification
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualInvalidEmailStr, expectedInvalidEmailStr,
                "[ERR] Invalid email format str incorrect");

        System.out.println("-------------->>>>>>>>>>>>After asserting");
        softAssert.assertTrue(false, "[ERR] True != False");

        softAssert.assertAll();
    }

    private void verifyIncorrectPasswordStr(LoginFormComponent loginFormComponent) {
        String actualInvalidPasswordStr = loginFormComponent.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters.";

        // Verification
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualInvalidPasswordStr, expectedInvalidPasswordStr,
                "[ERR] Invalid password format str incorrect");

        System.out.println("-------------->>>>>>>>>>>>After asserting");
        softAssert.assertTrue(false, "[ERR] True != False");

        softAssert.assertAll();
    }
}
