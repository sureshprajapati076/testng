package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumDriverVersion2 {

    private static WebDriver webDriver = null;


    public static WebDriver createDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        }
        return webDriver;
    }
}
