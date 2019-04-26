/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package tranxit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@login"
        ,format = {"pretty",
        "html:target/cucumberHtmlReports.html",
        "json:target/cucumberJsonReports.json"
})
public class CucumberFeatureRunner {
    static WebDriver browser;

    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("openBrowser");
        browser = BrowserFactory.getBrowser();
        browser.manage().window().maximize();
    }

    @AfterClass
    public static void closeTheBrowser() {
        browser.close();
    }
}
