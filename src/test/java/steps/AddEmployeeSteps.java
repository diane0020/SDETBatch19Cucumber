package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.DBUtils;
import utils.ExcelReader;
import utils.Log;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    private String expectedFN;
    private String expectedMN;
    private String expectedLN;
    private String employeeIdFE;
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

        //System.out.println(1/0 );
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


    @When("user enters {string}, {string} and {string}")
    public void userEntersAnd(String firstName, String middleName, String lastName) {
//        WebElement firstNameLoc = driver.findElement(By.name("firstName"));
//        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
//        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        //AddEmployeePage addEmployeePage = new AddEmployeePage();

        sendText(firstName, addEmployeePage.firstNameLoc);
        sendText(middleName, addEmployeePage.middleNameLoc);
        sendText(lastName, addEmployeePage.lastNameLoc);

        // copying the data from local variable into instance variables so that we can access it in other method.
        expectedFN = firstName;
        expectedMN = middleName;
        expectedLN = lastName;
        employeeIdFE = addEmployeePage.employeeId.getAttribute("value");
        Log.info("Setting the expected data");

    }

    @Then("employee added successfully")
    public void employeeAddedSuccessfully() {

        String query = "select emp_firstname, emp_middle_name, emp_lastname from hs_hr_employees where employee_id = " +
                "'"+employeeIdFE+"' ";
        List<Map<String, String>> data = DBUtils.fetch(query);
        Map<String, String> actualDataMap = data.getFirst();

        String actualFN = actualDataMap.get("emp_firstname");
        String actualMN = actualDataMap.get("emp_middle_name");
        String actualLN = actualDataMap.get("emp_lastname");

            Assert.assertEquals(expectedFN, actualFN);
            Assert.assertEquals(expectedMN, actualMN);
            Assert.assertEquals(expectedLN, actualLN);
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

    @When("user enters firstname, middlename and lastname from data table and verify it")
    public void user_enters_firstname_middlename_and_lastname_from_data_table_and_verify_it(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> newEmployee = dataTable.asMaps();

        for (Map<String, String> employee:newEmployee) {
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            sendText(firstNameValue, addEmployeePage.firstNameLoc);
            sendText(middleNameValue, addEmployeePage.middleNameLoc);
            sendText(lastNameValue, addEmployeePage.lastNameLoc);

            clickTheElement(addEmployeePage.saveButton);

            // to add multiple employee, I have to click on add employee
            clickTheElement(dashboardPage.addEmployee);
        }
    }

    @When("user adds multiple employees from excel and validate them")
    public void user_adds_multiple_employees_from_excel_and_validate_them() {
        List<Map<String, String>> employeeData = ExcelReader.readExcel();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        for (Map<String, String> employee : employeeData) {
            sendText(employee.get("firstName"), addEmployeePage.firstNameLoc);
            sendText(employee.get("middleName"), addEmployeePage.middleNameLoc);
            sendText(employee.get("lastName"), addEmployeePage.lastNameLoc);
            sendText(employee.get("Photograph"), addEmployeePage.photograph);

            // click the check if not selected
            if (!addEmployeePage.checkBox.isSelected()){
                clickTheElement(addEmployeePage.checkBox);
            }

            sendText(employee.get("userName"), addEmployeePage.username);
            sendText(employee.get("password"), addEmployeePage.passwordUser);
            sendText(employee.get("confirmPassword"), addEmployeePage.confirmPasswordUser);

            clickTheElement(addEmployeePage.saveButton);

            // verification is pending. homework
            String expectedURL ="http://hrm.syntaxtechs.net/humanresources/symfony/web/index" +
                    ".php/pim/viewPersonalDetails/empNumber/99074";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(expectedURL, actualURL);

            clickTheElement(dashboardPage.addEmployee);
        }
    }
}
