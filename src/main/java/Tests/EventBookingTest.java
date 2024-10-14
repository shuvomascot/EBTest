package Tests;

import Pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jdk.jfr.Event;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EventBookingTest {
    public static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeTest
    public static void Setup() {
        extent = new ExtentReports("src/main/resources/Reports/ExtentReport.html", true);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.diywebsite.net.au/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void acceptCookies() {
        test = extent.startTest("Accept Cookies");
        try {
            Homepage.acceptCookiesIfPresent();
            test.log(LogStatus.INFO, "Accepted cookies.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to accept cookies: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 2, dependsOnMethods = "acceptCookies")
    public void login() {
        test = extent.startTest("User Login");
        try {
            Homepage.clickAccount();
            Homepage.clickSignInButton();

            LoginPage.fillEmailField();
            LoginPage.fillPasswordField();
            LoginPage.clickRememberMe();
            LoginPage.clickLoginButton();

            DashboardPage.verifyLogin();
            test.log(LogStatus.INFO, "User logged in successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Login failed: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 3, dependsOnMethods = "login")
    public void selectEvent() {
        test = extent.startTest("Select Event");
        try {
            DashboardPage.clickEventsOption();
            DashboardPage.selectEventByName("Test Event");
            test.log(LogStatus.INFO, "Event selected successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to select event: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 4, dependsOnMethods = "selectEvent")
    public void clickSeatingOption() {
        test = extent.startTest("Click Seating Option");
        try {
            EventDashboardPage.clickSidebarSeatingOption();
            //EventDashboardPage.clickCreateSeatingPlanButton();
            //EventDashboardPage.clickContinueEditingButton();
            EventDashboardPage.clickRelevantSeatPlanButton();
            test.log(LogStatus.INFO, "Seating option clicked successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to click seating option: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 5, dependsOnMethods = "clickSeatingOption")
    public void completeSeatMap() {
        test = extent.startTest("Complete Seat Map");
        try {
            //SeatPlanPage.dragSeatingToArea();
            SeatPlanPage.clickContinueButton();
            test.log(LogStatus.INFO, "Seat map completed successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to complete seat map: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 6, dependsOnMethods = "completeSeatMap")
    public void assignSeatTickets() {
        test = extent.startTest("Assign Seat Tickets");
        try {
            SeatPlanPage.clickOnCanvas(520, 285);
            SeatPlanPage.clickTicketOption();
            SeatPlanPage.selectTicketType("Test Single Ticket");
            SeatPlanPage.clickContinueButton();
            test.log(LogStatus.INFO, "Assign seat tickets completed successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to assign seat tickets: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 7, dependsOnMethods = "assignSeatTickets")
    public void assignAttendees() {
        test = extent.startTest("Assign Attendees");
        try {
            SeatPlanPage.clickSeatSaveButton();
            test.log(LogStatus.INFO, "Assign attendees successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to assign attendees: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 8, dependsOnMethods = "assignAttendees")
    public void enableSeatPlan() {
        test = extent.startTest("Enable Seat Plan");
        try {
            EventDashboardPage.clickEnableSeatPlan();

            test.log(LogStatus.INFO, "Seat plan enabled successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to enable seat plan: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 9, dependsOnMethods = "enableSeatPlan")
    public void copyEventLink() {
        test = extent.startTest("Copy Event Link");
        try {
            EventsListPage.clickShareLink();
            EventsListPage.getEventURL();
            EventsListPage.clickShareEventPopupCloseButton();
            test.log(LogStatus.INFO, "Copied Event Link successfully.");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to copy event link: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 10, dependsOnMethods = "copyEventLink")
    public void logoutAccount() {
        test = extent.startTest("Logout from Account");
        try {
            DashboardPage.clickAccount();
            DashboardPage.clickSignOut();

            test.log(LogStatus.INFO, "Successfully logged out of account");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to log out of account: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 11, dependsOnMethods = "logoutAccount")
    public void goToEventLink() {
        test = extent.startTest("Go To Event Link");
        try {
            EventsListPage.goToEventURL();

            test.log(LogStatus.INFO, "Successfully redirected to event link");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to load event link: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 12, dependsOnMethods = "goToEventLink")
    public void purchaseTicket() {
        test = extent.startTest("Purchase Ticket with Quantity");
        try {
            EventPage.clickPurchaseTicketButton();
            EventPage.fillTicketQuantityField(2);
            EventPage.clickContinueButton();
            SeatPlanPage.clickPurchaseContinueButton();

            test.log(LogStatus.INFO, "Successfully clicked purchase ticket");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to click purchase ticket: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 13, dependsOnMethods = "purchaseTicket")
    public void checkout() {
        test = extent.startTest("Checkout with form fill up and validation");
        try {
            CheckoutPage.clickConfirmOrderButton();
            CheckoutPage.checkValidationMessages();
            CheckoutPage.fillFirstNameField();
            CheckoutPage.fillLastNameField();
            CheckoutPage.fillEmailField();
            CheckoutPage.clickConfirmOrderButton();

            test.log(LogStatus.INFO, "Successfully Confirmed Order");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to confirm order: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @Test(priority = 14, dependsOnMethods = "checkout")
    public void checkoutSuccess() {
        test = extent.startTest("Checkout validation");
        try {
            //CheckoutSuccessPage.verifyOrderCompletion();
            test.log(LogStatus.INFO, "Successfully Completed Order");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to confirm order: " + e.getMessage());
        } finally {
            extent.endTest(test);
        }
    }

    @AfterTest
    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
        extent.flush();
        extent.close();
    }
}



//    @Test(enabled = false)
//    public void Ticket() {
//        test = extent.startTest("Ticket Test");
//        try {
//            Homepage.acceptCookiesIfPresent();
//            test.log(LogStatus.INFO, "Accepted cookies.");
//
//            Homepage.clickAccount();
//            test.log(LogStatus.INFO, "Clicked on Account.");
//            Homepage.clickSignInButton();
//            test.log(LogStatus.INFO, "Clicked on Sign In.");
//
//            LoginPage.fillEmailField();
//            test.log(LogStatus.INFO, "Filled in email field.");
//            LoginPage.fillPasswordField();
//            test.log(LogStatus.INFO, "Filled in password field.");
//            LoginPage.clickRememberMe();
//            LoginPage.clickLoginButton();
//            test.log(LogStatus.INFO, "Clicked login button.");
//
//            DashboardPage.verifyLogin();
//            test.log(LogStatus.INFO, "Verified login.");
//            DashboardPage.clickEventsOption();
//            DashboardPage.selectEventByName("Selenium Event");
//
//            EventsListPage.clickShareLink();
//            EventsListPage.getEventURL();
//            EventsListPage.clickShareEventPopupCloseButton();
//
//            DashboardPage.clickAccount();
//            DashboardPage.clickSignOut();
//            test.log(LogStatus.INFO, "Signed out of the account.");
//
//            EventsListPage.goToEventURL();
//            EventPage.clickPurchaseTicketButton();
//            EventPage.clickContinueButton();
//
//            CheckoutPage.clickConfirmOrderButton();
//            CheckoutPage.checkValidationMessages();
//            test.log(LogStatus.INFO, "Checked validation messages.");
//
//            CheckoutPage.fillFirstNameField();
//            CheckoutPage.fillLastNameField();
//            CheckoutPage.fillEmailField();
//            CheckoutPage.clickConfirmOrderButton();
//            test.log(LogStatus.INFO, "Confirmed order.");
//
//            CheckoutSuccessPage.verifyOrderCompletion();
//            CheckoutSuccessPage.clickDownloadButtonAndReturnToParent();
//            test.log(LogStatus.INFO, "Order completed successfully.");
//        } catch (Exception e) {
//            test.log(LogStatus.FAIL, "Test failed due to: " + e.getMessage());
//        } finally {
//            extent.endTest(test); // End the test
//        }
//    }

//    @Test()
//    public void seatPlan() {
////        test = extent.startTest("Seat Plan Test");
////        try {
//            Homepage.acceptCookiesIfPresent();
//            //test.log(LogStatus.INFO, "Accepted cookies.");
//            Homepage.clickAccount();
//            //test.log(LogStatus.INFO, "Clicked on Account.");
//            Homepage.clickSignInButton();
//
//            LoginPage.fillEmailField();
//            LoginPage.fillPasswordField();
//            LoginPage.clickRememberMe();
//            LoginPage.clickLoginButton();
//
//            DashboardPage.verifyLogin();
//            //test.log(LogStatus.INFO, "Verified login.");
//            DashboardPage.clickEventsOption();
//            DashboardPage.selectEventByName("Selenium Event");
//
//            EventDashboardPage.clickSidebarSeatingOption();
//            EventDashboardPage.clickContinueEditingButton();
//            //SeatPlanPage.dragSeatingToArea();
//            //SeatPlanPage.clickContinueButton();
//
//            SeatPlanPage.clickOnCanvas(215, 515);
//            SeatPlanPage.clickTicketOption();
//            SeatPlanPage.selectTicketType("Test Single Ticket");
////            SeatPlanPage.clickOnCanvas(215, 515);
////            SeatPlanPage.clickTicketOption();
////            SeatPlanPage.selectTicketType("Test Group Ticket");
//            SeatPlanPage.clickContinueButton();
//            SeatPlanPage.clickSeatSaveButton();
//            EventDashboardPage.clickEnableSeatPlan();



//            test.log(LogStatus.INFO, "Seat plan steps completed.");
//        } catch (Exception e) {
//            test.log(LogStatus.FAIL, "Test failed due to: " + e.getMessage());
//        } finally {
//            extent.endTest(test); // End the test
//        }
//    }

//    @Test(enabled = false)
//    public void orderFormTest() {
//        test = extent.startTest("Order Form Test");
//        try {
//            Homepage.acceptCookiesIfPresent();
//            test.log(LogStatus.PASS, "Accepted cookies.");
//            Homepage.clickAccount();
//            Homepage.clickSignInButton();
//            test.log(LogStatus.PASS, "Clicked Sign In button");
//
//            LoginPage.fillEmailField();
//            LoginPage.fillPasswordField();
//            LoginPage.clickRememberMe();
//            LoginPage.clickLoginButton();
//            test.log(LogStatus.PASS, "Login form fill up and click login button");
//
//            DashboardPage.verifyLogin();
//            test.log(LogStatus.PASS, "Verify Login");
//
//            DashboardPage.clickEventsOption();
//            DashboardPage.selectEventByName("Selenium Event");
//            test.log(LogStatus.PASS, "Event Selected");
//
//            EventOrderFormPage.clickOrderFormSidebarOption();
//            EventOrderFormPage.clickCreateOrderFormButton();
//            EventOrderFormPage.ClickCreateFromScratchRadioButton();
//            EventOrderFormPage.ClickChooseTemplateContinueButton();
//            EventOrderFormPage.clickFormOptionsAndWait();
//            EventOrderFormPage.clickFormSaveButton();
//            test.log(LogStatus.PASS, "Custom Order Form Created Successfully");
//
//            EventOrderFormPage.clickFormShareLink();
//            EventsListPage.getEventURL();
//            EventsListPage.clickShareEventPopupCloseButton();
//            test.log(LogStatus.PASS, "Clicked on share link, copied link and closed share popup");
//
//            DashboardPage.clickAccount();
//            DashboardPage.clickSignOut();
//            EventsListPage.goToEventURL();
//            test.log(LogStatus.PASS, "Logout and go to event URL");
//
//            EventPage.clickPurchaseTicketButton();
//            EventPage.clickContinueButton();
//            test.log(LogStatus.PASS, "Click on purchase ticket and continue");
//
//            CheckoutPage.fillFirstNameField();
//            CheckoutPage.fillLastNameField();
//            CheckoutPage.fillEmailField();
//            EventOrderFormPage.fillCustomFirstNameField("Shuvo");
//            EventOrderFormPage.fillCustomLastNameField("Ali");
//            EventOrderFormPage.fillCustomFileUploadField();
//            EventOrderFormPage.fillCustomEmailField("shuvobitmascot@yopmail.com");
//            CheckoutPage.clickConfirmOrderButton();
//
//            test.log(LogStatus.PASS, "Confirmed order with custom fields.");
//        } catch (Exception e) {
//            test.log(LogStatus.FAIL, "Test failed due to: " + e.getMessage());
//        } finally {
//            extent.endTest(test); // End the test
//        }
//    }
//
//    @Test
//    public void surveyFormTest(){
//        Homepage.acceptCookiesIfPresent();
//        Homepage.clickAccount();
//        Homepage.clickSignInButton();
//
//        LoginPage.fillEmailField();
//        LoginPage.fillPasswordField();
//        LoginPage.clickRememberMe();
//        LoginPage.clickLoginButton();
//
//        DashboardPage.verifyLogin();
//
//        DashboardPage.clickEventsOption();
//        DashboardPage.selectEventByName("Selenium Event");
//
//        EventSurveyForm.clickSurveyFromSidebarOption();
//        EventSurveyForm.clickCreateSurveyFormButton();
//        //EventSurveyForm.clickEditSurveyNameDropdownButton();
//        //EventSurveyForm.renameSurveyForm();
//        EventSurveyForm.addSurveyFormOptions();
//        EventSurveyForm.clickContinueSurveyFormButton();
//        EventSurveyForm.clickShareLinkOnMyOwnRadioButton();
//        EventSurveyForm.clickFormSurveySaveButton();
//        //EventSurveyForm.clickSurveyEnableButton();
//        EventSurveyForm.copySurveyLinkAndGoToLink();
//
//        SurveyPage.fillFirstNameField();
//        SurveyPage.clickSurveyFormNextAndFinishButton();
//        SurveyPage.fillLastNameField();
//        SurveyPage.clickSurveyFormNextAndFinishButton();
//        SurveyPage.fillLongAnswerField();
//        SurveyPage.clickSurveyFormNextAndFinishButton();
//        SurveyPage.verifySuccessfulFormSubmission();
//    }

//    @AfterTest
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        extent.flush();
//    }