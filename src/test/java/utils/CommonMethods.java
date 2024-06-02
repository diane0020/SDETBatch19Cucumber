package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() throws IOException {

        switch (ConfigReader.read("browser")) {
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "Edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("invalid Browser name");
        }
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));

        // initialize all the objects for page
        initializePageObjects();
    }

    public static WebDriver openBrowserAndLaunchApplication(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void selectFromDropDown(WebElement dropDown, int index) {

        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    public static void selectFromDropDown(WebElement dropDown, String visibleText) {

        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public static void selectFromDropDown(String value, WebElement dropDown) {

        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public static void sendText(String text, WebElement element) {
        // clear the element first
        element.clear();

        // send the text to element
        element.sendKeys(text);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForElementToBeClicked(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void clickTheElement(WebElement element) {
        waitForElementToBeClicked(element);
        element.click();
    }

    //take screenshot
    public static byte[] takeScreenshot(String fileName) {

        TakesScreenshot screenshot =(TakesScreenshot) driver;
        byte[] arrayOfPicture = screenshot.getScreenshotAs(OutputType.BYTES);
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILE_PATH + fileName + " " + getTimeStamp(
                    "dd-MMM-yyyy-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return arrayOfPicture;
    }

    public static String getTimeStamp(String datePattern) {

        Date date = new Date();

        // date format: yyyy-MM-dd-hh-mm-ss
        // to get the date in my acceptable format, i need to format it
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        return sdf.format(date);
    }



    //checkboxes
    //radiobutton
    //jsclick
}



