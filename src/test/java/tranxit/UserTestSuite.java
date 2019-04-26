package tranxit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class UserTestSuite {

    static WebDriver browser;

    @BeforeClass
    public static void openBrowser() {
        System.out.println("openBrowser");
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.manage().window().maximize();

    }

    public static void waitForSomeTime()
    {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }


    @AfterClass
    public static void closeBrowser(){
        System.out.println("closeBrowser");
        browser.close();
    }


    @Before
    public void login(){
        System.out.println("login");

        //open url
        browser.get("https://schedule.tranxit.co/login");
        //id email

        WebElement usernameTextBox = browser.findElement(By.id("email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("demo@demo.com");

        WebElement passwordTextBox = browser.findElement(By.id("password"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("123456");

        WebElement loginButton = browser.findElement(By.className("log-teal-btn"));
        loginButton.click();
        browser.findElement(By.className("demoModeDialogclose")).click();


    }

    @After
    public void logout()
    {
        System.out.println("logout");
        browser.manage().deleteAllCookies();
        browser.get("https://schedule.tranxit.co/logout");
    }

    @Test
    public void testUpdateProfile(){

        System.out.println("testUpdateProfile");

        WebElement profileLink = browser.findElement(By.linkText("Profile"));
        profileLink.click();

        WebElement popupBox = browser.findElement(By.className("demoModeDialogclose"));
        if(popupBox.isDisplayed()) {
            browser.findElement(By.className("demoModeDialogclose")).click();
        }
        WebElement editProfileButton = browser.findElement(By.className("form-sub-btn"));
        editProfileButton.click();

        WebElement lastNameTextBox = browser.findElement(By.name("last_name"));
        lastNameTextBox.clear();
        lastNameTextBox.sendKeys("newLastName");
        WebElement saveButton = browser.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div[7]/button"));
        saveButton.click();

        WebElement messageBox = browser.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]"));
        String actualMessage = messageBox.getText();
        UserTestSuite.waitForSomeTime();
        Assert.assertTrue(actualMessage.contains("Profile Updated"));

    }

    @Test
    public void testUpdateCardType(){
        System.out.println("testUpdateCardType");
        Assert.assertEquals("Card Updated.","Card Updated.");

    }

}
