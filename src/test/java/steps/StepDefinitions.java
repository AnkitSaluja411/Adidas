package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GeneralPage;
import pages.HomePage;
import pages.ProductsPage;
import webdriver.DemoBlazeWebDriver;

import java.util.List;
import java.util.Map;

public class StepDefinitions extends DemoBlazeWebDriver {

    int totalAmount;
    String purchaseAmount;

    HomePage homePage;
    ProductsPage productsPage;
    GeneralPage generalPage;

    @Before("@ShopOnDemoblaze")
    public void openBrowser() {
        chromeBrowser();
        homePage = new HomePage(getDriver());
        productsPage = new ProductsPage(getDriver());
        generalPage = new GeneralPage(getDriver());
    }

    @After("@ShopOnDemoblaze")
    public void closeBrowser() {
        getDriver().close();
    }

    @Given("^I launch the url \"([^\"]*)\"$")
    public void i_launch_the_url(String url) throws Throwable {

        getDriver().navigate().to(url);
    }

    @Given("^I navigate to ([^\"]*) category on homepage$")
    public void i_navigate_to_Laptops_category_on_homepage(String category)  {

        homePage.selectCategory(category);
    }

    @When("^I click on ([^\"]*) product$")
    public void i_click_on_product(String product) throws Throwable {

        homePage.selectProduct(product);
    }

    @When("^I click on 'Add to cart' button on Product page$")
    public void i_click_on_Add_to_cart_button_on_Product_page() throws Throwable {

        productsPage.addToCart();
    }

    @When("^I Accept pop up confirmation on Product page$")
    public void i_Accept_pop_up_confirmation_on_Product_page() throws Throwable {

        generalPage.acceptAlerts();
    }

    @When("^I click on \"([^\"]*)\" link$")
    public void i_click_on_link(String linkName) throws Throwable {

         homePage.clickOnLink(linkName);
    }

    @Then("^I verify that 'Home' page should be displayed$")
    public void i_verify_that_Home_page_should_be_displayed() throws Throwable {

        homePage.isHomePageDisplayed();
    }

    @When("^I delete ([^\"]*) from the Cart$")
    public void i_delete_Dell_i_gb_from_the_Cart(String product) throws Throwable {

        getDriver().findElement(By.xpath("//td[text()='"+product+"']/../td/a[text()='Delete']")).click();
        Thread.sleep(2000);
    }

    @When("^I click on \"([^\"]*)\" button$")
    public void i_click_on_button(String buttonName) throws Throwable {

        generalPage.clickOnButton(buttonName);
    }

    @When("^I enter details on Place Order popup$")
    public void i_enter_details_on_Place_Order_popup(DataTable orderData) throws Throwable {

        Thread.sleep(2000);
        Map<String,String> data=orderData.asMap(String.class,String.class);

        String value;
        value =  data.get("Name");
        getDriver().findElement(By.id("name")).sendKeys(value);

        value =  data.get("Country");
        getDriver().findElement(By.id("country")).sendKeys(value);

        value =  data.get("City");
        getDriver().findElement(By.id("city")).sendKeys(value);

        value =  data.get("Credit card");
        getDriver().findElement(By.id("card")).sendKeys(value);

        value =  data.get("Month");
        getDriver().findElement(By.id("month")).sendKeys(value);

        value =  data.get("Year");
        getDriver().findElement(By.id("year")).sendKeys(value);

        Thread.sleep(2000);
    }

    @When("^I click on 'Purchase' button on Place Order window$")
    public void i_click_on_Purchase_button_on_Place_Order_window() throws Throwable {

        WebElement purchaseButton = getDriver().findElement(By.xpath("//button[text()='Purchase']"));
        purchaseButton.click();

    }

    @When("^I Capture and log purchase Id and Amount$")
    public void i_Capture_and_log_purchase_Id_and_Amount() throws Throwable {

        String orderText = getDriver().findElement(By.xpath("//h2[text()='Thank you for your purchase!']/following-sibling::p")).getText();
        System.out.println(orderText);

        String[] orderDetails= orderText.split("\n");

        System.out.println(orderDetails[0]);
        System.out.println(orderDetails[1]);

        purchaseAmount=orderDetails[1].split(":")[1].trim();
        Thread.sleep(2000);
    }

    @Then("^I verify that Assert purchase amount should be equal to the expected amount$")
    public void i_verify_that_Assert_purchase_amount_should_be_equal_to_the_expected_amount() throws Throwable {

         String expectedAmount=totalAmount+" USD";
         Assert.assertEquals(expectedAmount, purchaseAmount);
    }

    @And("^I calculate the total amount$")
    public void iCalculateTheTotalAmount() throws Throwable {

        List<WebElement> elementList = getDriver().findElements(By.xpath("//tr[@class='success']/td[3]"));
        for (WebElement element : elementList) {
            totalAmount += Integer.parseInt(element.getText());
        }
    }
}
