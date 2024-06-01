package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.CommonMethods;

import java.io.IOException;

public class ReviewSteps extends CommonMethods {
    @Given("the user is navigated to dashboard page")
    public void the_user_is_navigated_to_dashboard_page() throws IOException {
        openBrowserAndLaunchApplication();
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String userName, String password) {
        sendText(userName, loginPage.userNameTxtField);
        sendText(password, loginPage.passwordTxtField);
    }
}
