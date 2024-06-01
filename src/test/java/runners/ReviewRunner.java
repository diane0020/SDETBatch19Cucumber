package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// we do this outside of class
@RunWith(Cucumber.class) // comes from junit
@CucumberOptions (
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = false,
        tags = "@loginWithFeature"
)

public class ReviewRunner {
}
