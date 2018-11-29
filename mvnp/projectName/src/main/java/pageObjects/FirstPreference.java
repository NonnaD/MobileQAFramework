package pageObjects;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstPreference {

    public AppiumDriver driver;

    public FirstPreference(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id="org.totschnig.myexpenses:id/theme")
    public WebElement themeButton;

    @AndroidFindBy(id ="org.totschnig.myexpenses:id/suw_navbar_next")
    public  WebElement nextButton;

    @AndroidFindBy(id="org.totschnig.myexpenses:id/suw_layout_title")
    public WebElement setUpMessage;







}
