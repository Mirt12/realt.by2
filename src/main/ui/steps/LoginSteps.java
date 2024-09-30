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

    public void fillEmailAndSubmit(String email) {
        HomePage page = new HomePage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getBaseURL()
                .openLoginLink()
                .fillInputFieldEmail(wait, email)
                .clickContinueBtn();
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        HomePage page = new HomePage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getLoginUrl()
                .fillInputFieldEmail(wait, email)
                .clickContinueBtn()
                .fillInputFieldPWD(wait, password)
                .selectAgreeConditionsCheckBox()
                .submitRegistrationForm();
    }
}
