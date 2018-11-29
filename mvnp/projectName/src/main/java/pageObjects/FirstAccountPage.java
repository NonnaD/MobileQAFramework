package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FirstAccountPage {
    public AppiumDriver driver;

    public FirstAccountPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "org.totschnig.myexpenses:id/Label")
    public WebElement accountName;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/AmountEditText")
    public WebElement openingBalance;

    @AndroidFindBy(id="org.totschnig.myexpenses:id/Currency")
    public WebElement currencyButton;

    @AndroidFindBy(className="android.widget.TextView")
    public List<WebElement> currency;

    @AndroidFindBy(id="org.totschnig.myexpenses:id/MoreOptionsButton")
    public WebElement moreOptions;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/Description")
    public WebElement description;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/AccountType")
    public WebElement cashAccount;

    @AndroidFindBy(className = "android.widget.TextView")
    public List<WebElement> selectCahsAccount;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/ColorIndicator")
    public WebElement color;

    @AndroidFindBy(className = "android.widget.FrameLayout")
    public List<WebElement> colors;

    @AndroidFindBy(id = "org.totschnig.myexpenses:id/suw_navbar_done")
    public WebElement getStarted;




}
