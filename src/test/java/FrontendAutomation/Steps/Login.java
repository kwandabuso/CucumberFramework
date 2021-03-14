package FrontendAutomation.Steps;

import Engine.Engine;
import Engine.FunctionLibrary;
import Engine.PageElements;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login extends FunctionLibrary
{
    PageElements elements = new PageElements();
    Engine engine = new Engine();

    @Given("I am on the sauce demo login page")
    public void iAmOnTheSauceDemoLoginPage() {

        assertEquals(getTitle(),"Swag Labs");
    }

    @When("click the login button")
    public void clickTheLoginButton() {
        assertTrue(clickElementbyID(PageElements.btnLoginID()));
    }

    @Then("an error message must be displayed")
    public void anErrorMessageMustBeDisplayed() {
        assertTrue(iselementDisplayedByXpath(elements.lblErrorXpath()));
    }

    @When("I enter the username")
    public void iEnterTheUsername() throws IOException {
        assertTrue(enterTextbyID(PageElements.txtUsernameID(), engine.readFromExcel("username")));

    }

    @When("I enter the password")
    public void iEnterThePassword() throws IOException {
        assertTrue(enterTextbyID(PageElements.txtPasswordID(), engine.readFromExcel("password")));
    }

    @Then("I must be logged in")
    public void iMustBeLoggedIn() {
        assertTrue(iselementDisplayedByXpath(elements.hdrProductsXpath()));

    }

    @When("I enter a valid username and an invalid password")
    public void iEnterAValidUsernameAndAnInvalidPassword() throws IOException {
        assertTrue(enterTextbyID(PageElements.txtUsernameID(), engine.readFromExcel("username")));
        assertTrue(enterTextbyID(PageElements.txtPasswordID(), engine.readFromExcel("InvalidPassword")));
    }

    @When("I enter an invalid username and a valid password")
    public void iEnterAnInvalidUsernameAndAValidPassword() throws IOException {
        assertTrue(enterTextbyID(PageElements.txtUsernameID(), engine.readFromExcel("InvalidUserName")));
        assertTrue(enterTextbyID(PageElements.txtPasswordID(), engine.readFromExcel("password")));
    }

    @When("I enter a valid password and a valid username")
    public void iEnterAValidPasswordAndAValidUsername() throws IOException {
        assertTrue(enterTextbyID(PageElements.txtUsernameID(), engine.readFromExcel("username")));
        assertTrue(enterTextbyID(PageElements.txtPasswordID(), engine.readFromExcel("password")));
    }

}
