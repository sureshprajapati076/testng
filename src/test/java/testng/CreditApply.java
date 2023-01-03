package testng;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.SeleniumDriver;

public class CreditApply {


    @Test
    public void applyForCredit() throws InterruptedException {

        SeleniumDriver.setupDriver();
        WebDriver driver = SeleniumDriver.getDriver();
        driver.get("https://online.citi.com/US/ag/cards/application?app=UNSOL&HKOP=57d896bfd2e418a14d7a7b13c051aa7c4034270e2fe20e77ef2438f166bd9b6e");
        driver.findElement(By.id("firstName")).sendKeys("Suresh");
        driver.findElement(By.id("lastName")).sendKeys("Prajapati");
        driver.findElement(By.id("ssnNo")).sendKeys("236588952");
        driver.findElement(By.id("dob")).sendKeys("11-11-1999");

        driver.findElement(By.id("streetAddress")).sendKeys("525 NE NORTHGATE WAY");

        driver.findElement(By.id("zipCode")).sendKeys("98125");
        driver.findElement(By.id("city")).sendKeys("Seattle");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("state-button-value"))).click().pause(200)
                        .sendKeys("Washington").click().build().perform();
        driver.findElement(By.id("mobileNo")).sendKeys("2062146335");

        driver.findElement(By.id("email")).sendKeys("sureshpraja@citi.com");
        driver.findElement(By.id("totalAnnualIncome")).sendKeys("78000");

        driver.findElement(By.id("monthlyRent")).sendKeys("2500");

        actions.moveToElement(driver.findElement(By.id("securityWordHint-button-value"))).click().pause(200)
                .sendKeys("Favorite Snack").click().build().perform();


        driver.findElement(By.id("securityWord")).sendKeys("Wai Wai");

        driver.findElement(By.id("tNcCheckbox-label")).click();

        driver.findElement(By.id("tNcPaperlessCheckbox-label")).click();


        Thread.sleep(5000);
        driver.quit();









    }






}
