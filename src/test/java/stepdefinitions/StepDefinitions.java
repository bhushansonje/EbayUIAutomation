package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.EbayHomePage;
import pageobjects.ItemListingPage;
import pageobjects.SearchResultsPage;
import utils.DriverManager;

public class StepDefinitions {
    private WebDriver driver;
    private EbayHomePage ebayHomePage;
    private SearchResultsPage searchResultsPage;
    private ItemListingPage itemListingPage;

    public StepDefinitions() {
        this.driver = DriverManager.getDriver();
        this.ebayHomePage = new EbayHomePage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
        this.itemListingPage = new ItemListingPage(driver);
    }

    @Given("^I am on the eBay home page$")
    public void iAmOnTheEbayHomePage() {
        Assert.assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay", driver.getTitle());
    }

    @When("^I search for a (.*)$")
    public void iSearchForAnItem(String item) {
        ebayHomePage.searchForItem(item);
    }

    @And("^I select the first item from the search results$")
    public void iSelectTheFirstItem() {
        searchResultsPage.selectFirstItem();
    }

    @And("^I add the item to the cart$")
    public void iAddTheItemToTheCart() {
        itemListingPage.addToCart();
    }

    @Then("^the cart count should be updated$")
    public void theCartCountShouldBeUpdated() {
        String cartCount = itemListingPage.getCartItemCount();
        Assert.assertTrue(Integer.parseInt(cartCount) > 0);
    }
}
