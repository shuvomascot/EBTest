package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Tests.EventBookingTest.driver;

public class EventSurveyForm {
    public static String surveyFromSidebarOption = "Survey Form";
    public static String createSurveyFormButton = "//button[normalize-space()='Create Survey']";
    public static String createSurveysButton = ".wc-btn-normal.btn-medium.medium.text-nowrap.addSurveyForm";
    public static String editSurveyNameDropdownButton = "//button[@id='dropdownMenuButton']//*[name()='svg']";
    public static String editSurveyNamePopupNameField = "edit-popup-title";
    public static String saveFormNameButton = "button[onclick='saveTitle()']";
    public static String formFirstNameOption = "//button[normalize-space()='First Name']";
    public static String formLastNameOption = "//button[normalize-space()='Last Name']";
    public static String formLongAnswerOption = "//button[normalize-space()='Long Answer']";
    public static String formContinueButton = "#continue-survey-form-btn";
    public static String shareLinkOnMyOwnRadioButton = "(//div[@class='b-input'])[2]";
    public static String saveSurveyFormButton = "#save-and-published-btn";
    public static String surveyEnableButton = "(//span[@class='checkbox-slider'])[1]";


    public static void clickSurveyFromSidebarOption(){
        //https://www.diywebsite.net.au/b/org/surveys/survey-details/fb4c921a-b35b-48d3-86ae-0ef35230180a
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ClickSurveyFromSidebarOptionElement = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(surveyFromSidebarOption)));
        ClickSurveyFromSidebarOptionElement.click();
    }

    public static void clickCreateSurveyFormButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check if the first button (XPath) is visible
        List<WebElement> createSurveyFormButtonList = driver.findElements(By.xpath(createSurveyFormButton));
        if (!createSurveyFormButtonList.isEmpty() && createSurveyFormButtonList.get(0).isDisplayed()) {
            WebElement createSurveyFormButton = wait.until(ExpectedConditions.elementToBeClickable(createSurveyFormButtonList.get(0)));
            createSurveyFormButton.click();
            System.out.println("Clicked the Create Survey Form Button (XPath).");
            return; // Exit function after clicking the button
        }

        // Check if the second button (CSS Selector) is visible
        List<WebElement> createSurveysButtonList = driver.findElements(By.cssSelector(createSurveysButton));
        if (!createSurveysButtonList.isEmpty() && createSurveysButtonList.get(0).isDisplayed()) {
            WebElement createSurveysButton = wait.until(ExpectedConditions.elementToBeClickable(createSurveysButtonList.get(0)));
            createSurveysButton.click();
            System.out.println("Clicked the Create Surveys Button (CSS Selector).");
        }
    }
    public static void clickEditSurveyNameDropdownButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ClickEditSurveyNameDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editSurveyNameDropdownButton)));
        ClickEditSurveyNameDropdownButton.click();
    }

    public static void renameSurveyForm(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement FillEditSurveyNamePopupNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id(editSurveyNamePopupNameField)));
        FillEditSurveyNamePopupNameField.clear();
        FillEditSurveyNamePopupNameField.sendKeys("Test Survey Form");

        WebElement SaveFormNameButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(saveFormNameButton)));
        SaveFormNameButton.click();
    }

    public static void addSurveyFormOptions(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the form elements to be visible
        WebElement FormFirstNameOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formFirstNameOption)));
        WebElement FormLastNameOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formLastNameOption)));
        WebElement FormLongAnswerOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formLongAnswerOption)));

        FormFirstNameOptionElement.click();
        FormLastNameOptionElement.click();
        FormLongAnswerOptionElement.click();

        System.out.println("All elements clicked and added to the drag area.");
    }
    public static void clickContinueSurveyFormButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement FormContinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(formContinueButton)));
        FormContinueButton.click();
    }

    public static void clickShareLinkOnMyOwnRadioButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement ShareLinkOnMyOwnRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(shareLinkOnMyOwnRadioButton)));
        ShareLinkOnMyOwnRadioButton.click();
    }

    public static void clickFormSurveySaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement SaveSurveyFormButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(saveSurveyFormButton)));
        SaveSurveyFormButton.click();
    }

    public static void clickSurveyEnableButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement SurveyEnableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(surveyEnableButton)));
        SurveyEnableButton.click();
    }

    public static void clickSurveyOption(){
        driver.findElement(By.xpath("(//button[@id='dropdownMenuButton'])[1]")).click();
    }

    public static void copySurveyLinkAndGoToLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Find the element containing the link you want to copy
        WebElement surveyOptionElement = wait.until((ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='path'])[39]"))));
        surveyOptionElement.click();

        WebElement linkElement =  driver.findElement(By.xpath("(//button[@class='dropdown-item'][normalize-space()='Copy Link'])[1]"));

        String surveyLink = linkElement.getAttribute("data-href");
        System.out.println("Survey Link: "+ surveyLink);

        driver.get(surveyLink);
    }

//    public static void clickSurveyCopyLink(){
//        driver.findElement(By.xpath("(//button[@class='dropdown-item'][normalize-space()='Copy Link'])[1]")).click();
//    }

}
