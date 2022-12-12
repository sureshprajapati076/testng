package pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagelocators.PageLocator;
import utils.SeleniumDriver;

public class PageActionV1 {

    WebDriver webDriver;
    PageLocator pageLocator;

    public PageActionV1() {
        System.out.println("V1 Started:");
        SeleniumDriver.setupDriver();
        webDriver = SeleniumDriver.getDriver();
        pageLocator =  new PageLocator();
        PageFactory.initElements(webDriver,pageLocator);
    }

    public void openUrl(String url){
        webDriver.get(url);
    }

    public void enterSearchText(String text){
        pageLocator.searchBox.sendKeys(text);
    }

    public void hitSearchButton(){
        pageLocator.searchButton.click();
    }


    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}
