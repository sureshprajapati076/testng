package pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagelocators.PageLocator;
import utils.SeleniumDriver;

public class PageAction {

    WebDriver webDriver;
    PageLocator pageLocator;

    public PageAction() {
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




}
