package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageOLD extends BasePage {

    public Utility utility;
    @FindBy(how = How.TAG_NAME, using = "body")
    public WebElement body;


    public HomePageOLD(WebDriver browser) {
        super(browser);
        utility = new Utility(browser);
    }


    public void goToHomePage() {
        browser.get("http://demo.nopcommerce.com");
        checkUserIsInHomePage();
    }

    public void checkUserIsInHomePage() {
        Assert.assertTrue(body.getText().contains("Welcome to our store"));
    }

    public void selectFirstItem() {
        utility.clickOnButton("Add to cart");
    }

    public void gotoShoppingCart() {
        browser.get("http://demo.nopcommerce.com/cart");
    }

    public void gotoLoginPage(){
        browser.findElement(By.linkText("Log in")).click();
    }
}
