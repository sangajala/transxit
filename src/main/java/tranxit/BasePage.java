package tranxit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public WebDriver browser;

    public BasePage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }
}
