package ua.yandex.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckStudentCreationTest extends TestSetup {
  private WebDriver driver;
  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2() throws Exception {
    driver.get(appURL);
    driver.findElement(By.linkText("View All")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("Anna");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Create new student")).click();
    driver.findElement(By.name("sName")).clear();
    driver.findElement(By.name("sName")).sendKeys("Anna");
    driver.findElement(By.name("sYear")).clear();
    driver.findElement(By.name("sYear")).sendKeys("3");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertTrue(driver.findElement(By.cssSelector("table")).getText().matches("^[\\s\\S]*Anna[\\s\\S]*$"));
    driver.findElement(By.xpath("(//input[@value='Show'])[5]")).click();
    assertTrue(driver.findElement(By.cssSelector("body")).getText().matches("^[\\s\\S]*Student = Anna[\\s\\S]*$"));
    driver.findElement(By.linkText("Delete")).click();
    assertThat("Anna", is(not(driver.findElement(By.cssSelector("table")).getText())));
    driver.findElement(By.linkText("Logout")).click();
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
