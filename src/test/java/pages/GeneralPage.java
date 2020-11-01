package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GeneralPage {

    WebDriver driver;
    public GeneralPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptAlerts(){

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickOnButton(String buttonName){

        driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();
    }

}
