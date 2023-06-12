package docker;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

public class DockerTest {

    @Test
    public void test1() throws InterruptedException {

        // HWLLO THIS IS NEW COMMIT TESTING
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");  // comment this browser name then it will assign to any of available browser in hub
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(capabilities); // new RemoteWebDriver( new URL("http://localhost:4444/wd/hub",capabilities));
                                                            // if we provide without URL it will use default value as local host see inside RemotewebDriver constructor
        driver.get("https://youtube.com");
        Thread.sleep(10000);
        driver.quit();
        System.out.println("ASSUME THIS IS REQUIRED for PROD Comit 2");
    }

    @Test(invocationCount = 1)
    public void test2() throws InterruptedException {


        // part 1
        // part 2

        ChromeOptions options=new ChromeOptions();
        options.setPlatformName(Platform.LINUX.name());


        FirefoxOptions options1 = new FirefoxOptions();

        options1.setPlatformName(Platform.LINUX.name());


        EdgeOptions options2= new EdgeOptions();
        options2.setPlatformName(Platform.LINUX.name());


        WebDriver driver = new RemoteWebDriver(options1);
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
