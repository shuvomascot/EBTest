package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Tests.EventBookingTest.driver;


public class Homepage {

    public static String accountCssLocator = "path[opacity='1']";
    public static String signInButtonCssLocator = "a[aria-label='SignIn']";

    public static String cookieAcceptButton = "#wt-cli-accept-all-btn";

    public static void clickAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement AccountCssLocator = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(accountCssLocator)));
        AccountCssLocator.click();
    }

    public static void clickSignInButton(){
        driver.findElement(By.cssSelector(signInButtonCssLocator)).click();
    }

    public static void acceptCookiesIfPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the cookie accept button to be clickable, with a timeout of 5 seconds
            WebElement cookieAcceptButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cookieAcceptButton)));

            // If the cookie button is visible, click it
            if (cookieAcceptButtonElement.isDisplayed()) {
                cookieAcceptButtonElement.click();
                System.out.println("Cookies accepted.");
            }
        } catch (Exception e) {
            // If the cookie accept button is not found or not visible, do nothing
            System.out.println("Cookie accept button not visible, moving forward.");
        }
    }


}
