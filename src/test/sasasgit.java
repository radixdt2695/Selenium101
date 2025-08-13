package cert;

//sasas

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import java.net.MalformedURLException;
//import java.net.URL;


public class sasasgit {
	
	public WebDriver driver;
    private String username = "radixdt.2695";
    private String accessKey = "KbfEFAexiAw0QoYC9XBwO9PKp94xiBEsmfkV1PheWb4RFBQ6II";
    private String hub = "@hub.lambdatest.com/wd/hub";
    boolean status = false;

	DesiredCapabilities caps = new DesiredCapabilities();

	@Parameters(value = { "browser", "version", "platform" })
	@BeforeClass
	public void setup(String browser, String version, String platform) {
		caps.setCapability("build", "Selenium_101");
		caps.setCapability("name", "LambdaTest Selenium 101");
		caps.setCapability("browserName", browser);
		caps.setCapability("version", version);
		caps.setCapability("platform", platform);
		caps.setCapability("network", true);
		caps.setCapability("console", true);
		caps.setCapability("visual", true);
		caps.setCapability("video", true);
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub), caps);
		} catch (MalformedURLException exc) {
			exc.printStackTrace();
		}
		
	}
	
	
	@Test(priority=1,description="TestScenario 1")
	public void testScenario1() throws InterruptedException
	{
		try {
			SoftAssert softassert = new SoftAssert();
			String expectedLink = "simple-form-demo";
			
	//		WebDriverManager.chromedriver().setup();
	//	    ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.manage().window().maximize();
			driver.findElement(By.partialLinkText("Simple Form Demo")).click();
			String strUrl=driver.getCurrentUrl();
			
			//URL Contain Verification
			softassert.assertTrue(strUrl.contains(expectedLink),"URL Contain Verification");
			
			//Message Display Verification
			String enterMessageText = "Welcome to Lambda Testt";
			driver.findElement(By.id("user-message")).sendKeys(enterMessageText);
			driver.findElement(By.id("showInput")).click();
			Thread.sleep(2000);
			String displayMessage=driver.findElement(By.id("message")).getText();
			Thread.sleep(2000);
			softassert.assertEquals(displayMessage, enterMessageText,"Message Display Verificatoion"); 
			//driver.close();
			softassert.assertAll();
	  } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	@Test(priority=2,description="TestScenario 2")
	public void testScenario2() throws InterruptedException
	{   
		try {
			SoftAssert softassert = new SoftAssert();
	//		WebDriverManager.chromedriver().setup();
	//		ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.manage().window().maximize();
			driver.findElement(By.partialLinkText("Drag & Drop Sliders")).click();
			Thread.sleep(2000);
			WebElement slider =driver.findElement(By.cssSelector("div#slider3 > div.sp__range.sp__range-success > input.sp__range"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(slider, 215, 0).perform();
			Thread.sleep(2000);
			String RangeSlider=driver.findElement(By.id("rangeSuccess")).getText();
			softassert.assertEquals(RangeSlider, "95","Range Verificatoion"); 
			//driver.close();
			//Actions move = new Actions(driver);
			//Action action = (Action) move.dragAndDropBy(slider, 215, 0).build();
			//action.perform();
			softassert.assertAll();
	     }catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	@Test(priority=3,description="TestScenario 3")
	public void testScenario3() throws InterruptedException
	{	
		try {
			SoftAssert softassert = new SoftAssert();
	//		WebDriverManager.chromedriver().setup();
	//		ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.manage().window().maximize();
			driver.findElement(By.partialLinkText("Input Form Submit")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("selenium_btn")).click();
			WebElement inputField = driver.findElement(By.id("name"));
			softassert.assertTrue(inputField.getAttribute("required").equals("true"),"Verification for Required Field");
			driver.findElement(By.id("name")).sendKeys("Sagar D.");
			driver.findElement(By.id("inputEmail4")).sendKeys("lambdatest@gmail.com");
			driver.findElement(By.id("inputPassword4")).sendKeys("lambdatest12ka4");
			driver.findElement(By.id("company")).sendKeys("Rcompany");
			driver.findElement(By.id("websitename")).sendKeys("rcompany.com");
			
			WebElement ddown= driver.findElement(By.name("country"));
			Select select = new Select(ddown);
			select.selectByVisibleText("United States");
			driver.findElement(By.id("inputCity")).sendKeys("Ahmedabad");
			driver.findElement(By.id("inputAddress1")).sendKeys("Mlbar County");
			driver.findElement(By.id("inputAddress2")).sendKeys("CTM Address2");
			driver.findElement(By.id("inputState")).sendKeys("Hyderbad");
			driver.findElement(By.id("inputZip")).sendKeys("390023");
			
			driver.findElement(By.className("selenium_btn")).click();
			softassert.assertEquals(driver.findElement(By.className("success-msg")).getText(), "Thanks for contacting us, we will get back to you shortly.");
			//driver.close();
			softassert.assertAll();
		 }catch (Exception e) {
	            System.out.println(e.getMessage());
	     }
	}
	
	@AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
	
	
}
