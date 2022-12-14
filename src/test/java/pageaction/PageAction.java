package pageaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pagelocators.PageLocator;
import utils.SeleniumDriver;

public class PageAction {

    WebDriver webDriver;
    PageLocator pageLocator;

    public PageAction() {
        System.out.println("V0 Started:");
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

    public void clickSignup() throws InterruptedException {
        Thread.sleep(2000);
        pageLocator.signup.click();
        Thread.sleep(2000);

        System.out.println("FEMALE: is selected: "+pageLocator.gender.get(0).isSelected());

        pageLocator.gender.get(0).click();

        Thread.sleep(2000);

        System.out.println("FEMALE: is selected: "+pageLocator.gender.get(0).isSelected());
        Thread.sleep(2000);

        Select mySelect = new Select(pageLocator.month);

        mySelect.getOptions().forEach(x-> System.out.println(x.getText()));



        mySelect.selectByVisibleText("Jul");

      //  mySelect.selectByIndex(5);


        System.out.println("i");

        //pageLocator.month.getOptions().forEach(x-> System.out.println(x.getText()));



    }
}
