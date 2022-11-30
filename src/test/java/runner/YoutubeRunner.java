package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false, glue = "stepdefs", features = "src/test/resources/FeatureFiles", plugin = {"pretty"},
tags = "@youtube")
public class YoutubeRunner {


}
