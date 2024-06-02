package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {

    // pre condition
    @Before
    public void start() throws IOException {
        openBrowserAndLaunchApplication();
    }

    // post condition
    @After
    public void end(Scenario scenario) {
        byte [] pictures;

        // getName is the method in scenario class which returns the name of the test case
        if(scenario.isFailed()) {
            pictures = takeScreenshot("failed/" + scenario.getName());
        } else {
            pictures = takeScreenshot("passed/" + scenario.getName());
        }

        scenario.attach(pictures, "image/png", scenario.getName());

        closeBrowser();
    }
}
