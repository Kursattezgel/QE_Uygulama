package Pages;
import Util.ElementHelper;
import Util.ExtentReportManager;
import Util.Hooks;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.bouncycastle.asn1.cmp.Challenge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static Util.Hooks.log4j;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyAccountPage {
    static WebDriver driver;
    public static ElementHelper elementHelper;
    WebDriverWait wait;
    static Hooks hooks;


    @FindBy(xpath = "//*[text()='Transfer money']")
    public static WebElement transferBtn;
    @FindBy(xpath = "//*[text()='Add money']")
    public static WebElement addmoney;
    @FindBy(xpath = "//*[text()='Edit account']")
    public static WebElement editacc;
    @FindBy(xpath = "//input[contains(@class,'css-11aywtz')]")
    public static WebElement tmyAmount;
    @FindBy(xpath = "//*[text()='Send']")
    public static WebElement tmySend;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div[7]/div[2]/div")
    public static WebElement totalAmount;
    @FindBy(xpath = "//input[contains(@class,'r-1mqtkb5')]")
    public static WebElement cardNumber;
    @FindBy(xpath = "//input[contains(@class,'r-rs99b7 r-h3s6tt')]")
    public static List<WebElement> addmoneylist;
    @FindBy(xpath = "//*[text()='Add']")
    public static WebElement Addbtn;
    @FindBy(xpath = "//input[contains(@class,'css-11aywtz')]")
    public static WebElement accName;
    @FindBy(xpath = "//*[text()='UPDATE']")
    public static WebElement updatebtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div[1]/div[2]")
    public static WebElement myaccName;



    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.hooks = new Hooks();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public static double amountEntered;
    public static double firstTotal;
    public static String lastTotal;
    public static String initialtTotalBalance;
    public static int value=0;


    public static String firstAccName;
    public static String newAccName;

    public void tmyBtnClick() {
        elementHelper.waitUntilClickable(transferBtn);
        initialtTotalBalance = totalAmount.getText();
        transferBtn.click();

        log4j.info("TRANSFER MONEY BUTONUNA TIKLANDI");
    }

    public void enterAmount(String amount) {
        elementHelper.sendKeys(tmyAmount, amount);

        amountEntered = Double.parseDouble(amount);//kendi girdiğimiz tutar

        log4j.info("Tutar" + amount + " Girildi");
    }

    public void sendClick() throws InterruptedException {

        Thread.sleep(2000);
        tmySend.click();
        log4j.info("SEND butonuna tıklandı");
    }

    public void totalBalanceControl() throws InterruptedException {

        firstTotal=Double.parseDouble(initialtTotalBalance.replace(",",""));//transfer yapmadan önceki Bakiye miktarımız firstTotal

        log4j.info("ilk total :" + firstTotal);
        log4j.info("girilen tutar :" + amountEntered);

        if(value==1) {//value 1 ise başka hesaba transfer
            double sameBalanca = firstTotal - amountEntered; //transferden sonra olması gereken miktar sonToTal
            log4j.info("sameBalanca  :" + sameBalanca);
            elementHelper.waitUntilClickable(transferBtn);
            Thread.sleep(3000);
            lastTotal = totalAmount.getText();
            log4j.info("lastTotal :" + lastTotal);
            double latestTotal = Double.parseDouble(lastTotal.replace(",", ""));// En son toplam görünen bakiye miktarımız
            assertEquals(sameBalanca, latestTotal);
        }
        else { //value 1 değilse kendi hesabına para yatırma

            double balance = firstTotal + amountEntered; //transferden sonra olması gereken miktar balance
            log4j.info("balance  :" + balance);
            Thread.sleep(3000);
            lastTotal = totalAmount.getText();
            log4j.info("son gettext :" + lastTotal);
            double latestTotal = Double.parseDouble(lastTotal.replace(",",""));// En son toplam görünen bakiye miktarımız
            assertEquals(balance,latestTotal);
        }
        //en son görünen bakiye miktarı ile olması gereken bakye miktarı karşılaştırması


    }




    public void addMoneyClick() {
        elementHelper.waitUntilClickable(addmoney);
        initialtTotalBalance = totalAmount.getText();
        addmoney.click();
    }

    public void enterCardNumber(String cardNumber) {
        elementHelper.sendKeys(addmoneylist.get(0),cardNumber);
    }

    public void enterCardHolder(String cardholder) {
        elementHelper.sendKeys(addmoneylist.get(1),cardholder);
    }

    public void enterDate(String date) {
        elementHelper.sendKeys(addmoneylist.get(2),date);
    }

    public void enterCvv(String cvv) {
        elementHelper.sendKeys(addmoneylist.get(3),cvv);
    }

    public void enterQuantity(String quantity) {
        elementHelper.sendKeys(addmoneylist.get(4),quantity);
        amountEntered = Double.parseDouble(quantity);

    }

    public void addClick() {
        elementHelper.waitUntilClickable(Addbtn);
        Addbtn.click();
    }

    public void editButtonClick() {
        elementHelper.waitUntilClickable(editacc);
        firstAccName=myaccName.getText();
        log4j.info("firstAccName :" + firstAccName);
        editacc.click();
        log4j.info("edic acc btn tıklandı");
    }

    public void enterAccName(String accname) {
        accName.clear();
        elementHelper.sendKeys(accName,accname);
        newAccName = accname;
        log4j.info("Account name"+" "+ accname+" girildi");
    }

    public void updateButtonClick() {
        elementHelper.waitUntilClickable(updatebtn);
        updatebtn.click();
        log4j.info("update btn tıklandı");
    }

    public void accountNameControl() throws InterruptedException {
        Thread.sleep(5000);
        String accName = myaccName.getText();
        log4j.info("guncel acc name :"+ accName);
        log4j.info("ilk acc name :"+ firstAccName);
        assertEquals(accName,newAccName);
    }

    public void balancaControl() throws InterruptedException {
        Thread.sleep(3000);
        firstTotal=Double.parseDouble(initialtTotalBalance.replace(",",""));//transfer yapmadan önceki Bakiye miktarımız firstTotal
        lastTotal = totalAmount.getText();
        log4j.info("son gettext :" + lastTotal);
        double latestTotal = Double.parseDouble(lastTotal.replace(",", ""));// En son toplam görünen bakiye miktarımız
            if  (firstTotal==latestTotal){
            assertTrue(true);
                }
            else   {
                assertTrue(false);
        }
    }

    public void enterTheAmount() {
        firstTotal=Double.parseDouble(initialtTotalBalance.replace(",",""));//transfer yapmadan önceki Bakiye miktarımız firstTotal
        log4j.info("firstTotal"+ firstTotal);
        double big = firstTotal + 1.00; //toplam bakiyeden daha büyük bir sayı
        log4j.info("Tutar" + big + " Girildi");

         //bigString = big + "";
        String bigString= String.format("%.2f", big);
        bigString = bigString.replace(",",".");

        elementHelper.sendKeys(tmyAmount,bigString);//Girilecek tutar

        log4j.info("Tutar" + big + " Girildi");
        log4j.info("Tutar" + bigString + " Girildi");



    }
}
