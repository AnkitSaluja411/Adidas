package pages;

import cucumber.runtime.StepDefinitionMatch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.StepDefinitions;
import webdriver.DemoBlazeWebDriver;

public class HomePage {
    
//    WebgetDriver() getDriver();
//    
//    public HomePage(WebgetDriver() getDriver()){
//        
//        this.getDriver()=getDriver();
//    }
WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }




    @FindBy(id = "cat")
    public WebElement category;

    public void selectCategory(String category){

//        getDriver().findElement(By.xpath("//a[@id='itemc' and text()='"+category+"']")).click();
        driver.findElement(By.xpath("//a[@id='itemc' and text()='"+category+"']")).click();

    }

    public void selectProduct(String product) throws InterruptedException {

        Thread.sleep(2000);
        WebElement productElement = driver.findElement(By.xpath("//a[@class='hrefch' and text()='"+product+"']"));
        productElement.click();
    }

    public void clickOnLink(String linkName){

        driver.findElement(By.xpath("//a[contains(text(),'"+linkName+"')]")).click();
    }

    public void isHomePageDisplayed(){

        Assert.assertTrue(category.isDisplayed());
    }
}
