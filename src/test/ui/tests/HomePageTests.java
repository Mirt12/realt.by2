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
        String loginBtnLocator = "//nav/a[@href='/login/?nextPage=/']";
        WebElement loginBtn = driver.findElement(By.xpath(loginBtnLocator));
        loginBtn.click();
    }

}
