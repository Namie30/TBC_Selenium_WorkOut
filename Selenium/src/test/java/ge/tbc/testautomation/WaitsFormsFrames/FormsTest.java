package ge.tbc.testautomation.WaitsFormsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.NoSuchElementException;

public class FormsTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
   //     driver.get("https://techcanvass.com/examples/register.html");

    }

   /* @Test(priority = 1)
    public void radioButtonTest()
    {
       WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@type='radio'][@value='female']"));
       if(!femaleRadioButton.isSelected())
       {
           femaleRadioButton.click();
       }
    }

    @Test
    public void nativeDropDownTest()
    {
        Select modelDropDown = new Select(driver.findElement(By.xpath("//select[@name = 'model']")));
        modelDropDown.selectByVisibleText("Serene Pad 32G");
    }*/

    @Test
    public void anotherDropDownTest()
    {
        driver.get("https://ng-bootstrap.github.io/#/components/dropdown/examples");
        WebElement angularButton = driver.findElement(By.id("dropdownBasic1"));
        angularButton.click();

        List<WebElement> options = driver.findElements(By.xpath("//button[@id='dropdownBasic1']/following-sibling::div//button"));
                                                                               //button[@id='dropdownBasic1']/following-sibling::div//button
                                                                               //div[@class = 'dropdown-menu show']//button

       //WebElement options = driver.findElement(By.xpath("//button[@id='dropdownBasic1']/following-sibling::div//button[text()='Action -1']"));
       WebElement actionOptions = options.stream()
                .filter(webElement -> webElement.getText().contains("Action"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No Action Element Found"));

        actionOptions.click();

      /*  Select modelDropDown = new Select(driver.findElement(By.xpath("//button[@id='dropdownBasic1']/following-sibling::div//button[text()='Another Action']")));
        modelDropDown.selectByVisibleText("Another Action");*/

    }

    @AfterTest
    public void tearDown() {

    }

}


























