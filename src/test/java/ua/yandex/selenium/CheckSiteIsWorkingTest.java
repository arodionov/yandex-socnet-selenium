package ua.yandex.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckSiteIsWorkingTest extends TestSetup {

    private WebDriver driver;    
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
   
    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();        
        driver = new ChromeDriver();        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCheckSiteIsWorking() throws Exception {
        //System.out.println(appURL);
        driver.get(appURL);
        driver.findElement(By.linkText("View All")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("Andrii");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        assertEquals("Hello Andrii", driver.findElement(By.cssSelector("h1")).getText());
    }
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
