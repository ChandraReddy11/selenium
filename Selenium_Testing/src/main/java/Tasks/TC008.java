package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
					
// Login with the Valid credentials
				       
	    driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demoselenium80@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("demo2task");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
// scrolling the page
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window,scrollBy(0,3000)");
	    
	    driver.findElement(By.xpath("(//ul/child::li/child::a)[58]")).click();
	    driver.findElement(By.xpath("//input[@id='Q']")).sendKeys("Jewelry");
	    driver.findElement(By.id("As")).click();
//	    
	    Select slt=new Select( driver.findElement(By.id("Cid")));
   	 slt.selectByValue("12");
	    driver.findElement(By.id("Isc")).click();
//
	    driver.findElement(By.id("Pf")).sendKeys("Low");
	    driver.findElement(By.name("Pt")).sendKeys("High");
	    
	    driver.findElement(By.id("Sid")).click();
	    driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	     
	    js.executeScript("window,scrollBy(0,300)");
	    
	    driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
	  
	    
	    
//	    driver.close();

	}

}
