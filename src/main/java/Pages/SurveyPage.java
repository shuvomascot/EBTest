package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Tests.EventBookingTest.driver;

public class SurveyPage {
    public static String firstNameField = ".formeo_first_name";
    public static String lastNameField = ".formeo_last_name";
    public static String longAnswerField = ".f-field-group > textarea";
    public static String surveyFormNextAndFinishButton = "#next-btn";
    public static String surveyCompleteMessage = "//h3[normalize-space()='Congratulations!']";

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

    public static void fillFirstNameField(){
        fillField("css", firstNameField, "Shuvo", 10);
    }

    public static void fillLastNameField(){
        fillField("css",lastNameField, "Ali", 10);
    }

    public static void fillLongAnswerField(){
        fillField("css",longAnswerField, "Very Good Service", 10);
    }

    public static void clickSurveyFormNextAndFinishButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement SurveyFormNextAndFinishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(surveyFormNextAndFinishButton)));
        SurveyFormNextAndFinishButton.click();
    }

    public static void verifySuccessfulFormSubmission(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the element is visible
        WebElement greetingsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(surveyCompleteMessage)));

        String expectedMessage = "Congratulations!";
        String actualMessage = greetingsElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


}


