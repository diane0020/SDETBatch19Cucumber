package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        loginPage.userNameTxtField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordTxtField.sendKeys(ConfigReader.read("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //loginPage.loginButton.click();
        jsClick(loginPage.loginButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Then("user successfully logged in")
    public void user_successfully_logged_in() {
        //here we are checking if the element exist or not
        //Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());

        String expectedUrl = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }


}
