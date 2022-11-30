package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "timeline:target/cucumber-timeline/",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/report-xml.xml",
        "html:target/html-report/html-cucumber.html"
}, monochrome = true, dryRun = false, glue = "stepdefs", features = "src/test/resources/FeatureFiles",
        tags = "@youtube")
public class YoutubeRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

//    @BeforeSuite
//    public void test(ITestContext itc){
//        System.out.println("HELLO");
//    }

}
