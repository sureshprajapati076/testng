package listners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.SeleniumDriverVersion2;

import java.io.File;
import java.io.IOException;

public class ListnerTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Taking Screenshot:");

// process 1
        //  File screenshotFile=((TakesScreenshot) SeleniumDriver.getDriver()).getScreenshotAs(OutputType.FILE);

        //process 2
        File screenshotFile = ((TakesScreenshot) SeleniumDriverVersion2.createDriver()).getScreenshotAs(OutputType.FILE);


        File DestFile = new File("target/screenshot.png");
//Copy file at destination
        try {
            FileUtils.copyFile(screenshotFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("DONE");

    }

}
