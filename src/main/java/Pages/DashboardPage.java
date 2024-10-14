package Pages;

import org.openqa.selenium.By;
import static Tests.EventBookingTest.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


import static Tests.EventBookingTest.driver;

public class DashboardPage {
    public static String greetingsCssLocator = "span[class='font-14']";
    public static String eventsCssLocator = ".js_event_menu";
    public static String eventsListCssLocators = ".font-16.f-weight-medium.mb-1.mt-2";
    public static String accountCssLocator = "path[opacity='1']";
    public static String signOutLink = "Sign Out";


    public static void verifyLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the element is visible
        WebElement greetingsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(greetingsCssLocator)));

        String expectedMessage = "Greetings!";
        String actualMessage = greetingsElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public static void clickEventsOption(){
        driver.findElement(By.cssSelector(eventsCssLocator)).click();
    }

    public static void selectEventByName(String eventName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(eventsListCssLocators)));

        // Find the specific event by its text and click it
        driver.findElement(By.xpath("//a[normalize-space()='" + eventName + "']")).click();
    }

    public static void clickAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement accountElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(accountCssLocator)));
        accountElement.click();
    }

    public static void clickSignOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signOutElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(signOutLink)));
        signOutElement.click();
    }

}
