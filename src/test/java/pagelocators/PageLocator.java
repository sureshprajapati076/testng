package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageLocator {

    @FindBy(how = How.XPATH, using = "//input[@id='search']")
    public WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']")
    public WebElement searchButton;

}
