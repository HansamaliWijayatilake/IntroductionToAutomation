import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    }
}
