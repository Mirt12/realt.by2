package main.ui.utils;

import main.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class LoadHelper {
    public static Wait<WebDriver> wait30seconds() {
        WebDriver driver = DriverSingleton.getDriver();
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }

    public static String getTextByLocator(String locator) {
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        WebElement actualTextElement = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(locator));
            }
        });
        return actualTextElement.getText();
    }

}
