package citybikes.api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json", "html:target/cucumber-reports"},
        features = "src/main/resources/features/citybikes.feature",
        glue = {"citybikes/api/step/defs", "citybikes/api/entity"},
        tags = "@testAl")
public class RunCucumberAcceptanceIT {
}
