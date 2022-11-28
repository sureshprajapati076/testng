package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumDriver {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    private SeleniumDriver() {
        WebDriver webDriver1 = createDriver();
        threadLocalDriver.set(webDriver1);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void setupDriver(){
        if(getDriver()==null) new SeleniumDriver();
    }


    private WebDriver createDriver() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        return webDriver;
    }
}
