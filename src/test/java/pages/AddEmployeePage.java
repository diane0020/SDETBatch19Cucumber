package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

// page object model design
// all the locators related to add employee feature will be here
public class AddEmployeePage extends CommonMethods {

    // find by class will be used to identify the webElement using id here
    // firstNameLoc is the key which we will call is scripts
    // object repository is nothing but the locators you keep in page class

    @FindBy(id="firstName")
    public WebElement firstNameLoc;
    @FindBy(id="middleName")
    public WebElement middleNameLoc;
    @FindBy(id="lastName")
    public WebElement lastNameLoc;
    @FindBy(id="btnSave")
    public WebElement saveButton;
    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement checkBox;

    @FindBy(id="user_name")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement passwordUser;

    @FindBy(id="re_password")
    public WebElement confirmPasswordUser;

    @FindBy(id = "employeeId")
    public WebElement employeeId;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
