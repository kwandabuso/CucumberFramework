package FrontendAutomation.Steps;

import Engine.Engine;
import Engine.FunctionLibrary;
import Engine.PageElements;
import Engine.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class AddNewUser extends FunctionLibrary {

    PageElements elements = new PageElements();
    ReadConfig conf = new ReadConfig();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
    LocalDateTime now = LocalDateTime.now();
     Engine engine = new Engine();
    String email;
        @Given("I am on the wayautomation page")
        public void iAmOnTheWayautomationPage() {
            assertTrue(iselementDisplayedByXpath(elements.tblUsers()));

        }

        @When("click the add new user button")
        public void clickTheAddNewUserButton() {
            assertTrue(clickElementbyXpath(elements.btnAddUser()));
        }

        @Then("new modal window is displayed")
        public void newModalWindowIsDisplayed() {
            assertTrue(iselementDisplayedByXpath(elements.mdlAddUser()));

        }


        @Given("I enter all the required info")
        public void iEnterAllTheRequiredInfo() {


            email =  engine.getTestData("email") +dtf.format(now) +"@insp.com";
            email = email.replaceAll("\\s", "");

            if(!enterTextbyName(elements.txtFirstName(), engine.getTestData("firstName")))
            {
                logger.info("failed to enter first name");
                Assert.assertTrue(false, "Failed to enter first name");
            }

            if(!enterTextbyName(elements.txtLastName(), engine.getTestData("lastName")))
            {
                logger.info("failed to enter last name");
                Assert.assertTrue(false, "Failed to enter last name");
            }

            if(!enterTextbyName(elements.txtUserName(), engine.getTestData("userName")))
            {
                logger.info("failed to enter user name");
                Assert.assertTrue(false, "Failed to enter username");
            }

            if(!enterTextbyName(elements.txtPassword(), engine.getTestData("password")))
            {
                logger.info("failed to enter password");
                Assert.assertTrue(false, "Failed to enter password");
            }



            if(engine.getTestData("company").equalsIgnoreCase("AAA"))
            {

                if(!clickElementbyXpath(elements.rdoCompanyAAA()))
                {
                    logger.info("failed to click company AAA");
                    Assert.assertTrue(false, "failed to click company AAA");
                }
            }else
            {
                if(!clickElementbyXpath(elements.rdoCompanyBBB()))
                {
                    logger.info("failed to click company BBB");
                    Assert.assertTrue(false, "failed to click company BBB");
                }


            }


            if(!selectFromDropdownByName(elements.selRoleId(), engine.getTestData("roleId")))
            {
                logger.info("failed to select role");
                Assert.assertTrue(false, "Failed to select role");
            }
            if(!enterTextbyName(elements.txtEmail(),email))
            {
                logger.info("Failed to enter email");
                Assert.assertTrue(false, "Failed to enter email");
            }
            if(!enterTextbyName(elements.txtMobilePhone(), engine.getTestData("mobilePhone")))
            {
                logger.info("Failed to enter mobile number");
                Assert.assertTrue(false, "Failed to enter mobile number");
            }


        }

        @When("I click on the Save button")
        public void iClickOnTheSaveButton() {
            assertTrue(clickElementbyXpath(elements.btnSave()));

        }

        @Then("The user is displayed on the grid")
        public void theUserIsDisplayedOnTheGrid() throws IOException {


            captureScreen("new user captured"+ dtf.format(now));
            assertTrue(iselementDisplayedByXpath(elements.tdAddedEmail(email)));

        }
}
