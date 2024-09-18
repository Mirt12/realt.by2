package main.ui.page;

import main.ui.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private String baseUrl = "https://realt.by/";

    public HomePage() {
        this.driver = DriverSingleton.getDriver();
    }

    public HomePage getBaseURL() {
        driver.get(baseUrl);
        return this;
    }

}
