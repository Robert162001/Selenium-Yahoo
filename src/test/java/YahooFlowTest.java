import org.testng.Assert;
import org.testng.annotations.Test;

public class YahooFlowTest extends BaseTest {

    @Test
    public void navigateToTest() {
        yahooFlow.navigateTo();
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("mail.yahoo.com"));
    }

    @Test
    public void sendAccountTest() {
        yahooFlow.navigateTo();
        yahooFlow.sendAccount();
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("login.yahoo.com"));
    }

    @Test
    public void sendPasswordTest() {
        String pageTitle = "Yahoo Mail";
        yahooFlow.navigateTo();
        yahooFlow.sendAccount();
        yahooFlow.sendPassword();
        Assert.assertTrue(getWebDriver().getTitle().contains(pageTitle));
    }
}
