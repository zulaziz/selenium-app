package com.selenium.test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    WebDriver driver;


    @Given("^the Bata login page$")
    public void the_Bata_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://bataheritage.com/en/login?back=my-account");
        assertEquals("Login - Bata Heritage",driver.getTitle());
    }

    @When("^logging in as customer$")
    public void logging_in_as_customer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("vulfadli@outlook.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("NOxsekfR");

        WebElement login = driver.findElement(By.id("SubmitLogin"));
        login.click();
    }

    @Then("^the home page navigation is available$")
    public void the_home_page_navigation_is_available() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement navList = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("left_column")));
    }

    @Before
    public void startUp(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}