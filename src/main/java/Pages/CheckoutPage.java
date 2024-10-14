package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Tests.EventBookingTest.driver;

public class CheckoutPage {
    public static String formFirstName = "firstName";
    public static String formFirstNameValidationMessage = "firstName-error";
    public static String formLastName = "last-name";
    public static String formLastNameValidationMessage = "last-name";
    public static String formEmail = "email";
    public static String formEmailValidationMessage = "email-error";
    public static String confirmOrderButton = "updatebilling";


    public static void fillFirstNameField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(formFirstName)));
        firstNameField.sendKeys("John");
    }

    public static void fillLastNameField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(formLastName)));
        lastNameField.sendKeys("Smith");
    }

    public static void fillEmailField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(formEmail)));
        emailField.sendKeys("johnsmitheventbooking123@yopmail.com");
    }

    public static void clickConfirmOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the element is visible
        WebElement ConfirmOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirmOrderButton)));
        ConfirmOrderButton.click();
    }

    public static void checkValidationMessages() {
        boolean isValid = true;

        // Check first name validation
        WebElement firstNameField = driver.findElement(By.id(formFirstName));
        if (firstNameField.getAttribute("value").isEmpty()) {
            String firstNameError = driver.findElement(By.id(formFirstNameValidationMessage)).getText();
            System.out.println("First Name Validation Message: " + firstNameError);
            isValid = false;
        }

        // Check last name validation
        WebElement lastNameField = driver.findElement(By.id(formLastName));
        if (lastNameField.getAttribute("value").isEmpty()) {
            String lastNameError = driver.findElement(By.id(formLastNameValidationMessage)).getText();
            System.out.println("Last Name Validation Message: " + lastNameError);
            isValid = false;
        }

        // Check email validation
        WebElement emailField = driver.findElement(By.id(formEmail));
        if (emailField.getAttribute("value").isEmpty()) {
            String emailError = driver.findElement(By.id(formEmailValidationMessage)).getText();
            System.out.println("Email Validation Message: " + emailError);
            isValid = false;
        }

        if (isValid) {
            System.out.println("All fields are valid. Proceeding with the order.");
        } else {
            System.out.println("There are validation errors. Please correct the form.");
        }
    }
}
