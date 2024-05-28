package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //computer element
        WebElement ComputerLink = driver.findElement(By.linkText("Computers"));
        ComputerLink.click();

        //Actual result
        WebElement actualResult = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        String actualMsg = actualResult.getText();

        //expected result
        String expectedResult = "Computers";

        //Match actual result and expectedResult
        Assert.assertEquals(actualMsg, expectedResult);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        //Electronics elements
        WebElement ElectronicsLinks = driver.findElement(By.linkText("Electronics"));
        ElectronicsLinks.click();

        //ActualResult
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actualMsg = actualResult.getText();

        //expectedResult
        String expectedResult = "Electronics";

        //match actualResult and expectedResult
        Assert.assertEquals(actualMsg, expectedResult);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        //Apparel Link elements
        WebElement ApparelLink = driver.findElement(By.linkText("Apparel"));
        ApparelLink.click();

        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualMsg = actualResult.getText();


        //expectedResult
        String expectedMsg = "Apparel";

        //match actual and expected result
        Assert.assertEquals("User is not on Apparel page", actualMsg, expectedMsg);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {

        //DigitalDownload elements
        WebElement DigitalDownloadsLink = driver.findElement(By.linkText("Digital downloads"));
        DigitalDownloadsLink.click();

        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        String actualMsg = actualResult.getText();

        //expectedResult
        String expectedMsg = "Digital downloads";

        //match actualResult and expected result
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //books elements
        WebElement booksLink = driver.findElement(By.linkText("Books"));
        booksLink.click();

        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualMsg = actualResult.getText();

        //expectedResult
        String expectedMsg = "Books";

        //match actualResult and expected result
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //jewelry elements
        WebElement jewelryLink = driver.findElement(By.linkText("Jewelry"));
        jewelryLink.click();

        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMsg = actualResult.getText();

        //expectedResult
        String expectedMsg = "Jewelry";

        //match actualResult and expected result
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //GiftCard elements
        WebElement giftCardLink = driver.findElement(By.linkText("Gift Cards"));
        giftCardLink.click();

        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualMsg = actualResult.getText();

        //expectedResult
        String expectedMsg = "Gift Cards";

        //match actualResult and expected result
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @After
    //Here After method for close the browser
    public void tearDown() {
        closeBrowse();

    }

}

