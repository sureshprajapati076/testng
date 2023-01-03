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

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Suresh");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Prajapati");
        driver.findElement(By.xpath("//input[@id='ssnNo']")).sendKeys("236588952");
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("11-11-1999");

        driver.findElement(By.xpath("//input[@id='streetAddress']")).sendKeys("525 NE NORTHGATE WAY");

        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("98125");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Seattle");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='state-button-value']"))).click().pause(1000)
                        .sendKeys("Washington").click().build().perform();
        driver.findElement(By.xpath("//input[@id='mobileNo']")).sendKeys("2062146335");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sureshpraja@citi.com");
        driver.findElement(By.xpath("//input[@id='totalAnnualIncome']")).sendKeys("78000");

        driver.findElement(By.xpath("//input[@id='monthlyRent']")).sendKeys("2500");

        actions.moveToElement(driver.findElement(By.xpath("//div[@id='securityWordHint-button-value']"))).click().pause(1000)
                .sendKeys("Favorite Snack").click().build().perform();


        driver.findElement(By.xpath("//input[@id='securityWord']")).sendKeys("Wai Wai");

        driver.findElement(By.xpath("//label[@id='tNcCheckbox-label']")).click();

        driver.findElement(By.xpath("//label[@id='tNcPaperlessCheckbox-label']")).click();


        Thread.sleep(5000);
        driver.quit();









    }






}
