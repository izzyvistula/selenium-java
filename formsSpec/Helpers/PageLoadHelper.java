package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PageLoadHelper {

    public void waitForPageToBeLoaded(WebDriver driver, String expectedUrl, String expectedClass) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        WebElement loadedClass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(expectedClass)));

        if (loadedClass != null) {
            System.out.println("Success banner is visible: " + loadedClass.getText());
        } else {
            throw new IllegalStateException("Success banner did not appear!");
        }
    }
}