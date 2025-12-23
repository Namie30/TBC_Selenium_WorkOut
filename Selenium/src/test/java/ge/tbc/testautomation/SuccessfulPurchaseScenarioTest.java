package ge.tbc.testautomation;

import ge.tbc.testautomation.data.Constants;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.Descriptor;
import java.awt.*;

@Test(description = "E2E - successful product purchase")   //Here we put the title of the scenario that we are testing with its id number
public class SuccessfulPurchaseScenarioTest {

    WebDriver driver;         //This is really useful

    @BeforeTest
    public void setUp()
    {
     driver = new EdgeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.saucedemo.com/");
    }

    @Test(description = "Login as Standard User", priority = 1)
    public void loginAsStandardUser()
    {
        WebElement usernameInput = driver.findElement(By.id("user-name"));     // On site with the help of inspect Element we
                                                                               //get the id and then with this we tell our code what to find "Maybe Login line, where than we will tell program to write mail and so on"

        usernameInput.sendKeys(Constants.STANDARD_USER);                       //And with sendKeys we send the data, which we want, in this case we crated a separate class in main folder as a data package, and we imported data from there. This is a good practice

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(Constants.PASSWORD);                            //Now we are taking password from constant class

       WebElement loginButton = driver.findElement(By.id("login-button"));     //With this we found login button
       loginButton.click();                                                    //And with this we click it
    }

    @Test(description = "Adding things to the cart0", priority = 2)
    public void AddToCart()
    {
     WebElement AddToCartButton = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//following::button[1]"));
     AddToCartButton.click();

     WebElement RemoveFromCartButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
     //RemoveFromCartButton.click();
     boolean isVisible = RemoveFromCartButton.isDisplayed();
     Assert.assertTrue(isVisible);

    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }


}
