import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestImplementation {
    WebDriver driver;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.testandquiz.com/");
    }

    @Test
    public void signUp(){
        // Locate Sign up button and store it for later use
        WebElement signupButton = driver.findElement(By.xpath("//a[@href ='/user-registration']"));

        // Click on the located Signup Button
        signupButton.click();

        // Verify current URL
        String currentUrl = driver.getCurrentUrl();
        String givenUrl = "https://www.testandquiz.com/user-registration";

        System.out.println("Assert that the given URL is equal to the current URL");
        Assert.assertEquals(currentUrl,givenUrl);

    }

    @Test
    public void fillSignUpForm(){
        // Locate the necessary text fields to fill the form





    }
}
