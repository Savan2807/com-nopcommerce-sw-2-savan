package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 5. Write down the following test into ‘RegisterTest’
 * class
 * 1. userShouldNavigateToRegisterPageSuccessful
 * ly
 * * click on the ‘Register’ link
 * * Verify the text ‘Register’
 * <p>
 * 2. userSholdRegisterAccountSuccessfully *
 * click on the ‘Register’ link
 * * Select gender radio button
 * * Enter First name
 * * Enter Last name
 * * Select Day Month and Year
 * * Enter Email address
 * * Enter Password
 * * Enter Confirm password
 * * Click on REGISTER button
 * * Verify the text 'Your registration
 * completed’
 */
public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    //Use @before junit method for open a browse for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessful() {
        //click on the Register link
        WebElement RegisterLink = driver.findElement(By.linkText("Register"));
        RegisterLink.click();
        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        String actualMsg = actualResult.getText();

        //expected result
        String expectedMsg = "Register";

        ////match actualResult and expected result
        Assert.assertEquals("", actualMsg, expectedMsg);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);            //Create random username
        String emailID = "User" + userName + "@example.com";                        //Create random email Id
        //register elements
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        //gender elements
        WebElement genderFields = driver.findElement(By.id("gender-male"));
        genderFields.click();

        //Firstname elements
        WebElement firstnameField = driver.findElement(By.id("FirstName"));
        firstnameField.sendKeys("savan");

        //Lastname elements
        WebElement lastnameField = driver.findElement(By.name("LastName"));
        lastnameField.sendKeys("kakadiya");

        //Date of birth elements
        WebElement dateOfBirthField = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[29]"));
        dateOfBirthField.click();

        //month of birth elements
        WebElement monthOfBirthField = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[8]"));
        monthOfBirthField.click();

        //Year of birth elements
        WebElement yearOfBirthField = driver.findElement(By.xpath("//option[contains(text(),'1995')]"));
        yearOfBirthField.click();

        //Email address elements
        WebElement EmailField = driver.findElement(By.name("Email"));
        EmailField.sendKeys(emailID);

        // Password elements
        WebElement PasswordField = driver.findElement(By.name("Password"));
        PasswordField.sendKeys("prime123");

        //Confirm password
        WebElement ConfirmPasswordField = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        ConfirmPasswordField.sendKeys("prime123");

        //Click on REGISTER button
        WebElement registerButton = dateOfBirthField.findElement(By.xpath("//button[@id='register-button']"));
        registerButton.click();
        ;

        //actual result
        WebElement actualResult = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualMsg = actualResult.getText();

        //expected result
        String expectedResult = "Your registration completed";

        //match actualResult and Expected result
        Assert.assertEquals("User is already exit", actualMsg, expectedResult);


    }

    @After
    public void tearDown() {
        closeBrowse();
    }
}
