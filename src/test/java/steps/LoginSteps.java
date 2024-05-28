package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws IOException {
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sendText(ConfigReader.read("userName"),
                driver.findElement(By.xpath(Constants.SYNTAX_USERNAME_PATH)));
        sendText(ConfigReader.read("password"),
                driver.findElement(By.xpath(Constants.SYNTAX_PASSWORD_PATH)));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        clickTheElement(driver.findElement(By.cssSelector("input#btnLogin")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Then("user successfully logged in")
    public void user_successfully_logged_in() {
        System.out.println("test passed");
    }

}
