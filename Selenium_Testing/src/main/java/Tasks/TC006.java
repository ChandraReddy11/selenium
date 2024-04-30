package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006 {

	public static void main(String[] args) throws InterruptedException {
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
	
//search Build your own cheap computer in Search box
	     driver.findElement(By.id("small-searchterms")).sendKeys("build ");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("(//a[@class='ui-corner-all'])[1]")).click();
// Scrolling the page	     
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window,scrollBy(0,500)");
	     
//
	     driver.findElement(By.xpath("//ul[@class='option-list']/child::li/child::input[@value='65']")).click();
	     driver.findElement(By.xpath("//ul[@class='option-list']/child::li/child::input[@value='55']")).click();
	     driver.findElement(By.xpath("//ul[@class='option-list']/child::li/child::input[@value='58']")).click();
	     
	     driver.findElement(By.xpath("//ul[@class='option-list']/child::li/child::input[@value='93']")).click();
	     driver.findElement(By.xpath("//ul[@class='option-list']/child::li/child::input[@value='94']")).click();
	     driver.findElement(By.xpath("//ul[@class='option-list']/child::li/child::input[@value='95']")).click();
	     
	     WebElement element=driver.findElement(By.xpath("//input[@value='1']"));
	     element.clear();
	     element.sendKeys("2");
	     driver.findElement(By.id("add-to-cart-button-72")).click();
	     
//click on the Jewelry
	     driver.findElement(By.xpath("//ul[@class='top-menu']/child::*[6]")).click();
	     driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
	     Thread.sleep(3000);
         Select slt=new Select(driver.findElement(By.id("product_attribute_71_9_15")));
        slt.selectByValue("46");
	    driver.findElement(By.xpath("//input[@class='textbox']")).sendKeys("20");
	    
	    driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
	    driver.findElement(By.id("add-to-cart-button-71")).click();
	    
//clicked on shopping cart
	    
	    driver.findElement(By.xpath("(//a[@class='ico-cart'])[1]")).click();
	    
	    String product=driver.findElement(By.xpath("(//div[@class='attributes'])[3]")).getText();
	    String str2=driver.findElement(By.xpath("(//div[@class='attributes'])[4]")).getText();
	    System.out.println(product);
	    System.out.println("--------------------------------------");  
	    System.out.println(str2);
	 
// Clicked on edit option	    
	    driver.findElement(By.xpath("(//div[@class='edit-item']/child::a)[2]")).click();
	    
	    Thread.sleep(3000);
        Select slt2=new Select(driver.findElement(By.id("product_attribute_71_9_15")));  
       slt2.selectByValue("45");
	    WebElement value=driver.findElement(By.xpath("//input[@class='textbox']"));
	    value.clear();
	    value.sendKeys("40");
	    driver.findElement(By.xpath("(//input[@type='radio'])[4]")).click();
	    driver.findElement(By.id("add-to-cart-button-71")).click();
	    
//	clicked on shopping cart    
	    
	    driver.findElement(By.xpath("(//a[@class='ico-cart'])[1]")).click();
	    Thread.sleep(3000);
	    String str3=driver.findElement(By.xpath("(//div[@class='attributes'])[4]")).getText();
	    System.out.println("================================");
	    System.out.println(str3);  
	     
	     


	}

}
