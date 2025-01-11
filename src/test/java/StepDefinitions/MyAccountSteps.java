package StepDefinitions;
import Pages.MyAccountPage;
import Util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class MyAccountSteps {
    WebDriver driver = DriverFactory.getDriver();
    MyAccountPage myAccountPage = new MyAccountPage(driver);


    @When("click on the transfer money button")
    public void clickOnTheTransferMoneyButton() {
        myAccountPage.tmyBtnClick();
    }

    @And("enter the amount {string}")
    public void enterTheAmount(String amount) {
        myAccountPage.enterAmount(amount);
    }

    @And("click on the Send")
    public void clickOnTheSend() throws InterruptedException {
        myAccountPage.sendClick();
        MyAccountPage.value=1;
    }

    @Then("total balance is checked")
    public void totalBalanceIsChecked() throws InterruptedException {
        myAccountPage.totalBalanceControl();
    }

    @When("click on the ADD MONEY")
    public void clickOnTheADDMONEY() {
        myAccountPage.addMoneyClick();
    }

    @And("enter the card number {string}")
    public void enterTheCardNumber(String cardNumber) {
        myAccountPage.enterCardNumber(cardNumber);
    }

    @And("enter the card holder {string}")
    public void enterTheCardHolder(String cardHolder) {
        myAccountPage.enterCardHolder(cardHolder);
    }

    @And("enter the expiry date {string}")
    public void enterTheExpiryDate(String date) {
        myAccountPage.enterDate(date);
    }

    @And("enter the CVV {string}")
    public void enterTheCVV(String cvv) {
        myAccountPage.enterCvv(cvv);
    }

    @And("enter the quantity {string}")
    public void enterTheQuantity(String quantity) {
        myAccountPage.enterQuantity(quantity);
    }

    @And("click on the ADD button")
    public void clickOnTheADDButton() throws InterruptedException {
        myAccountPage.addClick();
        Thread.sleep(10000);
    }

    @When("click on the Edit Account button")
    public void clickOnTheEditAccountButton() {
        myAccountPage.editButtonClick();
    }

    @When("enter the account name {string}")
    public void enterTheAccountName(String accName) {
        myAccountPage.enterAccName(accName);
    }

    @And("click on the Update button")
    public void clickOnTheUpdateButton() {
        myAccountPage.updateButtonClick();
    }

    @Then("account name is checked")
    public void accountNameIsChecked() throws InterruptedException {
        myAccountPage.accountNameControl();
    }

    @Then("Check if the balance is the same")
    public void checkIfTheBalanceIsTheSame() throws InterruptedException {
        myAccountPage.balancaControl();
    }

    @And("enter the amount more than the balance")
    public void enterTheAmountMoreThanTheBalance() {
        myAccountPage.enterTheAmount();
    }
}
