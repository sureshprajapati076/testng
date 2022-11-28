package youtube;


import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.SeleniumDriver;
import utils.SeleniumDriverVersion2;

@Listeners(listners.ListnerTest.class)
public class TestYoutube {


    WebDriver webDriver;


    @Test
    public void testYoutube() {

        this.webDriver.get("https://youtube.com");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement searchBox = this.webDriver.findElement(By.xpath("//input[@id='search']"));

        WebElement searchButton = this.webDriver.findElement(By.xpath("//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']"));

        Actions actions = new Actions(this.webDriver);
        Action action = actions.moveToElement(searchBox).click().sendKeys("Automation").build();
        action.perform();

        searchButton.click();


        String pageTitle = this.webDriver.getTitle();

        Assert.assertEquals(pageTitle, "YouT ube");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @BeforeTest
    public void initDrivers() {

        /*below is for method1 to get driver instance

        SeleniumDriver.setupDriver();
        this.webDriver = SeleniumDriver.getDriver();

         */



        //below is for method2 to get driver instance
        this.webDriver = SeleniumDriverVersion2.createDriver();

    }

    @AfterTest
    public void quit() {
        this.webDriver.quit();
    }


}
