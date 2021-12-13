package po;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YahooLoginPage extends BasePage {

    private final WebDriver webDriver;

    public YahooLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final String LOGIN_PAGE_URL = "https://mail.yahoo.com/";
    private final By buttonAccount = By.xpath("//input[contains(@id, 'login-signin')]");
    private final By buttonPassword = By.xpath("//button[@type='submit']");
    private final By hideButton = By.xpath("//button[contains(@class, 'show')]");
    private final By secondEmail = By.xpath("//div//ul//li[2][contains(@role, 'list-item')]");
    private final By titleOfEmail = By.xpath("//span[contains(@data-test-id, 'message-group-subject-text')]");

    static Logger log = Logger.getLogger(YahooLoginPage.class);

    public void navigateTo() {
        webDriver.navigate().to(LOGIN_PAGE_URL);
    }

    private void inputUserAccount() {
        String address = "robertbadaluta@yahoo.com";
        WebElement findAccount = webDriver.findElement(By.xpath("//input[contains(@class, 'phone-no')]"));
        findAccount.click();
        findAccount.sendKeys(address);
        webDriver.findElement(buttonAccount).click();
    }

    private void inputUserPassword() {
        String password = "Robyyy2001";
        clickWhenReady(webDriver, hideButton);
        WebElement findPassword = webDriver.findElement(By.xpath("//input[contains(@class, 'password')]"));
        findPassword.click();
        findPassword.sendKeys(password);
        webDriver.findElement(buttonPassword).click();
    }

    public void loginToYahoo() {
        inputUserAccount();
        inputUserPassword();
    }

    public void selectEmail() {
        clickWhenReady(webDriver, secondEmail);
        System.out.println(webDriver.findElement(By.xpath("//span[contains(@data-test-id, 'message-group-subject-text')]")).getText());
       // log.info(titleOfEmail);
    }

    public int numberOfThreads() {
        return webDriver.findElements(By.xpath("//div//ul//li[contains(@class, 'm_Z12nDQf D_F ek_BB ir_0')]")).size();
    }

    public String timestampOfEmail() {
        return webDriver.findElement(By.xpath("//div[4][contains(@data-test-id, 'message-date')]")).getText();
    }

}
