package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get(url);
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demoselenium80@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("demo2task");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
//Go to books category and click on Fiction Book, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='top-menu']/child::li[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
	     
//  Go to Apparel & Shoes category and click on  Casual Golf Belt, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='list']/child::li[4]")).click();
	     driver.findElement(By.xpath("(//input[@type='button'])[5]")).click();
	     
//Go to Digital Downloads category and click on  Music 2, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='list']/child::li[5]")).click();
	     driver.findElement(By.xpath("(//input[@type='button'])[4]")).click();
	     
//Click on Shopping Cart
	     
	     driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click(); 
	     
// Select all the check boxes of the items
	     
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	     
// Click on Update shopping Cart
	     
	     driver.findElement(By.xpath("//input[@name='updatecart']")).click();
	     
	     driver.findElement(By.xpath("//div[@class='page-body']")).isDisplayed();
	     
//Click on Log out
	     
	     driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
         
//  Close Browser
	             driver.close(); 
	             driver.quit();
	       
	     

	}

}
