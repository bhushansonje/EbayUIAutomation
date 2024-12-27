package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SearchResultsPage extends EbayBasePage {
    private WebDriver driver;
    private By addToCard = By.xpath("//span[text()='Add to cart']");

    private By firstItem = By.xpath("//div[@class='srp-river-results clearfix']//ul//li[2]//a[@class='s-item__link']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstItem() {
        clickOnElement(driver, firstItem);
        String currentWindow = getCurrentWindow(driver);
        switchToChildWindow(driver, currentWindow);


    }
}