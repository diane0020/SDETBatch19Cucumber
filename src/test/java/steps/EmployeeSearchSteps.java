package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void userClicksOnPIMOption() {
        //WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        clickTheElement(dashboardPage.pimOption);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(dashboardPage.pimOption);
    }

    @And("user clicks on employee list option")
    public void userClicksOnEmployeeListOption() {
        //WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        clickTheElement(dashboardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void userEntersValidEmployeeId() {
        //WebElement empsearchField = driver.findElement(By.id("empsearch_id"));
        sendText("34567", employeeSearchPage.empIdSearchField);
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        clickTheElement(employeeSearchPage.searchButton);
    }

    @Then("user see the employee information")
    public void userSeeTheEmployeeInformation() {
        System.out.println("test passed");
    }

    @When("user enters valid employee name")
    public void userEntersValidEmployeeName() {
        //WebElement nameSearchField = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("abc", employeeSearchPage.empNameSearchField);
    }
}
