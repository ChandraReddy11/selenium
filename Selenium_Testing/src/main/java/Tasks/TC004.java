package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com"; 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  
		//driver.manage().window().setSize(new Dimension(600, 600));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demoselenium80@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("demo2task");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
//Go to books category and click on Fiction Book, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='top-menu']/child::li[1]")).click();
	     driver.findElement(By.xpath("(//div[@class='picture'])[3]")).click();
	     WebElement element=driver.findElement(By.xpath("//input[@class='qty-input']"));
	     element.clear();
	     element.sendKeys("2");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();
//  Go to Apparel & Shoes category and click on  Casual Golf Belt, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='list']/child::li[4]")).click();
	     driver.findElement(By.xpath("(//div[@class='product-item'])[7]")).click();
	     WebElement element1=driver.findElement(By.xpath("//input[@data-val='true']"));
	     element1.clear();
	     element1.sendKeys("2");
	     driver.findElement(By.xpath("//input[@id='add-to-cart-button-29']")).click();
	     
	    
//Click on Shopping Cart
  	     
      	 driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click(); 
      	 
  // Retrieve price and quantity values
     	String priceString = driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText();
     	String quantityString = driver.findElement(By.xpath("//input[@value='2']")).getAttribute("value");
     	double price = Double.parseDouble(priceString.replace("$", "")); 
     	int quantity = Integer.parseInt(quantityString);
      
// Calculate total price by multiplying price and quantity
     	double totalPrice = price * quantity;
      
     	System.out.println("Price: Rs = " + price);
     	System.out.println("Quantity: " + quantity);
     	System.out.println("Total Price :Rs =" + totalPrice);
        System.out.println("--------------------------------------------");  
  
 // Retrieve price and quantity values
     	String priceString1 = driver.findElement(By.xpath("(//span[@class='product-unit-price'])[2]")).getText();  
     	String quantityString1 = driver.findElement(By.xpath("(//input[@class='qty-input'])[2]")).getAttribute("value");
      
 // Convert the retrieved strings to numerical types
     	double price1 = Double.parseDouble(priceString1);
     	int quantity1 = Integer.parseInt(quantityString1);
      
// Calculate total price by multiplying price and quantity
     	double totalPrice1 = price1 * quantity1;
      
     	System.out.println("Price: Rs =" + price1);
     	System.out.println("Quantity: " + quantity1);
     	System.out.println("Total Price:Rs =" + totalPrice1);
     	
     	double totalPrice3 = totalPrice + totalPrice1;
     	System.out.println("------------------------------------");
     	System.out.println("Two Products of Total Price:"+(totalPrice3));
     	
     	
     	
     	
     	String subprice = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
     	double SubTotal = Double.parseDouble(subprice.replace("$", ""));
     	 
     	 System.out.println("----------------------------");
     	if(totalPrice3==SubTotal){
     		System.out.println("Sub Total     :  true");
     	}else {
			System.out.println("false");
		}
     	
      	
      	 
      	 
	     
	     


	}

}
