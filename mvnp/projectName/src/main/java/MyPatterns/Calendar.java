package MyPatterns;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Calendar {

    public void calendar( String day, List<WebElement> dayPick) {
        for (int i = 0; i < dayPick.size(); i++) {
            if (dayPick.get(i).getText().equals(day)){
                dayPick.get(i).click();
                break;
            }


        }
    }
}
