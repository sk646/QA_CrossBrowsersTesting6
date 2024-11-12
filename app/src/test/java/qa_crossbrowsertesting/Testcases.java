package qa_crossbrowsertesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Testcases {
WebDriver driver;

@Test
@Parameters("browser")
public void setup( String br) throws Exception {
   try{
      switch(br.toLowerCase()) {
        case "chrome": driver = new ChromeDriver(); break;
        case "edge": driver = new EdgeDriver(); break;
        case "firefox": driver = new FirefoxDriver(); break;
        default: System.out.println("invalid browser"); return;
 }  
// if (browser.equalsIgnoreCase("firefox")) {
//  driver = new FirefoxDriver();
// } else if (browser.equalsIgnoreCase("chrome")) {
//  driver = new ChromeDriver();
// } else if (browser.equalsIgnoreCase("edge")) {
//  driver = new EdgeDriver();
// } else {
// throw new Exception("Incorrect Browser");
// }
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
System.out.println("WebDriver initialized: " + driver.getClass().getSimpleName());
driver.get("https://www.browserstack.com/");
Thread.sleep(2000);
System.out.println("Title is: " + driver.getTitle());
Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
} catch (Exception e) {
  System.out.println("incorrect browser: "+e.getMessage());
  }
}

// @Test
// public void verifyTitle() throws InterruptedException {
// try{
// // driver.get("https://www.browserstack.com/");
// // System.out.println("Title is: " + driver.getTitle());
// Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
// } catch (Exception e) {
//   e.printStackTrace();
//  }
// }
@AfterTest
public void teardown(){
    if (driver != null){
    driver.quit();
    }
 }

}
