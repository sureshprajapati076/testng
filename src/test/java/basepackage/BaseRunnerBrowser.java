package basepackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class BaseRunnerBrowser extends AbstractTestNGCucumberTests {

    public BaseRunnerBrowser(){
        System.out.println("BASE CONSTRUCTOR");
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void test(ITestContext itc){
        System.out.println("HELLO");
    }
}
