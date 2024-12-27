package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class EbayBasePage {

    public void clickOnElement(WebDriver driver, By by) {
        driver.findElement(by).click();
    }

    public void sendText(WebDriver driver, By by, String itemName) {
        driver.findElement(by).sendKeys(itemName);
    }

    public String getString(WebDriver driver, By by) {
        return driver.findElement(by).getText();
    }

    public String getCurrentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public void switchToChildWindow(WebDriver driver, String currentWindow) {
        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {
                switchToWindow(driver, window);

            }
        }
    }

    public void switchToWindow(WebDriver driver, String window) {
        driver.switchTo().window(window);
    }


}
