package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage{
    Utility utility;
    @FindBy(how = How.ID,using = "product_attribute_3")
    public WebElement product_3;

    public ProductPage(WebDriver browser) {
        super(browser);
        utility = new Utility(browser);
    }

    public void selectHDDAndAddTocart(){
        browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if(product_3.isDisplayed()){
            product_3.click();
        }

        utility.clickOnButton("Add to cart");
        utility.waitFor1Sec();

    }
}
