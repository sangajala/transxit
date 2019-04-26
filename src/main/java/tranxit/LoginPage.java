package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver browser) {
        super(browser);
    }


    ////header//////////

    @FindBy(how = How.ID,using = "Email" )
    public WebElement usernameText;

    @FindBy(how = How.ID,using = "Password" )
    public WebElement passwordText;

    @FindBy(how = How.XPATH,using = "//input[@value='Log in']")
    public WebElement submit;

    @FindBy(how = How.TAG_NAME,using = "body")
    public WebElement bodyText;


    //action//////////////////////


    public void login(String username,String password){


       usernameText.sendKeys(username);
       passwordText.sendKeys(password);
       submit.click();
    }

    public boolean isUserLogged(){

        WebDriverWait wait = new WebDriverWait(browser,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Add to cart']")));
       System.out.println(bodyText.getText());
       return bodyText.getText().contains("Welcome to our store");
    }

}
