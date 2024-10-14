package Pages;

import org.openqa.selenium.By;

import static Tests.EventBookingTest.driver;

public class LoginPage {
    public static String emailIdLocator = "Email";
    public static String passwordIdLocator = "Password";
    public static String rememberMeCssLocator = ".b-input";
    public static String loginButtonCssLocator = "button[type='submit']";

    public static void fillEmailField(){
        driver.findElement(By.id(emailIdLocator)).sendKeys("shuvo.mascot@gmail.com");
    }

    public static void fillPasswordField(){
        driver.findElement(By.id(passwordIdLocator)).sendKeys("P@ss123!");
    }
    public static void clickRememberMe(){
        driver.findElement(By.cssSelector(rememberMeCssLocator)).click();
    }

    public static void clickLoginButton(){
        driver.findElement(By.cssSelector(loginButtonCssLocator)).click();
    }
}
