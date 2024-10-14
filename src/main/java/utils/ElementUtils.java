package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Tests.EventBookingTest.driver;
public class ElementUtils {
    public static void fillField(String locatorType, String locatorValue, String text, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        WebElement element = null;

        switch (locatorType.toLowerCase()) {
            case "id":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                break;
            case "name":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                break;
            case "xpath":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                break;
            case "css":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                break;
            case "class":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                break;
            case "tag":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        element.clear(); // Clear the field before entering text
        element.sendKeys(text);
    }
}