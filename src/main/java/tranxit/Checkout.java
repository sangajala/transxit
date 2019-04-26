package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Checkout extends BasePage{


    public Checkout(WebDriver browser) {
        super(browser);
    }

//    locators

    @FindBy(how= How.ID,using="discountcouponcode")
    public WebElement discountcouponcode;

    @FindBy(how= How.ID,using="applydiscountcouponcode")
    public WebElement applydiscountcouponcode;

    @FindBy(how=How.XPATH,using="//test")
    public WebElement test;


//    ------------------------



    public void applyDiscountCode(String code){
        discountcouponcode.sendKeys(code);
        applydiscountcouponcode.click();
    }


}
