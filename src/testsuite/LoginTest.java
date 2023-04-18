package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");

        //Enter the username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on the LOGIN button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify that the text "PRODUCTS" is displayed
        //WebElement productsLabel = driver.findElement(By.xpath("//div[@class='header_label']"));
        //String expectedLabel = "PRODUCTS";
        //Assert.assertEquals(productsLabel.getText(), expectedLabel);
        //or
        //WebElement productsHeader = driver.findElement(By.className("product_label")); - error
        //String expectedMessage = "PRODUCTS";
        // String actualMessage = productsHeader.getText();
        //  Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify that six products are displayed on the page
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(actualNumberOfProducts, expectedNumberOfProducts);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}