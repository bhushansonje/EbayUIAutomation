package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemListingPage extends EbayBasePage{
    private WebDriver driver;
    private By addToCartButton = By.xpath("//span[text()='Add to cart']");
    private By cartCount = By.cssSelector("#gh-cart-n");

    public ItemListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        clickOnElement(driver,addToCartButton);
    }

    public String getCartItemCount() {
        return getString(driver,cartCount);
    }
}