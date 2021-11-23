import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import po.YahooFlow;

public class BaseTest {
    private WebDriver webDriver;
    protected YahooFlow yahooFlow;

    protected WebDriver getWebDriver() {
        return this.webDriver;
    }

    @BeforeMethod
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        //chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        yahooFlow = new YahooFlow(webDriver);
    }

    //   @AfterMethod
//    public void closeDriver() {
//       webDriver.quit();
//    }
}
