package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Pattern.feature"},
        glue = {"StepDef", "ReastAssurtTest", "BaseForEachRequest", "FileWrappers","TestRunner"},
        plugin = {"pretty"},
        monochrome = true)
public class TestRunner  {

}
