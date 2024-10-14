package Pages;

import org.openqa.selenium.By;

import static Tests.EventBookingTest.driver;

public class EventsListPage {
    public static String shareLinkTextLocator = "Share";
    public static String eventShareLinkIdLocator = "event_url";
    public static String shareEventPopupCloseButton = "//*[@id='share_event_modal']/div/div/div[1]/button";

    private static String eventURL;

    public static void clickShareLink(){
        driver.findElement(By.linkText(shareLinkTextLocator)).click();
    }

    public static void getEventURL(){
        eventURL = driver.findElement(By.id(eventShareLinkIdLocator)).getAttribute("value");
        System.out.println("The Share URL is: " + eventURL);
    }

    public static void goToEventURL() {
        if (eventURL != null && !eventURL.isEmpty()) {
            driver.get(eventURL);
        } else {
            System.out.println("No URL found. Make sure to call getEventURL() first.");
        }
    }
    public static void clickShareEventPopupCloseButton(){
        driver.findElement(By.xpath(shareEventPopupCloseButton)).click();
    }
}
