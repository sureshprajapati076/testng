package runner;



import basepackage.BaseRunnerBrowser;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"pretty",
        "timeline:target/cucumber-timeline/",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/report-xml.xml",
        "html:target/html-report/html-cucumber.html"
}, monochrome = true, dryRun = false, glue = "stepdefs", features = "src/test/resources/FeatureFiles",
        tags = "@youtube")
public class YoutubeRunner extends BaseRunnerBrowser {

    public YoutubeRunner(){
        super();
    }



}
