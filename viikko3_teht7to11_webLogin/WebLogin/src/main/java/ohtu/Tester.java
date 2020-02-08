package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        // alkuperainenTesti(driver);
        
        // Teht8 kayttotapaukset

        // kirjauduVaarallaSalasanalla(driver) ;
        // luoUusiTunnus(driver) ;
        luoUusiTunnusJaLogout(driver) ;

        sleep(3);
        
        driver.quit();
    }
    
    private static void alkuperainenTesti(WebDriver driver) {
    	
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        
    }
    
    private static void kirjauduVaarallaSalasanalla(WebDriver driver) {
        // ep‰onnistunut kirjautuminen: oikea k‰ytt‰j‰tunnus, v‰‰r‰ salasana
    	
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akka");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        
    }
    
    private static void luoUusiTunnus(WebDriver driver) {
        // uuden k‰ytt‰j‰tunnuksen luominen
    	
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        Random r = new Random();
        int numero = r.nextInt(100000);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusi"+ numero);
        element = driver.findElement(By.name("password"));
        element.sendKeys("sala"+ numero);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("sala"+ numero);
        
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        
    }
    
    private static void luoUusiTunnusJaLogout(WebDriver driver) {
        // uuden k‰ytt‰j‰tunnuksen luomisen j‰lkeen tapahtuva ulkoskirjautuminen sovelluksesta
    	
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        Random r = new Random();
        int numero = r.nextInt(100000);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusi"+ numero);
        element = driver.findElement(By.name("password"));
        element.sendKeys("sala"+ numero);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("sala"+ numero);
        
        sleep(2);
        element = driver.findElement(By.name("signup"));
        element.submit();

        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
