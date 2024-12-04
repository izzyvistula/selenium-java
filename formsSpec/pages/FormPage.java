package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.List;

public class FormPage {
    public void filloutTextField(WebDriver driver, String elementId, String text) {
        System.out.println("Filling out text field with ID: " + elementId + " and text: " + text);
        driver.findElement(By.id(elementId)).sendKeys(text);
    }

    public void selectDate(WebDriver driver, String dateText) {
        System.out.println("Selecting date: " + dateText);
        driver.findElement(By.id("datepicker")).sendKeys(dateText);
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
    }

    public void selectEducationLevel(WebDriver driver, String educationLevel) {
        String radioButtonId;

        switch (educationLevel) {
            case "High School":
                radioButtonId = "radio-button-1";
                break;
            case "College":
                radioButtonId = "radio-button-2";
                break;
            case "Grad School":
                radioButtonId = "radio-button-3";
                break;
            default:
                throw new IllegalArgumentException("Invalid education level: " + educationLevel);
        }

        System.out.println("Selecting educayion level: " + educationLevel);
        driver.findElement(By.id(radioButtonId)).click();
    }

    public void selectGender(WebDriver driver, String gender) {
        String checkboxId;

        switch (gender) {
            case "Male":
                checkboxId = "checkbox-1";
                break;
            case "Female":
                checkboxId = "checkbox-2";
                break;
            case "Prefer not to say":
                checkboxId = "checkbox-3";
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }

        System.out.println("Selecting gender: " + gender);
        driver.findElement(By.id(checkboxId)).click();
    }

    public void experienceDropdown(WebDriver driver) {
        System.out.println("Opening experience dropdown");
        driver.findElement(By.id("select-menu")).click();
    }

    public void selectExperience(WebDriver driver, String timeFrame) {
        experienceDropdown(driver);
        String timeFrameId;

        switch (timeFrame) {
            case "0-1":
                timeFrameId = "option[value='1']";
                break;
            case "2-4":
                timeFrameId = "option[value='2']";
                break;
            case "5-9":
                timeFrameId = "option[value='3']";
                break;
            case "10+":
                timeFrameId = "option[value='4']";
                break;
            default:
                throw new IllegalArgumentException("Invalid timeframe: " + timeFrame);
        }
        System.out.println("Selecting time frame: " + timeFrame);
        driver.findElement(By.cssSelector(timeFrameId)).click();
    }

    public void submitForm(WebDriver driver) {
        System.out.println("Clicking submit form button");
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
