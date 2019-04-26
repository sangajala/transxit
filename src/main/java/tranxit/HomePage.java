package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.LINK_TEXT,using = "Log in")
    private WebElement loginLink;

    @FindBy(how = How.LINK_TEXT,using = "Log out")
    private WebElement logoutLink;

    @FindBy(how = How.ID,using = "q")
    private WebElement searchText;

    @FindBy(how = How.XPATH,using = "//input[@value='Search']")
    private WebElement searchButton;




    public void gotoLoginPage(){
        loginLink.click();

    }

    public void logout() {
        logoutLink.click();
    }

    public void gotoSearchPageWithKey(String key){
        searchText.sendKeys(key);
        searchButton.click();

    }
}
