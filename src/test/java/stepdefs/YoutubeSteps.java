package stepdefs;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.annotations.BeforeSuite;
import pageaction.PageAction;
import utils.SeleniumDriver;

public class YoutubeSteps {

    PageAction pageAction= new PageAction();
    @Given("User is in youtube {string} homepage")
    public void userIsInYoutubeHomepage(String url) {
        pageAction.openUrl(url);
    }

    @BeforeSuite
    public void beforeSuites(){
        System.out.println("BEFORE_SUITE");
    }

    @And("User enters text {string} in search box")
    public void userEntersTextInSearchBox(String text) {
        pageAction.enterSearchText(text);
    }

    @And("User Click search Button")
    public void userClickSearchButton() {
        pageAction.hitSearchButton();
    }

    @Then("Verify user sees results")
    public void verifyUserSeesResults() {
//        pageAction.closeDriver();
        System.out.println("Verified!!!");
    }

    @AfterStep
    public void waitFewSeconds(Scenario scenario){
      //  System.out.println("WAITING FOR : " + scenario.getUri() + " : " + scenario.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void quitDriver(){
     SeleniumDriver.closeDriver();
    }
}
