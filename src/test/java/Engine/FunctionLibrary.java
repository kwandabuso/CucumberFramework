package Engine;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class FunctionLibrary {
    WebDriver driver = null;
    static AndroidDriver androidDriver;


    public Boolean setup()
    {
        try{

            var workingDirectory = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver",workingDirectory+"\\chromedriver\\chromedriver.exe");

            driver = new ChromeDriver();


            String baseUrl = "https://www.saucedemo.com/";
            String expectedTitle = "Swag Labs";
            String actualTitle = "";
            // launch Fire fox and direct it to the Base URL
            driver.manage().window().maximize();
            driver.get(baseUrl);
            GlobalVariables.driver = driver;

            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return false;
    }

    public void Mobilesetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.example.android.uamp.next");
        capabilities.setCapability("appActivity","com.example.android.uamp.MainActivity");
        capabilities.setCapability("automationName","Appium");

        String url = "http://0.0.0.0:4723/wd/hub";
        androidDriver = new AndroidDriver(new URL(url), capabilities);
        System.out.println("application started....");
    }

    public String getTitle()
    {

       return GlobalVariables.driver.getTitle().trim();
    }

    public Boolean waitforElementTobeDisplayedByID(String elementID) {
        try {

            for (int i = 0; i < 10; i++) {

                var element = GlobalVariables.driver.findElement(By.id(elementID));

                if (element.isDisplayed())
                    return true;

                GlobalVariables.driver.wait(1000);
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
        return false;
    }

    public Boolean waitforElementTobeDisplayed(String elementXpath) {
        try {
            new WebDriverWait(GlobalVariables.driver, 15).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            var element = driver.findElement(By.xpath(elementXpath));

            if (element.isDisplayed())
                return true;

            GlobalVariables.driver.wait(1000);


        } catch (Exception ex) {
            System.out.println(ex);

        }
        return false;
    }

    public Boolean iselementDisplayedByXpath(String elementXpath) {
            try {

                waitforElementTobeDisplayed(elementXpath);
                var element = GlobalVariables.driver.findElement(By.xpath(elementXpath));

                if (element.isDisplayed())
                    return true;

            } catch (Exception ex) {
                System.out.println(ex);

            }
            return false;
        }

    public boolean enterTextbyXpath(String elementXpath, String text)
    {
        try{
            waitforElementTobeDisplayed(elementXpath);
            var element = GlobalVariables.driver.findElement(By.xpath(elementXpath));
            element.sendKeys(text);
            return true;

        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean enterTextbyID(String elementID, String text)
    {
        try{
            waitforElementTobeDisplayedByID(elementID);
            var element = GlobalVariables.driver.findElement(By.id(elementID));
            element.clear();
            element.sendKeys(text);
            return true;

        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean clickElementbyXpath(String elementXpath)
    {
        try{
            waitforElementTobeDisplayed(elementXpath);
            var element = GlobalVariables.driver.findElement(By.xpath(elementXpath));
            element.click();
            return true;

        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean clickElementbyID(String elementID)
    {
        try{
            waitforElementTobeDisplayedByID(elementID);
            var element = GlobalVariables.driver.findElement(By.id(elementID));
            element.click();
            return true;

        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static void mobiClickElementByID(String element)
    {
        try
        {

            MobileElement permision = (MobileElement) androidDriver.findElementById(element);

            if(permision.isDisplayed() && permision.isEnabled())
            {

                permision.click();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());

        }
    }

    public static void mobiClickElementByXpath(String element)
    {
        try
        {
            mobiWaitForElementToBeDisplayedByXpath(element);

            MobileElement myElement = (MobileElement) androidDriver.findElementByXPath(element);

            if(myElement.isDisplayed() && myElement.isEnabled())
            {

                myElement.click();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());

        }
    }

    public static Boolean mobiIsElementDisplayedByID(String myElement)
    {
        try
        {

            MobileElement element = (MobileElement) androidDriver.findElementByXPath(myElement);
            Thread.sleep(2000);
            if(element.isDisplayed()) {
                return true;
            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());

        }
        return false;
    }

    public static void mobiWaitForElementToBeDisplayedByXpath(String myElement)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(androidDriver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(myElement)));// instead of id u can use cssSelector or xpath of ur element.

            MobileElement element = (MobileElement) androidDriver.findElementByXPath(myElement);
            Thread.sleep(2000);
            if(!element.isDisplayed());
            {
                for(int i =0; i < 5; i++)
                {
                    Thread.sleep(2000);
                    element = (MobileElement) androidDriver.findElementByXPath(myElement);

                    if(element.isDisplayed())
                    {
                        break;
                    }
                }

            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());

        }
    }

}
