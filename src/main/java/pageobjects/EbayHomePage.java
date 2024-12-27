package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHomePage extends EbayBasePage{
    private WebDriver driver;
    private By searchBox = By.id("gh-ac");
    private By searchButton = By.id("gh-btn");

    public EbayHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForItem(String itemName) {
        sendText(driver,
                searchBox,
                itemName);
        clickOnElement(driver,searchButton);
    }
}