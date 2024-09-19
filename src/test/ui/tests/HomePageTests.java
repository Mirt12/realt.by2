package test.ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class HomePageTests {
    @Test
    public void loginWithIncorrectEmail() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cache", "--incognito", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://realt.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        String loginBtnLocator = "//*[@id=\"mainHeader\"]/div/div/div[2]/div/a";
        driver.findElement(By.xpath(loginBtnLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        String loginInputFieldLocator = "//input[@name='login']";
        driver.findElement(By.xpath(loginInputFieldLocator)).sendKeys("Galija");
        String submitBtnLocator = "//button[@type='submit']";
        driver.findElement(By.xpath(submitBtnLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        String emailInputFielLocator = "//input[@id='email']";
        String submitRegistrationBtnLocator = "//button[@type='submit']";
        driver.findElement(By.xpath(emailInputFielLocator)).sendKeys("zfFr66h!_jhj1");
        driver.findElement(By.xpath(submitRegistrationBtnLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        String expectedErrorText = "Некорректный Email";
        String errorLocator = "//div[@class='text-danger-500 pt-1.5 text-subhead']";
        WebElement actualError = driver.findElement(By.xpath(errorLocator));
        String actualErrorText = actualError.getText();
        Assertions.assertEquals(expectedErrorText, actualErrorText);
    }
}
