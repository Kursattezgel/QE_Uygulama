package Pages;
import Util.ElementHelper;
import Util.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

//import static Util.Hooks.log4j;
import static Util.Hooks.log4j;
import static org.testng.AssertJUnit.assertEquals;


public class LoginPage {
    static WebDriver driver;
    public static ElementHelper elementHelper;
    WebDriverWait wait;
    static Hooks hooks;

    @FindBy(xpath = "//input[@placeholder='Username']")
    public static WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public static WebElement password;
    @FindBy(xpath = "//div[contains(@class,'r-1i6wzkk')]")
    public static WebElement loginBtn;
    @FindBy(xpath = "//div[@class='css-146c3p1']/span")
    public static List<WebElement> challangeInfoList;
    @FindBy(xpath = "//div[contains(text(), 'Open Money Transfer')]")
    public static WebElement openMoneyBtn;
    @FindBy(xpath = "//div[contains(@class,'r-howw7u')]")
    public static WebElement invalid;
    @FindBy(xpath = "//div[contains(@class,'css-146c3p1 r-1ozpqpt r-yv33h5 r-1b43r93')]")
    public static List<WebElement> myAccountInfoListt;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.hooks= new Hooks();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void urlControl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
        log4j.info("URL kontrolü tamamlandı.");
    }

    public void loginElementControl() {
        elementHelper.waitUntilVisible(loginBtn);
        log4j.info("Login butonu görünüyor.");
        elementHelper.waitUntilVisible(username);
        log4j.info("username inputu görünüyor.");
        elementHelper.waitUntilVisible(password);
        log4j.info("password inputu görünüyor.");
        elementHelper.waitUntilClickable(loginBtn);
        log4j.info("Login butonu tıklanabilir");
        elementHelper.waitUntilClickable(username);
        log4j.info("username inputu tıklanabilir");
        elementHelper.waitUntilClickable(password);
        log4j.info("password inputu tıklanabilir");

    }

    public void enterUsername(String userName) {
        elementHelper.sendKeys(username,userName);
        log4j.info("username girildi");
    }

    public void enterPassword(String passwordd) {
        elementHelper.sendKeys(password,passwordd);
        log4j.info("password girildi");
    }

    public void clickLogin() {
        loginBtn.click();
        log4j.info("login butonuna tıklandı");

    }

    public void qePageControl() {

        elementHelper.waitUntilVisible(challangeInfoList.get(0));
        String name = challangeInfoList.get(0).getText();
        assertEquals("Challenge name:",name);
        log4j.info("Text karşılaştırması kontrol edildi");
    }

    public void failedToLogin() {
        elementHelper.waitUntilVisible(invalid);
        String invalidText = invalid.getText();
        assertEquals(invalidText,"Username or Password Invalid!");
        log4j.info("invalid karşılaştırma yapıldı");
    }

    public void openMoneyclick() throws InterruptedException {

        elementHelper.waitUntilClickable(openMoneyBtn);
        openMoneyBtn.click();
        log4j.info("open money butonuna tıklandı");
        Thread.sleep(2000);

    }
    public void MyAccountControl() throws InterruptedException {

        String accountName = myAccountInfoListt.get(0).getText();
        assertEquals(accountName,"kursattezgel");
        log4j.info("My account name karşılaştırması yapıldı");
    }

}
