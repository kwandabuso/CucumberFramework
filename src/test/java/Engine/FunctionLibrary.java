package Engine;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionLibrary {
    WebDriver driver = null;
    public static Logger logger;
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

    public boolean Mobilesetup() throws MalformedURLException {
        try
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("deviceName","Android Emulator");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("appPackage","com.instantappsample.uamp");
            capabilities.setCapability("appActivity","com.example.android.uamp.ui.MusicPlayerActivity");
            capabilities.setCapability("automationName","Appium");

            String url = "http://0.0.0.0:4723/wd/hub";
            androidDriver = new AndroidDriver(new URL(url), capabilities);
            System.out.println("application started....");
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return false;
        }

    }

    public String getTitle()
    {

        return GlobalVariables.driver.getTitle().trim();
    }

    public void waitForPageLoad() {

        new WebDriverWait(GlobalVariables.driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public Boolean waitforElementTobeDisplayedByID(String elementID) {
        try {
            new WebDriverWait(GlobalVariables.driver, 15).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            for (int i = 0; i < 10; i++) {
                GlobalVariables.driver.wait(1000);
                var element = GlobalVariables.driver.findElement(By.id(elementID));

                if (element.isDisplayed() && element.isEnabled())
                    return true;

                GlobalVariables.driver.wait(1000);
            }

        } catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());

        }
        return false;
    }

    public Boolean waitforElementTobeDisplayed(String elementXpath) {
        try {
            new WebDriverWait(GlobalVariables.driver, 15).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            for (int i = 0; i < 10; i++) {
                GlobalVariables.driver.wait(2000);
                var element = driver.findElement(By.xpath(elementXpath));

                if (element.isDisplayed() && element.isEnabled())
                    return true;

                GlobalVariables.driver.wait(1000);
            }

        } catch (Exception ex) {


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
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());

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
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return false;
        }
    }

    public boolean selectFromDropdownByName(String elementName, String text)
    {
        try{
            waitforElementTobeDisplayed(elementName);
            Select drpCountry = new Select( GlobalVariables.driver.findElement(By.name(elementName)));
            drpCountry.selectByVisibleText(text);

            return true;

        }
        catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return false;
        }
    }


    public boolean enterTextbyName(String elementName, String text)
    {
        try{

            waitforElementTobeDisplayedByID(elementName);
            var element = GlobalVariables.driver.findElement(By.name(elementName));
            element.clear();
            element.sendKeys(text);
            return true;

        }
        catch (Exception ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
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
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            return false;
        }
    }


    public void captureScreen(String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) GlobalVariables.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public void regex()
    {
        Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools!");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
