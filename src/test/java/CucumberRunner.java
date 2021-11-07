import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"org.example"},
        plugin = {
                "org.example.util.AllureReporter",
        }
)
public class CucumberRunner {

}
