package test.ui.tests;

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
    public void openBrowser() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cache", "--incognito", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://realt.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        String loginBtnLocator = "//*[@id=\"mainHeader\"]/div/div/div[2]/div/a";
        driver.findElement(By.xpath(loginBtnLocator)).click();
        String loginInputFieldLocator = "//input[@name='login']";
        driver.findElement(By.xpath(loginInputFieldLocator)).sendKeys("Galija");
        String submitBtnLocator = "//button[@type='submit']";
        driver.findElement(By.xpath(submitBtnLocator)).click();
        String emailInputFielLocator = "//input[@id='email']";

    }

}
