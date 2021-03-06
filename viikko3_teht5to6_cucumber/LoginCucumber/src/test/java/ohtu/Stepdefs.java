package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;
    
    @Before
    public void setup(){
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();      
    }
    
    @Given("user {string} with password {string} exists")
    public void commandUserCreated(String user, String password) throws Throwable {
        inputLines.add("new");
        inputLines.add(user);
        inputLines.add(password);
    }
    
    @Given("^command new is selected$")
    public void commandNewSelected() throws Throwable {
        inputLines.add("new");
    }
    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }
    
    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }    
    
    @When("username {string} and wrong password {string} are entered")
    public void usernameAndWrongPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password+"wrong");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @When("nonexistent username {string} and a password {string} are entered")
    public void wrongUsernameAndpasswordAreEntered(String username, String password) {
       inputLines.add(username+"wrong");
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
      
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }    

}
