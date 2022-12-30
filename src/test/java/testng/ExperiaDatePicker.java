package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExperiaDatePicker {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        ChromeOptions options= new ChromeOptions();
        options.setHeadless(false);
        driver =  new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }


    @Test
    public void experiaDatePicker() {

        String checkInDate = "June 23, 2023";
        String checkOutDate = "December 14, 2023";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate checkInLocalDate = LocalDate.parse(checkInDate,formatter);
        LocalDate checkOutLocalDate = LocalDate.parse(checkOutDate,formatter);

        if(checkInLocalDate.isBefore(LocalDate.now()) || checkInLocalDate.isAfter(LocalDate.now().plusMonths(16)) || checkOutLocalDate.isBefore(checkInLocalDate)){
            Assert.fail("Check In Date/Check Out Date incorrect, Allowed Range is 16 months from today for check in/out");
        }

        String checkInMonthYear = Stream.of(checkInDate.split(" ")).filter(x -> !x.contains(",")).collect(Collectors.joining(" "));
        String checkOutMonthYear = Stream.of(checkOutDate.split(" ")).filter(x -> !x.contains(",")).collect(Collectors.joining(" "));

        checkInDate = Stream.of(checkInDate.split(" ")).map(x -> x.matches("^[a-zA-Z]*$") ? x.substring(0, 3) : x).collect(Collectors.joining(" "));

        checkOutDate = Stream.of(checkOutDate.split(" ")).map(x -> x.matches("^[a-zA-Z]*$") ? x.substring(0, 3) : x).collect(Collectors.joining(" "));

        driver.get("https://www.expedia.com/");

        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();  // to hide login modal that auto shows on landing

        driver.findElement(By.xpath("//button[@id='d1-btn']")).click();

        while (!driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText().equalsIgnoreCase(checkInMonthYear)) {
            driver.findElement(By.xpath("//div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']//button[2]")).click();
        }

        driver.findElement(By.xpath("//button[@aria-label='CHECK_IN_DATE']".replace("CHECK_IN_DATE", checkInDate))).click();

        while (!(driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText().equalsIgnoreCase(checkOutMonthYear) ||
                driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[2]")).getText().equalsIgnoreCase(checkOutMonthYear))) {
            driver.findElement(By.xpath("//div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']//button[2]")).click();
        }

        driver.findElement(By.xpath("//button[@aria-label='CHECK_OUT_DATE']".replace("CHECK_OUT_DATE", checkOutDate))).click();

        driver.findElement(By.xpath("//button[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
    }

    @AfterTest
    public void tearOff() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
