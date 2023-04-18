package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    // Verifying that Upon clicking on the "Sign In" link, user is navigated to Sign in page
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Locating the SignIn link element and performing the click operation on it
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid Page Flow..!", expectedMessage, actualMessage);
    }

    @Test
    // Verifying that Upon entering invalid credentials, Message is displayed
    public void verifyTheErrorMessage() {
        // Locating the SignIn link element and performing the click operation on it
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        // Locating the Email element and sending the value to it
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");
        // Locating the Password element and sending the value to it
        driver.findElement(By.id("user[password]")).sendKeys("prime123");
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        // Verifying the Error message
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid Page Flow", expectedMessage, actualMessage);
    }

    @After
    public void cutOff() {
        closeBrowser();
    }
}
