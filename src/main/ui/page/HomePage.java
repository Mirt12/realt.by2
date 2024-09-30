package main.ui.page;

import main.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

public class HomePage {
    private WebDriver driver;
    private String baseUrl = "https://realt.by/";
    private String loginUrl = "https://realt.by/login/?nextPage=/";
    public static final String loginBtnLocator = "//*[@id=\"mainHeader\"]/div/div/div[2]/div/a";
    public static final String loginInputFieldLocator = "//input[@name='login']";
    public static final String continueBtnLocator = "//button[@type='submit']";
    public static final String emailInputFieldLocator = "//input[@id='email']";
    public static final String submitRegistrationBtnLocator = "//button[@type='submit']";
    public static final String submitRegistrationBtnText = "Зарегистрироваться";
    public static final String agreeConditionsCheckBoxLocator = "//label[@for='gdprConfirmed']";
    public static final String registrationByEmailHeaderLocator = "//h2/span[@class]";
    public static final String expectedHeaderText = "Регистрация по email";
    public static final String thanksForRegistrationHeaderLocator = "//h2/span[@class]";
    public static final String expectedRegistrationHeaderText = "Спасибо за регистрацию!";
    public static final String expectedErrorTextForIncorrectEmail = "Некорректный Email";
    public static final String incorrectEmailErrorLocator = "//div[@class='text-danger-500 pt-1.5 text-subhead']";




    public HomePage() {
        this.driver = DriverSingleton.getDriver();
    }

    public HomePage getBaseURL() {
        driver.get(baseUrl);
        return this;
    }

    public HomePage getLoginUrl() {
        driver.get(loginUrl);
        return this;
    }

    public HomePage openLoginLink() {
        WebElement loginLink = driver.findElement(By.xpath(loginBtnLocator));
        loginLink.click();
        return this;
    }

    public HomePage fillEmailOnLoginForm(Wait wait, String email) {
        WebElement inputLogin = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(loginInputFieldLocator));
            }
        });
        inputLogin.sendKeys(email);
        return this;
    }

    public HomePage clickContinueBtn() {
        WebElement continueBtn = driver.findElement(By.xpath(continueBtnLocator));
        continueBtn.click();
        return this;
    }

    public HomePage fillEmailInRegistrationForm(Wait wait, String email) {
        WebElement inputEmail = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(emailInputFieldLocator));
            }
        });
        inputEmail.sendKeys(email);
        return this;
    }

    public HomePage submitRegistrationForm() {
        WebElement registrationForm = driver.findElement(By.xpath(submitRegistrationBtnLocator));
        registrationForm.click();
        return this;
    }

    public HomePage selectAgreeConditionsCheckBox() {
        WebElement agreeConditionsCheckBox = driver.findElement(By.xpath(agreeConditionsCheckBoxLocator));
        agreeConditionsCheckBox.click();
        return this;
    }


}
