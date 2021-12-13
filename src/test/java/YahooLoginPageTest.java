import org.testng.Assert;
import org.testng.annotations.Test;

public class YahooLoginPageTest extends BaseTest {

    @Test
    public void loginToYahooTest() {
        String pageTitle = "Yahoo Mail";
        yahooLoginPage.navigateTo();
        yahooLoginPage.loginToYahoo();
        Assert.assertTrue(getWebDriver().getTitle().contains(pageTitle));
    }

    @Test
    public void numberOfThreadsTest() {
        yahooLoginPage.navigateTo();
        yahooLoginPage.loginToYahoo();
        yahooLoginPage.selectEmail();
        int actual = yahooLoginPage.numberOfThreads();
        int expected = 3;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void timestampOfEmailTest() {
        yahooLoginPage.navigateTo();
        yahooLoginPage.loginToYahoo();
        yahooLoginPage.selectEmail();
        String actual = yahooLoginPage.timestampOfEmail();
        String expected = "Thu, Nov 25 at 6:33 PM";
        Assert.assertEquals(expected, actual);
    }

}
