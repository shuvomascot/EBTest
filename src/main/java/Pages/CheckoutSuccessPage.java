package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Tests.EventBookingTest.driver;
public class CheckoutSuccessPage {
    public static String checkoutSuccessMessage = ".success-title.color-black.font-Semibold.text-center";
    public static String downloadButton = "button[class='btn-normal update_by_dynamic_color'] span";

    public static void verifyOrderCompletion() {
        // Wait for the success message element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(checkoutSuccessMessage)));

        String actualMessage = successMessageElement.getText();
        String expectedMessage = "Your order is complete!";

        // Assert that the actual message contains the expected message
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Order completion message mismatch. Actual message: " + actualMessage);
    }

    public static void clickDownloadButton(){
        driver.findElement(By.cssSelector(downloadButton)).click();
    }

    public static void clickDownloadButtonAndReturnToParent() {
        // Store the current window handle (parent window)
        String parentWindowHandle = driver.getWindowHandle();

        // Wait for the download button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement downloadButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(downloadButton)));

        // Click the download button
        downloadButtonElement.click();

        // Wait for the new tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Wait for the file to download (give it some time to finish downloading)
        try {
            // Adjust the time as per your download speed and file size
            Thread.sleep(7000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After download is complete, close the new tab
        driver.close();

        // Switch back to the parent window
        driver.switchTo().window(parentWindowHandle);
    }


    public static void goToHomepage(){
        driver.get("https://www.diywebsite.net.au/");
    }
}
