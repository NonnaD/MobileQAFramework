package MyPatterns;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {

    //public static AppiumDriver driver;
    public static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver initializeDriver() throws IOException {

        Properties dataProp = new Properties();
        FileInputStream prop = new FileInputStream("/Users/nonna/Desktop/mvnp/projectName/src/main/resources/data.properties");
        dataProp.load(prop);


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, dataProp.getProperty("platformName"));
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, dataProp.getProperty("deviceName"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, dataProp.getProperty("platformVersion"));
        if(dataProp.getProperty("appORbrowser").equals("browser")){
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, dataProp.getProperty("browser"));
            //driver.get(dataProp.getProperty("WebURL"));
        }else if(dataProp.getProperty("appORbrowser").equals("app")) {
            if(dataProp.getProperty("apkORpackage").equals("apk")) {
                cap.setCapability(MobileCapabilityType.APP, dataProp.getProperty("app"));
            }else if (dataProp.getProperty("apkORpackage").equals("package")){
                cap.setCapability("appPackage", dataProp.getProperty("appPackage"));
               // cap.setCapability("appWaitPackage", "10");
                cap.setCapability("appActivity", dataProp.getProperty("appActivity"));
                //cap.setCapability("appWaitActivity", "10");
            }
        }


        URL local = new URL("http://127.0.0.1:4723/wd/hub");


        try {
            if (dataProp.getProperty("platformName").equals("Android")) {
              driver = new AndroidDriver<AndroidElement>(local, cap);
            } else if (dataProp.getProperty("platformName").equals("IOS")) {
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                //driver = new IOSDriver<IOSElement>(local, cap);
            } else if (dataProp.getProperty("platformName").equals("Windows")) {
                //driver = new WindowsDriver<WindowsElement>(local, cap);
            } else {
                System.out.println("Unknown platform type, please check your properties file");
            }
        }catch(NullPointerException ex){
            System.out.println("Driver could not be initialized");
        }


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        return driver;




    }

    public void getScreenshot(String screenName) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/Users/nonna/Desktop/mvnp/projectName/screenshots" + screenName + ".png"));
    }


}

