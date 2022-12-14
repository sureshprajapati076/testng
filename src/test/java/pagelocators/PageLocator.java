package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageLocator {

    @FindBy(how = How.XPATH, using = "//input[@id='search']")
    public WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']")
    public WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Create new account']")
    public WebElement signup;

    @FindBy(how = How.XPATH, using = "//input[@name='sex']")
    public List<WebElement> gender;

    @FindBy(id="month")
    public WebElement month;






}
