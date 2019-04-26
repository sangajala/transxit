package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class Utility extends BasePage{

    public Utility(WebDriver browser) {
        super(browser);
    }

    public void clickOnButton(String text){
        browser.findElement(By.xpath("//input[@value='"+text+"']")).click();
    }

    public void waitFor1Sec(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void insertData() {
//        Date
//        DB.InsertScript("INSERT ");
    }
}
