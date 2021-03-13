package FrontendAutomation.Steps;

import Engine.Engine;
import Engine.FunctionLibrary;
import Engine.PageElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Checkout extends FunctionLibrary
{
    PageElements elements = new PageElements();
    Engine engine = new Engine();
    @Given("I am on the sauce demo products page")
    public void iAmOnTheSauceDemoProductsPage() {
        assertTrue(iselementDisplayedByXpath(elements.hdrProductsXpath()));
    }

    @When("I select an item")
    public void iSelectAnItem() {
        assertTrue(clickElementbyXpath(PageElements.btnAddToCartXpath()));
    }

    @Then("the Item must be added to the cart")
    public void theItemMustBeAddedToTheCart() {
        assertTrue(iselementDisplayedByXpath(elements.CartItemsXpath()));

    }

    @When("I click on the cart icon")
    public void iClickOnTheCartIcon() {
        assertTrue(clickElementbyXpath(PageElements.btnCartXpath()));

    }

    @Then("the cart is displayed")
    public void theCartIsDisplayed() {
        assertTrue(iselementDisplayedByXpath(elements.lblInventoryItemPriceXpath()));

    }

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        assertTrue(iselementDisplayedByXpath(elements.lblInventoryItemPriceXpath()));

    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        assertTrue(clickElementbyXpath(PageElements.btnCheckoutXpath()));

    }

    @Then("your information page is displayed")
    public void yourInformationPageIsDisplayed() {
    }

    @Given("I am on the your information page")
    public void iAmOnTheYourInformationPage() {
    }

    @When("I enter all the fields")
    public void iEnterAllTheFields() {
        assertTrue(enterTextbyID(PageElements.txtNameID(),"Kwanda"));
        assertTrue(enterTextbyID(PageElements.txtLastNameID(),"Buso"));
        assertTrue(enterTextbyID(PageElements.txtPostalCode(),"4960"));

    }

    @And("click on the continue button")
    public void clickOnTheContinueButton() {
        assertTrue(clickElementbyXpath(PageElements.btnContinueXpath()));

    }

    @Then("Checkout Overview page is displayed")
    public void checkoutOverviewPageIsDisplayed() {
        assertTrue(iselementDisplayedByXpath(elements.lstCartItemXpath()));

    }

    @Given("I am on the overview page")
    public void iAmOnTheOverviewPage() {
    }

    @When("I click on the Finish Page")
    public void iClickOnTheFinishPage() {
        assertTrue(clickElementbyXpath(PageElements.btnFinishXpath()));

    }

    @Then("My order must be placed")
    public void myOrderMustBePlaced() {
        assertTrue(iselementDisplayedByXpath(elements.imgPonyExpressXpath()));
    }
}
