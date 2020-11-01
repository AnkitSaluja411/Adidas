package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DemoBlazeWebDriver {

    WebDriver driver;

    public WebDriver getDriver(){

        return driver;
    }

    public void chromeBrowser(){

        System.setProperty("webdriver.chrome.driver", "F:\\30OctFinal\\Adidas\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriverWait getExplicitWait(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,30);
        return wait;
    }
}
