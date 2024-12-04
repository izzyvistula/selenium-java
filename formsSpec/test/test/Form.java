package test.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Helpers.PageLoadHelper;

import pages.ConfirmationPage;
import pages.FormPage;


public class Form {
    private static String[] args;

    public static void main(String[] args) {
        Form.args = args;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        FormPage formPage = new FormPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        PageLoadHelper pageLoadHelper = new PageLoadHelper();

        driver.get("https://formy-project.herokuapp.com/form");

        formPage.filloutTextField(driver, "first-name", "Jon");
        formPage.filloutTextField(driver, "last-name", "Doe");
        formPage.filloutTextField(driver, "job-title", "Test Engineer");
        formPage.selectEducationLevel(driver, "College");
        formPage.selectGender(driver, "Female");
        formPage.selectExperience(driver, "5-9");
        formPage.selectDate(driver, "01/10/2025");
        formPage.submitForm(driver);
        pageLoadHelper.waitForPageToBeLoaded(driver, "https://formy-project.herokuapp.com/thanks", "alert-success");
        confirmationPage.verifySuccessBanner(driver);
        confirmationPage.verifyHeaderText(driver, "The form was successfully submitted!");
        driver.quit();
    }
}
