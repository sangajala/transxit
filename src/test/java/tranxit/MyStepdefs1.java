package tranxit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyStepdefs1 {




    HomePageOLD homePage;
    ProductPage productPage;
    Checkout checkout;
    LoginPage loginPage;
    HomePage h;
    SearchPage searchPage;
    static WebDriver browser;



    @Before
    public void testtetsetet() {

        browser = BrowserFactory.getBrowser();
        browser.get("http://demo.nopcommerce.com");
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void afterTest(Scenario scenario){
//        if(scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES), "image/png");
//        }
    }




    @Then("^he should see a welcome message$")
    public void heShouldSeeAWelcomeMessage() {

        homePage.checkUserIsInHomePage();
    }



    @Given("^user is in login page$")
    public void userIsInLoginPage() {
        h = new HomePage(browser);
        h.gotoLoginPage();

    }

    @Given("^us enters user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void usEntersUserNameAsAndPasswordAs(String username, String password) throws Throwable {

        loginPage = new LoginPage(browser);
        loginPage.login(username,password);


    }

    @And("^try to login$")
    public void tryToLogin() {
        browser.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).click();

    }

    @Then("^he should be successfully login$")
    public void heShouldBeSuccessfullyLogin() {
        Assert.assertTrue(loginPage.isUserLogged());
    }


    @Then("^he should be not be login$")
    public void heShouldBeNotBeLogin() {
        Assert.assertFalse(loginPage.isUserLogged());
    }

    @And("^logout from the system$")
    public void logoutFromTheSystem() {
        h.logout();
    }

    @When("^he open the \"([^\"]*)\" link$")
    public void heOpenTheLink(String linkFromFeatureFile) throws Throwable {
        browser.findElement(By.linkText(linkFromFeatureFile)).click();
    }

    @Then("^the page in new TAB should be open with text \"([^\"]*)\"$")
    public void thePageInNewTABShouldBeOpenWithText(String text) throws Throwable {
        Set<String> windowList = browser.getWindowHandles();
        System.out.println(windowList);
        Object[] arrayList = windowList.toArray();
        browser.switchTo().window(arrayList[1].toString());
        browser.navigate().refresh();
        String textInBrowser = browser.findElement(By.tagName("body")).getText();
        browser.switchTo().defaultContent();
        Assert.assertTrue(textInBrowser.contains(text));

    }

    @When("^he open the Footer link \"([^\"]*)\"$")
    public void heOpenTheFooterLink(String linkFromFeatureFile) throws Throwable {
        browser.findElement(By.linkText(linkFromFeatureFile)).click();
    }

    @Then("^the page should be open with text \"([^\"]*)\"$")
    public void thePageShouldBeOpenWithText(String text) throws Throwable {
        String textInBrowser = browser.findElement(By.tagName("body")).getText();
        browser.navigate().back();

        Assert.assertTrue(textInBrowser.contains(text));
    }


    @When("^search with keyword \"([^\"]*)\"$")
    public void searchWithKeyword(String key) throws Throwable {

        h.gotoSearchPageWithKey(key);


    }

    @Then("^he should see atleast one result$")
    public void heShouldSeeAtleastOneResult() {
       searchPage = new SearchPage(browser);
       Assert.assertTrue(searchPage.isResultShown());
    }

    @Then("^he should see a message \"([^\"]*)\"$")
    public void heShouldSeeAMessage(String expectedMessage) throws Throwable {
        String actualMessage = browser.findElement(By.className("search-results")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Given("^he go to search page$")
    public void heGoToSearchPage() {
        browser.get("http://demo.nopcommerce.com/search");
    }

    @When("^add default item to basket$")
    public void addDefaultItemToBasket() {

        homePage.selectFirstItem();

        productPage = new ProductPage(browser);
        productPage.selectHDDAndAddTocart();

    }



    @And("^go to shopping cart$")
    public void goToShoppingCart() {

        homePage.gotoShoppingCart();
    }

    @And("^apply discount with code \"([^\"]*)\"$")
    public void applyDiscountWithCode(String code) throws Throwable {

        checkout = new Checkout(browser);
        checkout.applyDiscountCode(code);

    }

    @Then("^the success message should be shown \"([^\"]*)\"$")
    public void theSuccessMessageShouldBeShown(String expectedText) throws Throwable {

        Assert.assertTrue(verifyTextPresent(expectedText));

    }

    public boolean verifyTextPresent(String text){
        return browser.findElement(By.tagName("body")).getText().contains(text);
    }

    @Given("^I insert the data into the database$")
    public void iInsertTheDataIntoTheDatabase() {
        Utility utility = new Utility(browser);
        utility.insertData();
    }
}
