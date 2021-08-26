package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Random;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	WebDriver driver;
	int Random;

	@BeforeMethod
	public void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	
	
	  @Test(priority = 1)
	  public void Register() throws Exception { randomnumber();
	  driver.findElement(By.linkText("Register")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("gender-male")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("FirstName")).sendKeys("Test"+Random);
	  Thread.sleep(2000);
	  driver.findElement(By.id("LastName")).sendKeys("TestLast"+Random);
	  Thread.sleep(2000);
	  driver.findElement(By.id("Email")).sendKeys("Gmail"+Random+"@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.id("Password")).sendKeys("SampleProgram");
	  Thread.sleep(2000);
	  driver.findElement(By.id("ConfirmPassword")).sendKeys("SampleProgram");
	  Thread.sleep(2000);
	  driver.findElement(By.id("register-button")).click();
	  Thread.sleep(2000);
	  System.out.println("Gmail"+Random+"@gmail.com"); 
	  String Registrationmessage =
	  driver.findElement(By.className("result")).getText();
	  Assert.assertTrue(Registrationmessage.contains("Your registration completed")
	  ); 
	  }
	 
	 
	 

	
	  @Test(priority = 3) 
	  public void ProductPagesize() throws Exception {
	  
	  driver.findElement(By.linkText("Log in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("Email")).sendKeys(
	  "Gmail738@gmail.com");
	  Thread.sleep(2000);
	  driver.findElement(By.id("Password")).sendKeys("SampleProgram");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click(); 
	  String Title = driver.getTitle();
	  Assert.assertEquals("Demo Web Shop",Title); 
	  driver.findElement(By.xpath("//ul[@class='top-menu']//a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='item-box']//a")).click();
	  Thread.sleep(2000);
	  
	  Select productdropdown = new Select(driver.findElement(By.xpath("//div[@class='product-sorting']//select")));
	  productdropdown.selectByVisibleText("Created on");
	  Thread.sleep(2000);
	  Select Sizedropdown = new Select(driver.findElement(By.xpath("//div[@class='product-page-size']//select")));
	  Sizedropdown.selectByVisibleText("4");
	  Thread.sleep(2000);
	  
	  int NumberofItems = driver.findElements(By.xpath("//div[@class='product-grid']/div")).size();
	  Assert.assertEquals(4, NumberofItems);
	  }
	  
	  @Test(priority = 4, timeOut = 10000) 
	  public void SearchValue() throws Exception {
		  
		  driver.findElement(By.linkText("Log in")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("Email")).sendKeys(
		  "Gmail738@gmail.com");
		  Thread.sleep(2000);
		  driver.findElement(By.id("Password")).sendKeys("SampleProgram");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click
		  (); String Title = driver.getTitle();
		  Assert.assertEquals("Demo Web Shop",Title); 
		  Thread.sleep(2000);
// 		  driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
// 		  Thread.sleep(2000);
// 		  Alert popup = driver.switchTo().alert();
// 		  String message = popup.getText();
// 		  System.out.println(message);
// 		  Assert.assertTrue(message.contains("Please enter some search keyword"));
// 		  popup.accept();
// 		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Jewelry");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
		  
		  }
	
	
	  @Test(priority = 3) 
	  public void InvalidUserlogin() throws Exception {
	  
	  driver.findElement(By.linkText("Log in")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("Email")).sendKeys("Gmail"+Random+"@gmail");
	  Thread.sleep(2000);
	  driver.findElement(By.id("Password")).sendKeys("SampleProgram");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='buttons']/input")).click(); String
	  errormessage =
	  driver.findElement(By.xpath("//span[@class='field-validation-error']/span")).
	  getText();
	  Thread.sleep(2000);
	  Assert.assertEquals("Please enter a valid email address.", errormessage);
	  
	  }
	 
	 

	public void randomnumber() {
		
		Random rand = new Random();
		  
        // Generate random integers in range 0 to 999
         Random = rand.nextInt(10000);
	}

	@AfterMethod
	public void CloseBrowser() {

		driver.close();

	}
}
