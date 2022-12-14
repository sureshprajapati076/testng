package stepdefs;

import io.cucumber.java.en.*;
import pageaction.PageAction;

public class FbSignupSteps {

    PageAction pageAction= new PageAction();
    @Given("User is in facebook {string} homepage")
    public void user_is_in_facebook_homepage(String url) {
        // Write code here that turns the phrase above into concrete actions

        pageAction.openUrl(url);

    }
    @And("User clicks signup button")
    public void user_clicks_signup_button() throws InterruptedException {
        pageAction.clickSignup();
    }
    @Then("Verify user sees signup page")
    public void verify_user_sees_signup_page() {
        // Write code here that turns the phrase above into concrete actions

    }


}
