package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import utils.CommonMethods;
import utils.Log;

import java.io.IOException;

public class ReviewSteps extends CommonMethods {
    @Given("the user is navigated to dashboard page")
    public void the_user_is_navigated_to_dashboard_page() throws IOException {
        openBrowserAndLaunchApplication();
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String userName, String password) {
        sendText(userName, loginPage.userNameTxtField);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My first test case for login");
        Log.info("userName has been entered");
        sendText(password, loginPage.passwordTxtField);
        Log.info("password has been entered");
        Log.warn("This might not load the page");
        Log.debug("here I am debugging the code");

    }

    @When("user enters {string} values and {string} values")
    public void userEntersValuesAndValues(String userName, String password) {
        sendText(userName, loginPage.userNameTxtField);
        sendText(password, loginPage.passwordTxtField);
    }
}
