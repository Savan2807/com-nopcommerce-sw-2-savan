package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign
 * In!’
 * <p>
 * 2. userShouldLoginSuccessfullyWithValidCredentials
 * <p>
 * * click on the ‘Login’ link
 * * Enter valid username
 * * Enter valid password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Log out’ text is display
 * <p>
 * 3. verifyTheErrorMessage
 * <p>
 * * click on the ‘Login’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    //Use @before junit method for open a browse for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //expected result
        String expectedMessage = "Welcome, Please Sign In!";

        //Find the text elements
        WebElement actualMsgElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMsgElement.getText();
        System.out.println(actualMessage);

        //Validate actual and expected message
        Assert.assertEquals("Login test fail", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click in login method
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Email field element
        WebElement UsernameField = driver.findElement(By.id("Email"));
        UsernameField.sendKeys("savan59@gmail.com");

        //Password Field element
        WebElement PasswordField = driver.findElement(By.id("Password"));
        PasswordField.sendKeys("prime123");

        //Login button element
        WebElement LoginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        LoginButton.click();

        //actual result
        WebElement LogoutLink = driver.findElement(By.linkText("Log out"));
        String actualResult = LogoutLink.getText();

        //expected result
        String expectedResult = "Log out";

        //Match expected and actual result
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Click on login field
        WebElement LoginLink = driver.findElement(By.linkText("Log in"));
        LoginLink.click();

        //Username element
        WebElement UserField = driver.findElement(By.id("Email"));
        UserField.sendKeys("prime12@gmail.com");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("Password"));
        PasswordField.sendKeys("12345");

        //Login Button element
        WebElement LogInButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        LogInButton.click();

        //Actual result
        WebElement actualResult = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
        String actualMsg = actualResult.getText();

        //Expected result
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        //match actual and expected result
        Assert.assertEquals(actualMsg, expectedResult);


    }

    @After
    //Here After method for close the browser
    public void tearDown() {
        closeBrowse();
    }
}
