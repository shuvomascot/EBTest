package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.Random;

import static Tests.EventBookingTest.driver;
public class EventOrderFormPage {
    public static String orderFormSidebarOption = ".js_attendee_form_menu";
    public static String createOrderFormButton = "//button[normalize-space()='Create Order Form']";
    public static String createFromScratchRadioButton = "(//i[@class='b-input'])[1]";
    public static String chooseTemplateContinueButton = ".wc-btn-normal.btn-attendee-footer.continue-attendee-form";
    public static String formFirstNameOption = "//button[normalize-space()='First Name']";
    public static String formLastNameOption = "//button[normalize-space()='Last Name']";
    public static String formEmailOption = "//button[normalize-space()='Email Address']";
    public static String formFileUploadOption = "//button[normalize-space()='File Upload']";
    public static String formSaveButton = ".wc-btn-normal.btn-attendee-footer.save-attendee-form";
    public static String formShareLink = "Share";

    public static String customFormFirstNameField = ".formeo_first_name";
    public static String customFormLastNameField = ".formeo_last_name";
    public static String customFormFileUploadField = "#f-daad3ee7-8f6e-417a-ac40-0f91f3431c99";
    public static String customFormEmailField = "formeo_email_address";

    public static void clickOrderFormSidebarOption(){
        driver.get("https://www.diywebsite.net.au/b/org/events/attendee-details/fb4c921a-b35b-48d3-86ae-0ef35230180a");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement OrderFormSidebarOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/b/org/events/attendee-details/fb4c921a-b35b-48d3-86ae-0ef35230180a']")));
//        OrderFormSidebarOptionElement.click();
    }

    public static void clickCreateOrderFormButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement CreateOrderFormButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createOrderFormButton)));
        CreateOrderFormButtonElement.click();
    }

    public static void ClickCreateFromScratchRadioButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement CreateOrderFormButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createFromScratchRadioButton)));
        CreateOrderFormButtonElement.click();
    }

    public static void ClickChooseTemplateContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement ChooseTemplateContinueButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(chooseTemplateContinueButton)));
        ChooseTemplateContinueButtonElement.click();
    }

    public static void clickRandomTemplateElement() {
        // Create an instance of Random
        Random random = new Random();

        // Generate a random number between 1 and 7
        int randomNumber = random.nextInt(7) + 1; // nextInt(7) generates 0-6, adding 1 gives 1-7

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='b-input'])")));

        // Find the specific event by its text and click it
        driver.findElement(By.xpath("(//i[@class='b-input'])['" + randomNumber + "']")).click();
        System.out.println("Clicked on random element at index: " + randomNumber);
    }

    public static void clickFormOptionsAndWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the form elements to be visible
        WebElement formFirstNameOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formFirstNameOption)));
        WebElement formLastNameOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formLastNameOption)));
        WebElement formFileUploadOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formFileUploadOption)));
        WebElement formEmailOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formEmailOption)));

        formFirstNameOptionElement.click();
        formLastNameOptionElement.click();
        //formFileUploadOptionElement.click();
        //formEmailOptionElement.click();

        System.out.println("All elements clicked and added to the drag area.");
    }

    public static void clickFormSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement ClickFormSaveButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formSaveButton)));
        ClickFormSaveButtonElement.click();
    }

    public static void clickFormShareLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement ClickFormShareLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(formShareLink)));
        ClickFormShareLinkElement.click();
    }

    public static void fillCustomFirstNameField(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(customFormFirstNameField)));
        firstNameField.sendKeys(firstName);
    }

    public static void fillCustomLastNameField(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(customFormLastNameField)));
        lastNameField.sendKeys(lastName);
    }

    public static void fillCustomFileUploadField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fileUploadField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='f-bf5df2cb-b809-40ee-af04-4cd694d8c54e']")));
        fileUploadField.sendKeys("C:\\Users\\shuvo.a\\Desktop\\sample.pdf");
    }

    public static void fillCustomEmailField(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(customFormEmailField)));
        emailField.sendKeys(email);
    }
}
