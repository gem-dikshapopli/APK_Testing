package implementation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestMobile {
    public static AppiumDriver driver;


    public static void openApplication() throws MalformedURLException {
        //setting desired capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Diksha.Popli\\Downloads\\api_Demos.apk");

        //url for application
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, cap);
    }


    public static void signUp() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("io.perfecto.expense.tracker:id/login_signup_btn").click();
        driver.findElementById("io.perfecto.expense.tracker:id/signup_name").sendKeys("Diksha");
        driver.findElementById("io.perfecto.expense.tracker:id/signup_email").sendKeys("dikshpopli@gmail.com");
        driver.findElementById("io.perfecto.expense.tracker:id/signup_password").sendKeys("123456");
        driver.findElementById("io.perfecto.expense.tracker:id/signup_confirm_password").sendKeys("123456");
        driver.findElementById("io.perfecto.expense.tracker:id/signup_currency").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]").click();
        driver.findElementById("io.perfecto.expense.tracker:id/signup_save_btn").click();
    }

    public static void logIn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("io.perfecto.expense.tracker:id/login_email").sendKeys("dikshpopli@gmail.com");
        driver.findElementById("io.perfecto.expense.tracker:id/login_password").sendKeys("123456");
        driver.findElementById("io.perfecto.expense.tracker:id/login_login_btn").click();
    }


    public static void addExpenses(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElementById("io.perfecto.expense.tracker:id/list_add_btn").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]").click();
        WebElement element=driver.findElementById("io.perfecto.expense.tracker:id/amount_seek_bar");
        TouchAction action=new TouchAction<>((MobileDriver)driver);
        action.longPress(ElementOption.element(element)).moveTo(ElementOption.element(element,550,550)).release().perform();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]").click();
        driver.findElementById("io.perfecto.expense.tracker:id/add_date").click();
        driver.findElementByXPath("//android.view.View[@content-desc=\"11 August 2023\"]").click();
        driver.findElementById("android:id/button1").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]").click();
        driver.findElementById("io.perfecto.expense.tracker:id/add_save_btn").click();

    }
}
