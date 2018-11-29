package MyPatterns;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Watch {
    public void watch(String hour, String minute, List<WebElement> hours, List<WebElement> minutes ){
        System.out.println(hours.size());

        for(int i = 0; i < hours.size(); i++){
            if(hours.get(i).getText().equals(hour)){
                hours.get(i).click();
                break;
            }
        }



        for (int n = 0; n < minutes.size(); n++){
            if(minutes.get(n).getText().equals(minute)){
                minutes.get(n).click();
                break;
            }
        }

    }
}
