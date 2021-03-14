package MobileAutomation.MobileStepDefinations;

import Engine.FunctionLibrary;
import Engine.PageElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class MyStepdefs extends FunctionLibrary
{

    PageElements elements = new PageElements();

    @Given("I am on the uamp application")
    public void iAmOnMyPhone() throws MalformedURLException {
        assertTrue(Mobilesetup());
    }

    @Then("then albums must be displayed")
    public void thenAlbumsMustBeDisplayed() {
        assertTrue(mobiIsElementDisplayedByID(elements.jazzAndBluesXpath()));

    }


    @When("I click on jazz and blues")
    public void iClickOnJazzAndBlues() {

        assertTrue(mobiClickElementByXpath(elements.jazzAndBluesXpath()));
    }

    @And("I select A song")
    public void iSelectASong() {

        assertTrue(mobiClickElementByXpath(elements.songXpath()));
    }

    @Then("the selected song must play")
    public void theSelectedSongMustPlay() {
        assertTrue(mobiIsElementDisplayedByID(elements.playingSongID()));

    }


    @Given("I am on the genres menu")
    public void iAmOnTheGenresMenu() {

    }

    @When("I click on genres")
    public void iClickOnGenres() {
        assertTrue(mobiClickElementByXpath(elements.genresAccessXpath()));
    }

    @Then("then a list of available genres is displayed")
    public void thenAListOfAvailableGenresIsDisplayed() {
        assertTrue(mobiIsElementDisplayedByID(elements.genresListID()));
    }
}
