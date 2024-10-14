package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Tests.EventBookingTest.driver;

import java.time.Duration;

public class SeatPlanPage {
    public static String seatingElement = "(//div[@class='row-tool blockbuilder-content-tool'])[4]";
    public static String dragArea = ".empty-state-wrap";
    public static String continueButton = "//span[normalize-space()='Continue']";
    public static String canvasElement = "//div[@role='presentation']//canvas";
    public static String assignTicketsOption = ".k-input-value-text";
    public static String assignTicketButton = "(//span[@class='k-switch-label-on'])[4]";
    public static String seatSaveButton = "//span[normalize-space()='Save']";
    public static String purchaseContinueButton = "//span[normalize-space()='Auto select & Continue']";

    public static void dragSeatingToArea() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for seating element to be visible
        WebElement seatingElementToDrag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seatingElement)));

        // Wait for the drag area to be visible
        WebElement dragAreaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(dragArea)));

        // Use Actions class to perform drag and drop
        Actions action = new Actions(driver);
        action.clickAndHold(seatingElementToDrag)
                .moveToElement(dragAreaElement)
                .release()
                .build()
                .perform();
    }

    public static void clickContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement ContinueButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continueButton)));
        ContinueButtonElement.click();
    }

    public static void clickOnCanvas(int x, int y) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the canvas element to be visible
        WebElement canvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(canvasElement)));

        // Ensure the canvas is clickable
        wait.until(ExpectedConditions.elementToBeClickable(canvas));

        // Get the dimensions of the canvas
        int canvasWidth = canvas.getSize().getWidth();
        int canvasHeight = canvas.getSize().getHeight();

        // Ensure the coordinates are within the canvas bounds
        if (x >= 0 && x <= canvasWidth && y >= 0 && y <= canvasHeight) {
            // Use Actions class to click at specific coordinates
            Actions action = new Actions(driver);
            action.moveToElement(canvas, x, y).click().perform();
            System.out.println("Clicked on Canvas");
        } else {
            System.out.println("Coordinates are out of canvas bounds.");
        }
    }


    public static void clickTicketOption(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement AssignTicketsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(assignTicketsOption)));
        AssignTicketsOption.click();
    }

    public static void selectTicketType(String ticketName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement selectTicketType = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='k-list-item-text'][normalize-space()='" + ticketName + "']")));
        selectTicketType.click();
    }

    public static void clickAssignTicketButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement AssignTicketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assignTicketButton)));
        AssignTicketButton.click();
    }

    public static void clickSeatSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement SeatSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seatSaveButton)));
        SeatSaveButton.click();
    }
    public static void clickPurchaseContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement SeatSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(purchaseContinueButton)));
        SeatSaveButton.click();
    }
}
