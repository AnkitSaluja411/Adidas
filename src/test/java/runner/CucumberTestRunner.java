package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/api",
        plugin = {"pretty"},
        glue = "steps",
        tags= "@GetApi"
//        tags= "@UpdateAPI"
//        tags= "@PostAPI"


)
public class CucumberTestRunner {




}
