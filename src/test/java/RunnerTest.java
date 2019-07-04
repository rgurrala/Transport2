import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "junit:target/cucumber-results.xml","html:target/pretty","html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html","html:target/cucumber-html-report"},tags={"@smokePack"})
public class RunnerTest {
}