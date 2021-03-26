import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
    @Test(priority = 1)
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

        // Verify the Sign Up text visibility
        System.out.println("Assert that the Sign Up now Text is Visible");
        Assert.assertTrue(driver.findElement(By.cssSelector("div.row.user-signup-myborder > h4")).isDisplayed());

    }

    @Test(priority = 2)
    public void fillSignUpForm(){
        // Locate the necessary text fields to fill the form

        String firstName = "Hansi";
        String lastName = "Wijayatilake";
        // NOTE: once the test is executed you will have to update the username if not the test will fail
        // because previously used usernames cannot be used again
        String username = "hww5";
        String email = "hw55@gg.com";
        // NOTE: once the test is executed you will have to update the email if not the test will fail
        // because previously used emails cannot be used again
        String password = "abc";
        String city = "Col";
        String state = "west";
        String country = "SL";
        String pincode = "00500";
        String contact = "0099903848";

        WebElement firstNameEle = driver.findElement(By.id("first_name"));
        firstNameEle.sendKeys(firstName);

        WebElement lastNameEle = driver.findElement(By.id("last_name"));
        lastNameEle.sendKeys(lastName);

        WebElement usernameEle = driver.findElement(By.id("user_name"));
        usernameEle.sendKeys(username);

        WebElement emailEle = driver.findElement(By.name("email_address"));
        emailEle.sendKeys(email);

        WebElement passwordEle = driver.findElement(By.name("password"));
        passwordEle.sendKeys(password);

        WebElement rePasswordEle = driver.findElement(By.name("re_password"));
        rePasswordEle.sendKeys(password);

        WebElement cityEle = driver.findElement(By.xpath("//input[@id='city']"));
        cityEle.sendKeys(city);

        WebElement stateEle = driver.findElement(By.xpath("//input[@id='state']"));
        stateEle.sendKeys(state);

        WebElement countryEle = driver.findElement(By.xpath("//input[@id='country']"));
        countryEle.sendKeys(country);

        WebElement pincodeEle = driver.findElement(By.xpath("//input[@id='pin_code']"));
        pincodeEle.sendKeys(pincode);

        WebElement contactEle = driver.findElement(By.xpath("//input[@id='contact_no']"));
        contactEle.sendKeys(contact);

        // Click on Sign Up Button
        driver.findElement(By.cssSelector("div.row > div.col-md-12 > button")).click();

        String currentURL = driver.getCurrentUrl();
        String givenURL = "https://www.testandquiz.com/save-user-reg-details";

        // Verify given URL against the current URL
        System.out.println("Assert that the given URL is equal to the current URL");
        Assert.assertEquals(currentURL,givenURL);

        // Verify if the Thank You text is visible
        System.out.println("Assert that the Thank You Text is Visible");
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[contains(string(), 'Thank you !')]")).isDisplayed());

    }

    @AfterTest
    public void afterTest() {

        driver.quit();
    }
}
