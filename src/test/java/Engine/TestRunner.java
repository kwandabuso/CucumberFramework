package Engine;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/java/FrontendAutomation/Features"},
        glue = {"FrontendAutomation"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
        WebDriver driver = null;

        @BeforeClass
        public Boolean setup()
        {

                try{
                        var workingDirectory = System.getProperty("user.dir");
                        //System.setProperty("webdriver.chrome.driver",workingDirectory+"\\chromedriver\\chromedriver.exe");
                        ReadConfig conf = new ReadConfig();
                        Logger logger  = Logger.getLogger("testing");
                        PropertyConfigurator.configure("Log4j.properties");

                        /*System.setProperty("webdriver.chrome.driver",workingDirectory+"\\chromedriver\\chromedriver.exe");

                        driver = new ChromeDriver();*/
                        if(conf.getBrowser().equals("chrome"))
                        {
                                System.setProperty("webdriver.chrome.driver", workingDirectory+"\\chromedriver\\chromedriver.exe");
                                driver = new ChromeDriver();

                        }
                        else if(conf.getBrowser().equals("firefox"))
                        {
                                System.setProperty("webdriver.chrome.driver", workingDirectory+"\\Drivers\\geckodriver.exe");
                                driver = new FirefoxDriver();
                        }
                        else {
                                System.setProperty("webdriver.chrome.driver", workingDirectory+"\\Drivers\\IEDriverServer.exe");
                                driver = new InternetExplorerDriver();
                        }
                        driver.get(conf.getApplicationURL());
                        driver.manage().window().maximize();


                        /*var workingDirectory = System.getProperty("user.dir");
                        System.setProperty("webdriver.chrome.driver",workingDirectory+"\\chromedriver\\chromedriver.exe");

                        driver = new ChromeDriver();


                        String baseUrl = "https://www.saucedemo.com/";
                        String expectedTitle = "Swag Labs";
                        String actualTitle = "";
                        // launch Fire fox and direct it to the Base URL
                        driver.manage().window().maximize();
                        driver.get(baseUrl);
                        */

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
        @AfterClass
        public void tearDown() {
                driver.quit();

        }
}