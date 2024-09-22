package main.ui.steps;

import main.ui.driver.DriverSingleton;
import main.ui.page.HomePage;
import main.ui.utils.LoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class LoginSteps {
    WebDriver driver;

    public LoginSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void openLoginForm() {
        HomePage page = new HomePage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getBaseURL()
                .openLoginLink();
    }

    public void fillLoginFormAndSubmit(String login, String email) {
        HomePage page = new HomePage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getLoginUrl()
                .fillInputFieldLogin(wait, login)
                .clickContinueBtn()
                .fillInputFieldEmail(wait, email)
                .selectAgreeConditionsCheckBox()
                .submitRegistrationForm();
    }
}
