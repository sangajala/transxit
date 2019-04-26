package tranxit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME,using ="product-item" )
    private WebElement result;

    public boolean isResultShown()
    {

        String urlOfImage = browser.findElement(By.xpath("//*[contains(text(),'House price')]//ancestor::a//div//div//img")).getAttribute("src");
        String expected = "https://www.gumtree.com/static/1/resources/assets/rwd/images/orphans/a37b37d99e7cef805f354d47.noimage_thumbnail.png";

        Assert.assertEquals(expected,urlOfImage);

        return result.isDisplayed();

    }


   }
