package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConfirmationPage {
    public void verifySuccessBanner(WebDriver driver) {
        System.out.println("Veryfing if success banner is present");
        driver.findElement(By.cssSelector(".alert.alert-success"));
    }

    public String getAlertBannerText(WebDriver driver) {
        return driver.findElement(By.className("alert")).getText();
    }

    public void verifyHeaderText(WebDriver driver, String text) {
        System.out.println("Veryfing header text is " + text);
        getAlertBannerText(driver);
        assertEquals(text, getAlertBannerText(driver));
    }
}