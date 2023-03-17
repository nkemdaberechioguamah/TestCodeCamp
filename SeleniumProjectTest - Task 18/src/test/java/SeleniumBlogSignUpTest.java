import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumBlogSignUpTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException {
        //locate the chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open chrome browser
        driver = new ChromeDriver();
        //2. input the selenium demo page url (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //3. maximize the browser
        driver.manage().window().maximize();
        //4. click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
        //5. enter username in the username field
        driver.findElement(By.id("user_username")).sendKeys("nkemdee71");
        //6. enter email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("nkem10@malinator.com");
        //7. enter password in the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //9. click on user1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. search for an item (using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        Thread.sleep(5000);
        //11. click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

    }
    @AfterTest
    public void closebrowser() {
        //Quit the browser
        driver.quit();

    }
}
