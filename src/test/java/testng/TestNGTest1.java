package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNGTest1 {

    @Parameters({"param1","param2"})
    @Test(groups = {"first"})
    public void testA(@Optional(value = "xyz") String value1, @Optional String value2){

        System.out.println("Started TestA : at: "+ LocalDateTime.now().getSecond());
        System.out.println("Values : "+value1 + " : "+value2);

        waitForNSeconds(5);

        System.out.println("Ended Test A: at: "+ LocalDateTime.now().getSecond());


    }


    private void waitForNSeconds(int n){
        try{
            Thread.sleep(n*10000);
        }
        catch (InterruptedException ex){

        }
    }




    @Test
    public void windowHandle() throws Exception {

        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement twitter= driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']"));
        WebElement facebook= driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']"));
        WebElement linkedin= driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']"));
        WebElement youtubeIcon = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']"));

        waitForNSeconds(1);

        twitter.click();

        waitForNSeconds(1);

        facebook.click();

        waitForNSeconds(1);

        linkedin.click();
        waitForNSeconds(1);

        youtubeIcon.click();
        waitForNSeconds(1);


        String currentwindow = driver.getWindowHandle(); //parent window
        Set<String> allWindows = driver.getWindowHandles();
//        waitForNSeconds(4);
//        System.out.println("CURRENT WINDOW: " + driver.switchTo().window(currentwindow).getTitle());
//
//        allWindows.forEach(windowHandle-> {
//            System.out.println("Another Window: "+ driver.switchTo().window(windowHandle).getTitle());
//            waitForNSeconds(5);
//        });

        openWindowByTitle(driver, "testng",allWindows);
        waitForNSeconds(5);

        openWindowByTitle(driver,"twitter",allWindows);
        waitForNSeconds(5);
        openWindowByTitle(driver, "testng",allWindows);

        waitForNSeconds(5);
        openWindowByTitle(driver,"linkedin",allWindows);


        waitForNSeconds(5);

        driver.quit();
    }

    private void openWindowByTitle(WebDriver webDriver, String title, Set<String> allWindows) {

        for(String windowHandleText: allWindows){
            String titleFromHandle= webDriver.switchTo().window(windowHandleText).getTitle().toLowerCase();
            if(titleFromHandle.contains(title.toLowerCase())) return;
        }

    }
}
