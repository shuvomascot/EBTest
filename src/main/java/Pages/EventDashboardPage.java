package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Tests.EventBookingTest.driver;

public class EventDashboardPage {
    public static String sidebarSeatingOption = "Seating";
    public static String createSeatingPlanButton = "//a[normalize-space()='Create Seating Plan']";
    public static String continueEditingButtonText = "Continue Editing";
    public static String enableSeatPlan = "(//span[@class='checkbox-slider'])[1]";


    public static void clickSidebarSeatingOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement seatingOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(sidebarSeatingOption)));

        seatingOptionElement.click();

        System.out.println("Clicked on sidebar seating option.");
    }

    public static void clickCreateSeatingPlanButton(){
        driver.findElement(By.xpath(createSeatingPlanButton)).click();
        System.out.println("Clicked on 'Create Seating Plan' button.");
    }

    public static void clickContinueEditingButton(){
        driver.findElement(By.linkText(continueEditingButtonText)).click();
    }

    public static void clickRelevantSeatPlanButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement createButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createSeatingPlanButton)));
            createButton.click();
            System.out.println("Clicked on 'Create Seating Plan' button.");
        } catch (Exception e) {
            try {
                WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(continueEditingButtonText)));
                continueButton.click();
                System.out.println("Clicked on 'Continue Editing' button.");
            } catch (Exception ex) {
                System.out.println("Neither button was visible.");
            }
        }
    }

    public static void clickEnableSeatPlan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement EnableSeatPlan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(enableSeatPlan)));
        EnableSeatPlan.click();
    }



//    public static void clickRelevantSeatingButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        try {
//            // Wait for the "Create Seating Plan" button first
//            WebElement createSeatingPlanButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='" + createSeatingPlanButtonText + "']")));
//            createSeatingPlanButton.click();
//            System.out.println("Clicked on: " + createSeatingPlanButton.getText());
//        } catch (Exception e) {
//            try {
//                // If "Create Seating Plan" is not found, wait for the "Continue Editing" button
//                WebElement continueEditingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='" + continueEditingButtonText + "']")));
//                continueEditingButton.click();
//                System.out.println("Clicked on: " + continueEditingButton.getText());
//            } catch (Exception ex) {
//                System.out.println("Neither 'Create Seating Plan' nor 'Continue Editing' button was found.");
//            }
//        }
//    }
}
