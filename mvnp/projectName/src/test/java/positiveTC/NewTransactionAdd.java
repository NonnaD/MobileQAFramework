package positiveTC;

import MyPatterns.Base;
import MyPatterns.Calendar;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FirstAccountPage;
import pageObjects.FirstPreference;
import pageObjects.NewTransactionPage;

import java.io.IOException;


public class NewTransactionAdd extends Base {
    public static final Logger log = LogManager.getLogger(NewTransactionAdd.class.getName());
    public static AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void initialize() throws IOException {
       driver = initializeDriver();
       log.info("Driver is initialized");
    }



    @Test(priority = 1)
    public void firstPage(){
        FirstPreference fp = new FirstPreference(driver);
        fp.themeButton.click();
        fp.nextButton.click();
        String mes = fp.setUpMessage.getText();
        Assert.assertTrue(mes.equals("Let us set up your first account"));



    }

    @Test(priority = 2, dependsOnMethods = "firstPage")
    public void createAccount(){
        FirstAccountPage account1 = new FirstAccountPage(driver);
        account1.accountName.clear();
        account1.accountName.sendKeys("My first account");
        log.info("Entered data in 'Account name' field");
        driver.hideKeyboard();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Opening Balance\").instance(0))");
        log.info("Page crolled down");
        account1.openingBalance.clear();
        account1.openingBalance.sendKeys("10000");
        log.info("Entered data in 'Ammount' field");
        driver.hideKeyboard();
        account1.currencyButton.click();
        String currency = "US Dollar";
        for(int i = 0; i < account1.currency.size(); i++){
            if(account1.currency.get(i).getText().equals(currency)){
                System.out.println(account1.currency.get(i).getText());
                account1.currency.get(i).click();
                break;
            }
        }
        log.info("Currency is selected");
        //Select currencySelect = new Select(account1.currencyButton);
        //currencySelect.selectByVisibleText("US Dollar");

        account1.moreOptions.click();
        account1.description.sendKeys("My first account 10000$");
        log.info("Entered data in 'Description' field");
        //driver.hideKeyboard();
        account1.cashAccount.click();
        String accountType = "Bank account";
        log.info("Account type is selected");

        for (int n = 0; n < account1.selectCahsAccount.size(); n++){
            if(account1.selectCahsAccount.get(n).getText().equals(accountType)){
                account1.selectCahsAccount.get(n).click();
                break;
            }
        }

        account1.getStarted.click();
        log.info("New account is created");


    }

    @Test(priority = 3, dependsOnMethods = {"createAccount"})
    public void newTransaction(){
        NewTransactionPage trans = new NewTransactionPage(driver);
        trans.newTransButton.click();
        //trans.accountName.click();
        String myAccountName = "My first account";
        for(int i = 0; i < trans.accountSelect.size(); i++){
            if(trans.accountSelect.get(i).equals(myAccountName)){
                trans.accountSelect.get(i).click();
                break;
            }
        }
        log.info("Account selected");
        trans.amount.sendKeys("10000");
        driver.hideKeyboard();
        log.info("Transaction amount is entered");
        trans.calendarButton.click();
        Calendar cal = new Calendar();
        cal.calendar("15", trans.pickDay);
        log.info("Date is piked");
        trans.calendarOk.click();
        trans.payer.sendKeys("Bank of America");
        trans.saveNew.click();
        log.info("Entered data in 'Payer' field");

        String message = "Successfully saved";
        Assert.assertTrue(trans.assertMes.getText().equals(message));








    }


}
