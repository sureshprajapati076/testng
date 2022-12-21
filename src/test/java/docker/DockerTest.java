package docker;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DockerTest {




    @Test
    public void test1() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test3() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test5() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test6() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test7() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test8() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test9() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities);
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
    }




}
