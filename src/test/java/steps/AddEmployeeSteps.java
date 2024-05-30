package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @And("user clicks on Add Employee option")
    public void userClicksOnAddEmployeeOption() {
        //WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
        clickTheElement(dashboardPage.addEmployee);
    }

    @When("user enters firstname, middlename and lastname")
    public void userEntersFirstnameMiddlenameAndLastname() {
//        WebElement firstNameLoc = driver.findElement(By.id("firstName"));
//        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
//        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        //AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText("diane", addEmployeePage.firstNameLoc);
        sendText("MS", addEmployeePage.middleNameLoc);
        sendText("jenga", addEmployeePage.lastNameLoc);

    }

    @And("user enters clicks the save button")
    public void userEntersClicksTheSaveButton() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        //WebElement saveBtn = driver.findElement(By.id("btnSave"));
        clickTheElement(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employeeAddedSuccessfully() {
        System.out.println("Employee Added");
    }

    @When("user enters {string}, {string} and {string}")
    public void userEntersAnd(String firstName, String middleName, String lastName) {
//        WebElement firstNameLoc = driver.findElement(By.name("firstName"));
//        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
//        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        //AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(firstName, addEmployeePage.firstNameLoc);
        sendText(middleName, addEmployeePage.middleNameLoc);
        sendText(lastName, addEmployeePage.lastNameLoc);
    }


    @When("user enters {string}, and {string} and {string}.")
    public void userEntersAndAnd(String fn, String mn, String ln) {
        // as we have declared it in th
//        WebElement firstNameLoc = driver.findElement(By.name("firstName"));
//        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
//        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        //AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(fn, addEmployeePage.firstNameLoc);
        sendText(mn, addEmployeePage.middleNameLoc);
        sendText(ln, addEmployeePage.lastNameLoc);
    }
}
