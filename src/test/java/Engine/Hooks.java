package Engine;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    WebDriver driver = null;
    static AndroidDriver androidDriver;

    @BeforeClass
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
}
