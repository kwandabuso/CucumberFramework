package FrontendAutomation.Steps.Steps;

import Engine.FunctionLibrary;
import Engine.PageElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyStepdefs extends FunctionLibrary
{
    PageElements elements = new PageElements();

    @Given("^I am on a login page$")
    public void iAmOnALoginPage() {
        assertTrue(setup());
        assertTrue(clickElementbyID(PageElements.btnLoginID()));
    }

    @When("^I enter the following details for credentials$")
    public void iEnterTheFollowingDetailsForCredentials() {
        assertTrue(enterTextbyID(PageElements.txtUsernameID(), "admin"));
        assertTrue(enterTextbyID(PageElements.txtPasswordID(), "password"));
    }

    @And("^I click a login button$")
    public void iClickALoginButton() {
        assertTrue(clickElementbyXpath(PageElements.btnLoginSubmitXpath()));
          }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() {
        //TODO: assert if true
        assertTrue(iselementDisplayedByXpath(elements.txtLogoutXpath()));

    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {

        assertEquals(getTitle(),"Home - Execute Automation Employee App");
    }

    @When("^I click on Employee List$")
    public void iClickOnEmployeeList() {
        assertTrue(clickElementbyXpath(PageElements.lnkEmployeeListXpath()));
    }

    @Then("^A list of employees is displayed$")
    public void aListOfEmployeesIsDisplayed() {
        //TODO: assert if table of employees is displayed
        assertTrue(iselementDisplayedByXpath(elements.tblEmployeeListXpath()));
    }

    @Given("^I am on the employee list page$")
    public void iAmOnTheEmployeeListPage() {
        assertEquals(getTitle(),"- Execute Automation Employee App");
        //TODO: assert if title is  "- Execute Automation Employee App";
    }

    @When("^I click the add new button$")
    public void iClickTheAddNewButton() {
        assertTrue(clickElementbyXpath(PageElements.btnCreateNewXpath()));
    }



    @And("^I enter all the field details$")
    public void iEnterAllTheFieldDetails() {
        assertTrue(enterTextbyID(PageElements.txtNameID(), "admin"));
        assertTrue(enterTextbyID(PageElements.txtSalaryID(), "25000"));
        assertTrue(enterTextbyID(PageElements.txtDurationWorkedID(), "1"));

        assertTrue(enterTextbyID(PageElements.txtGradeID(),"5"));
        assertTrue(enterTextbyID(PageElements.txtEmailID(), "test@auto.com"));
    }

    @And("^I click the create button$")
    public void iClickTheCreateButton() {

        assertTrue(clickElementbyXpath(PageElements.btnCreateXpath()));

    }

    @Then("^A new employee is displayed on the list$")
    public void aNewEmployeeIsDisplayedOnTheList() {
        assertTrue(iselementDisplayedByXpath(PageElements.newEmployeeByXpath("test@auto.com")));

    }

}
