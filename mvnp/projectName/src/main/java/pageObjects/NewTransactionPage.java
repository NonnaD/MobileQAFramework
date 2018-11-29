package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewTransactionPage {
    public static AndroidDriver driver;

    public NewTransactionPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="org.totschnig.myexpenses:id/CREATE_COMMAND")
    public WebElement newTransButton;

    @AndroidFindBy(id="org.totschnig.myexpenses:id/Account")
    public WebElement accountName;

    @AndroidFindBy(className = "android.widget.TextView")
    public List<WebElement> accountSelect;

    @AndroidFindBy(id="org.totschnig.myexpenses:id/TaType")
    public WebElement addRemove;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/AmountEditText")
    public WebElement amount;

    @AndroidFindBy(id="org.totschnig.myexpenses:id/Payee")
    public WebElement payer;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/SAVE_AND_NEW_COMMAND")
    public WebElement saveNew;

    //calendar
    @AndroidFindBy(id = "org.totschnig.myexpenses:id/DateButton")
    public WebElement calendarButton;

    @AndroidFindBy(className = "android.view.View")
    public List<WebElement> pickDay;

    @AndroidFindBy(id="android:id/prev")
    public WebElement prevMonth;

    @AndroidFindBy(id="android:id/next")
    public WebElement nextMonth;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement calendarOk;

    //watch
    @AndroidFindBy(id="org.totschnig.myexpenses:id/TimeButton")
    public WebElement clockButton;

    @AndroidFindBy(className = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    public List<WebElement> hours;

    @AndroidFindBy(className = "android.widget.RadialTimePickerView$RadialPickerTouchHelper" )
    public List<WebElement> minutes;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement watchOk;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/snackbar_text")
    public WebElement assertMes;






}
