package Tasks;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com/";
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
		
// click on computers
		driver.findElement(By.xpath("(//ul[@class='top-menu']/child::li)[2]")).click();
		driver.findElement(By.xpath("//div[@class='item-box'][2]")).click(); 
// click on product and add to the compare list 
		driver.findElement(By.xpath("//h2[@class='product-title']")).click();
		driver.findElement(By.xpath("//input[@value='Add to compare list']")).click(); 
//go to the compare list category
			     
		driver.findElement(By.xpath("(//div[@class='column customer-service']/child::ul/child::li)[5]")).click();
			    
//first product of compare list
		String productname=driver.findElement(By.xpath("(//td[@class='a-center']/child::a)[1]")).getText();
		System.out.println("product Name:"+productname);
		String productprice=driver.findElement(By.xpath("//tr[@class='product-price']/child::td[2]")).getText();  
		System.out.println("product price:"+productprice);
		System.out.println("---------------------------------------");
// navigate to the URL
		 
		driver.navigate().to("https://demo.nopcommerce.com/");
		 
// click on computers
		driver.findElement(By.xpath("(//ul[@class='top-menu notmobile']/child::li)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='picture'])[2]")).click(); 
		  
		  Thread.sleep(3000);
		  
//randomly click on one product
		    
		List<WebElement> productList1 = driver.findElements(By.xpath("//div[@class='picture']"));
	    Random random1 = new Random();
	    int randomIndex1 = random1.nextInt(productList1.size());
	    WebElement randomProduct1 = productList1.get(randomIndex1);
	    randomProduct1.click();
// scrolling the page
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window,scrollBy(0,200)");
	      
	    driver.findElement(By.xpath("//div[@class='compare-products']")).click();
	    Thread.sleep(2000);  
	    js.executeScript("window,scrollBy(0,3000)");
	      
	    driver.findElement(By.xpath("(//ul[@class='list']/child::li)[11]")).click();
//Second product of compare list
		String productname1=driver.findElement(By.xpath("//tr[@class='product-name']/child::td[2]")).getText();
		System.out.println("product Name:"+productname1);
		String productprice1=driver.findElement(By.xpath("//tr[@class='product-price']/child::td[2]")).getText();  
		System.out.println("product price:"+productprice1);      
	      
//print true or false
		     
		System.out.println("===========================================");
		System.err.println(productprice.equalsIgnoreCase(productprice1));
		     
//close the browser
		driver.close();
		driver.quit();                  


	}

}
