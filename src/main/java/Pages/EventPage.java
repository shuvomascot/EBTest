package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Tests.EventBookingTest.driver;

public class EventPage {
    public static String purchaseTicketButton = "div[id='bottomPurchaseBtn'] button[type='button']";
    public static String continueButton = "checkoutButton";

    public static void clickPurchaseTicketButton(){
        driver.findElement(By.cssSelector(purchaseTicketButton)).click();
    }

    public static void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(continueButton)));
        continueButtonElement.click();
    }

}
