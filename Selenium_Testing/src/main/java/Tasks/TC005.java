package Tasks;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(url);
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demoselenium80@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("demo2task");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
//  Go to Apparel & Shoes category and click on  Casual Golf Belt, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='top-menu']/child::li[1]")).click();
	     driver.findElement(By.xpath("(//div[@class='picture'])[3]")).click();
	     WebElement element=driver.findElement(By.xpath("//input[@class='qty-input']"));
	     element.clear();
	     element.sendKeys("3");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();
//Click on Shopping Cart
  	     
      	 driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click();       	 
      	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	 WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='termsofservice']")));
       	 popup.click();
    	 driver.findElement(By.id("checkout")).click(); 
    	 
//Billing Address
    	 Select slt=new Select( driver.findElement(By.id("BillingNewAddress_CountryId")));
    	 slt.selectByValue("41");
    	 driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Hyrderbad"); 
    	 driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("SR Nagar"); 
    	 driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("500038"); 
    	 driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("8309355555");  
    	 driver.findElement(By.xpath("(//input[@type='button'])[2]")).click(); 
//Shipping Address
    	
     	 WebElement popup1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
       	 popup1.click();
     	 WebElement popup2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='button'])[3]")));
       	 popup2.click();
       	 
       	 
//Payment Method
    	 driver.findElement(By.xpath("(//input[@name='paymentmethod'])[1]")).click(); 
    	 driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click(); 
    	 
//Payment Information
    	String element2= driver.findElement(By.className("info")).getText();
    	System.out.println(element2);
    	 driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click(); 
//Confirm Order
    	 driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click(); 

    	 driver.findElement(By.xpath("//ul[@class='details']//a")).click(); 
    	 String ordernumber = driver.findElement(By.xpath("//div[@class='order-number']")).getText(); 
         System.out.println(ordernumber);
  	 
// click on mail Address
         driver.findElement(By.xpath("(//a[@class='account'])[1]")).click(); 
         driver.findElement(By.xpath("(//a[@class='inactive'])[2]")).click(); 
         driver.findElement(By.xpath("(//input[@value='Details'])[1]")).click(); 
         
   
         String ordernumber1 = driver.findElement(By.xpath("//div[@class='order-number']")).getText();
         System.out.println( ordernumber1);
         System.out.println("==============================");
         System.out.println( ordernumber1.equals(ordernumber));
        
       

	}

}
