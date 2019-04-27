package tranxit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    public static final String USERNAME = "sai12345";
    public static final String ACCESS_KEY = "0dbe48c3-01ca-4c5f-837f-d91b0a37eead";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    static WebDriver driver = null;

    public static WebDriver getBrowser() {
        if(driver != null ){
            return  driver;
        }
        else {
            String browserName = System.getProperty("BROWSER");
            System.out.println("browsername" + browserName);
            DesiredCapabilities caps;

            if (browserName.equalsIgnoreCase("chrome")) {
                caps = DesiredCapabilities.chrome();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "51.0");
            } else if (browserName.equalsIgnoreCase("Edge")) {
                caps = DesiredCapabilities.edge();
                caps.setCapability("InPrivate", true);
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "16.16299");
            } else {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");
                caps = DesiredCapabilities.chrome();
                caps.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
            }
            try {
                driver = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }


//        if(browserName.equalsIgnoreCase("Firefox")){
//           return new FirefoxDriver();
//        }
//        else if(browserName.equalsIgnoreCase("safari")){
//
//            return new SafariDriver();
//
//        }
//        else {
//            return new ChromeDriver();
//        }
//        try {
//            driver = new RemoteWebDriver(new URL("http://98.1.1.10:9515"), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


    }
}
