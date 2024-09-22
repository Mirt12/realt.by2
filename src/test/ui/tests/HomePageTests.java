package test.ui.tests;

import main.ui.page.HomePage;
import main.ui.steps.LoginSteps;
import main.ui.utils.LoadHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

import java.io.UnsupportedEncodingException;
import java.time.Duration;

public class HomePageTests {

    @Test
    public void loginWithIncorrectEmail() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillLoginFormAndSubmit("Halija", "zfFr3h@jhj1.com");
        String actualErrorText = LoadHelper.getTextByLocator(HomePage.errorLocator);
        Assertions.assertEquals(HomePage.expectedErrorText, actualErrorText);
    }

    @Test
    public void loginWithIncorrectLogin() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillLoginFormAndSubmit("GGGGGG", "Mirt@gmail.com");
        String actualErrorText = LoadHelper.getTextByLocator(HomePage.errorLocator);
        Assertions.assertEquals(HomePage.expectedErrorText, actualErrorText);
    }

    @Test
    public void loginWithoutEmail() throws UnsupportedEncodingException, InterruptedException {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.fillLoginFormAndSubmit("Halija", "");
        String actualErrorText = LoadHelper.getTextByLocator(HomePage.errorLocator);
        Assertions.assertEquals(HomePage.expectedErrorText, actualErrorText);
    }


}
