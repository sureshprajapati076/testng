package testng;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import utils.SeleniumDriver;

import java.time.Duration;
import java.util.List;

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

    @Test
    public void sliderTesting() throws InterruptedException {

        SeleniumDriver.setupDriver();
        WebDriver driver = SeleniumDriver.getDriver();
        driver.get("https://www.delekhomes.com/");

        var leftSlider=driver.findElement(By.xpath("//input[@data-index='0']"));

        var rightSlider =driver.findElement(By.xpath("//input[@data-index='1']"));

        var priceRange = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1fvw608']"));


        Thread.sleep(2000);

        var actions= new Actions(driver);
        actions.moveToElement(leftSlider).click();
        for(var count=0;count<100;count++){
            actions.sendKeys(Keys.ARROW_RIGHT).pause(200).build().perform();
            if(priceRange.getText().equalsIgnoreCase("Price $ 9,900,000 - $ 10,000,000")){
                break;
            }

        }

        actions.moveToElement(rightSlider).click();
        for(var count=0;count<100;count++){
            actions.sendKeys(Keys.ARROW_RIGHT).pause(200).build().perform();
            if(priceRange.getText().equalsIgnoreCase("Price $ 9,900,000 - $ 11,400,000")){
                break;
            }
        }




        Thread.sleep(5000);
        driver.quit();









    }


    @Test
    public void testYTComments() throws InterruptedException {
        SeleniumDriver.setupDriver();
        WebDriver webDriver =SeleniumDriver.getDriver();

        webDriver.get("https://www.youtube.com/watch?v=4IenX7OHumk");

        Thread.sleep(5000);

        FluentWait<WebDriver> fluentWait = new FluentWait<>(webDriver);

        //trying to get 25th comment in yt video
        WebElement ele=fluentWait
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(IndexOutOfBoundsException.class)
                .until(driver-> {
                    System.out.println("SCROLLING....");
                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("window.scrollBy(0,250)");
                   List<WebElement> list = driver.findElements(By.xpath("//*[@id='content-text']"));

                   return list.get(25);
                });

        System.out.println(ele.getText());



        Thread.sleep(3000);

        webDriver.quit();


    }






}
