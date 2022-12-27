package testng;


import io.restassured.RestAssured;
import listners.ListnerTest;
import org.apache.commons.lang3.StringUtils;
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

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Listeners(ListnerTest.class)
public class TestYoutube {


    WebDriver webDriver;



    @Test
    public void testBrokenLinks() {

        this.webDriver.get("https://www.citi.com/");

      //  Assert.assertTrue(false);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<WebElement> links = webDriver.findElements(By.tagName("a"));


        List<String> hrefs = links.stream().map(link->link.getDomAttribute("href")).filter(StringUtils::isNotBlank).filter(url->url.startsWith("http")).collect(Collectors.toList());


        //Below are examples....
        System.out.println(RestAssured.get("https://itunes.apple.com/app/citi-mobile-sm/id301724680?mt=8").statusCode());
        System.out.println(RestAssured.get("https://online.citi.com/JRS/portal/template.do?ID=Privacy#notice-at-collection").statusCode());
        System.out.println(RestAssured.given().queryParam("ID", "Privacy").get("https://online.citi.com/JRS/portal/template.do").statusCode());


        for(String href: hrefs)
            if(RestAssured.get(href).statusCode()>=400){
                System.out.println(href + " _BROKEN LINK FOUND");
            }
            else{
                System.out.println(href);
            }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


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
        /* Adding drag and drop
        actions.clickAndHold().pause(2).moveToElement(null).release().build().perform();
        //OR
        actions.dragAndDrop(null,null);

         */

        //double click
        //actions.doubleClick().build().perform();

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
    public void initDrivers() throws IOException {

        SeleniumDriver.setupDriver();
        this.webDriver = SeleniumDriver.getDriver();


        // BufferedReader bufferedReader= new BufferedReader();

        /*
        Properties properties= new Properties();
        properties.load(new FileReader("config/configuration.properties"));

        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.name"));


        System.out.println(properties.getProperty("env"));
        System.out.println(properties.get("env"));




        //explicit wait
        WebDriverWait wait= new WebDriverWait(this.webDriver, Duration.ofSeconds(40));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div")));


        Wait<WebDriver> wait1=new FluentWait(this.webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);


        WebElement foo=wait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver webDriver) {
                return null;
            }

            @Override
            public <V> Function<V, WebElement> compose(Function<? super V, ? extends WebDriver> before) {
                return Function.super.compose(before);
            }

            @Override
            public <V> Function<WebDriver, V> andThen(Function<? super WebElement, ? extends V> after) {
                return Function.super.andThen(after);
            }
        });


*/

    }

    @AfterTest
    public void quit() {
        SeleniumDriver.closeDriver();
    }


}
