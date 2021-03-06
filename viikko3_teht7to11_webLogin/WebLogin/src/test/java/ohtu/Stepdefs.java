package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();  
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
    	createUserWith(username, password, password);
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
    	createUserWith(username, password, password);
    }

    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
        
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    

    @When("un-existent username {string} and a password {string} are given")
    public void unexistentUsernameAndAPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    } 
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndConfirmationAreEntered(String username, String password) throws Throwable {
        createUserWith(username, password, password);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
    	// Testing what ACTUALLY gets generated - if the assert fails ..
    	// System.out.print(driver.getPageSource());
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndPasswordAndConfirmationAreEntered(String username, String password) {
        createUserWith(username, password, password);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String string) {
        pageHasContent(string);
        pageHasContent("Create username and give password");
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void aValidUsernameAndTooShortPasswordConfirmationAreEntered(String username, String password) {
        createUserWith(username, password, password);
    }

    @When("a valid username {string} and password {string} and non-matching password confirmation {string} are entered")
    public void aValidUsernameAndPasswordAndNonMatchingConfirmationAreEntered(String username, String password, String wrongpassconf) {
        createUserWith(username, password, wrongpassconf);
    }
   
    @When("the newly generated username {string} and password {string} are entered")
    public void theNewlyGeneratedUsernameAndPasswordAreEntered(String username, String password) throws Throwable {
        logInWith(username, password);
    }


    @When("the unsuccesful username {string} and password {string} are entered")
    public void theUnsuccesfulUsernameAndPasswordAreEntered(String username, String password) {
        logInWith(username, password);
    }

    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createUserWith(String username, String password, String passconfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passconfirmation);
        
        // Testing the method
        // System.out.println("\n user " + username + " pass " + password + " conf " + passconfirmation);
        
        element = driver.findElement(By.name("signup"));
        element.submit();  
    } 
    
}
