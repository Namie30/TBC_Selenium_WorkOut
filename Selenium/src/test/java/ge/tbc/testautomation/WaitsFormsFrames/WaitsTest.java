package ge.tbc.testautomation.WaitsFormsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8)); //So this is kind of General that waits 8
                                                                          //seconds until the element is found than executes the test
                                                                          //not advisable if we want fast code, even though it
                                                                          //does not wait internally 8 seconds, if it finds it in 2 seconds it executes
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   /* @Test(description = "Testing Wait Commands", priority = 1)
    public void implictWaitTest()
    {
         driver.get("http://the-internet.herokuapp.com/dynamic_controls");
         WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
         enableButton.click();

         *//*WebElement enableText = driver.findElement(By.id("message"));
         Assert.assertEquals(enableText.getText(), "It's enabled!");*//*
    }*/

    @Test(description = "Just Wait Testing")
    public void ExplicitWaitTest()
    {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
        enableButton.click();


       /* WebElement enableText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(enableText.getText(), "It's enabled!");*/
        WebElement input = driver.findElement(By.xpath("//input[@type = 'text']"));

        boolean isEnputEnabled = wait.until(driverInstance -> {
           if(input.isEnabled())
                   return true;
           else
               return false;
        });
        Assert.assertTrue(isEnputEnabled);
        input.sendKeys("Greatest");
    }

    @AfterTest
    public void afterTest()
    {

    }

}
