package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // this will specify the path of features directory
        features = "src/test/resources/features/",

        // in glue, we provide the name of the steps in package
        // runner class will search all the step definitions inside this package
        glue = "steps",

        // when we set the value of dry run to true
        // it stops the actual execution and scans all the steps definition,
        //if the step def is missing in any of the class, then it will give you that
        //missing step def. if all the step def are there, it will provide green tick

        //to start the actual execution after implementing the missing step
        //set the value of dry run to false
        dryRun = false,
        tags = "@empSearchById"

)

public class RunnerClass {
}
