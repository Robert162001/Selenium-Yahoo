package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected void clickWhenReady(WebDriver webDriver, By locator) {
        WebElement webElement = new WebDriverWait(webDriver, 10000).until(ExpectedConditions.elementToBeClickable((locator)));
        webElement.click();
    }
}