package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath="//input[@name='txtUsername']")
    public WebElement userNameTxtField;

    @FindBy(xpath = "//input[@id = 'txtPassword']")
    public WebElement passwordTxtField;

    @FindBy(xpath = "//input[@name='Submit']")
    public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
}
