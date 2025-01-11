package StepDefinitions;
import Pages.LoginPage;
import Util.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);



    @Given("the user is on the site page")
    public void theUserIsOnTheSitePage() {
        loginPage.urlControl("https://catchylabs-webclient.testinium.com/signIn");
        loginPage.loginElementControl();
    }

    @When("enter the username {string}")
    public void enterTheUsername(String userName) {
        loginPage.enterUsername(userName);
    }

    @And("enter the password {string}")
    public void enterThePassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("click on the login button")
    public void clickOnTheLoginButton() {
        loginPage.clickLogin();
    }

    @And("click on the open money transfer button")
    public void clickOnTheOpenMoneyTransferButton() throws InterruptedException {
        loginPage.openMoneyclick();
    }

    @Then("QE page opens")
    public void qePageOpens() {
        loginPage.qePageControl();
    }

    @Then("Failed to login")
    public void failedToLogin() {
        loginPage.failedToLogin();
    }

    @Then("My Account page opens")
    public void myAccountPageOpens() throws InterruptedException {
        loginPage.MyAccountControl();
    }
}
