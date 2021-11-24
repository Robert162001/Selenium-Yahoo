package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YahooFlow extends BasePage {

    private final WebDriver webDriver;

    public YahooFlow(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final String YAHOO_URL = "https://mail.yahoo.com/";
    private final By buttonAccount = By.xpath("//input[contains(@id, 'login-signin')]");
    private final By buttonPassword = By.xpath("//button[@type='submit']");
    private final By hideButton = By.xpath("//button[contains(@class, 'show')]");

    public void navigateTo() {
        webDriver.navigate().to(YAHOO_URL);
    }

    public void sendAccount() {
        String address = "robertbadaluta@yahoo.com";
        WebElement findAccount = webDriver.findElement(By.xpath("//input[contains(@class, 'phone-no')]"));
        findAccount.click();
        findAccount.sendKeys(address);
        webDriver.findElement(buttonAccount).click();
    }

    public void sendPassword() {
        String password = "Robyyy2001";
        clickWhenReady(webDriver, hideButton);
        WebElement findPassword = webDriver.findElement(By.xpath("//input[contains(@class, 'password')]"));
        findPassword.click();
        findPassword.sendKeys(password);
        webDriver.findElement(buttonPassword).click();
    }

}
