package Tasks;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		//To click the login button
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
				
//To given valid credentials
		
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("demoselenium80@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("demo2task");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).submit();

//click on the books and add  book to the cart randomly
		
		 driver.findElement(By.xpath("(//ul[@class='list']//child::a)")).click();
		 
		  List<WebElement> productList1 = driver.findElements(By.xpath("//input[@value='Add to cart']"));
	        Random random1 = new Random();
	        int randomIndex1 = random1.nextInt(productList1.size());
	        WebElement randomProduct1 = productList1.get(randomIndex1);
	        randomProduct1.click();
//click on the Apparel shoes and add shoes to the cart randomly
	        driver.findElement(By.xpath("//ul[@class='list']/child::li[4]")).click();
		 
		 Random ran1=new Random();
		 List<WebElement> shoeslist=driver.findElements(By.xpath("//input[@value='Add to cart']"));
		 int noofprodcts= shoeslist.size();
		
		 System.out.println("no.of products :"+  noofprodcts);
		 int ranindex=ran1.nextInt(noofprodcts);
		 shoeslist.get(ranindex).click();
		 
//click on the digital downloads and add music to the cart randomly
		 
		 driver.findElement(By.xpath("//ul[@class='list']/child::li[5]")).click();
		   
	        List<WebElement> productList2 = driver.findElements(By.xpath("//input[@value='Add to cart']"));
	        Random random2 = new Random();
	        int randomIndex2 = random2.nextInt(productList2.size());
	        WebElement randomProduct2 = productList2.get(randomIndex2);
	        randomProduct2.click();
		 
//click the shopping cart
			driver.findElement(By.xpath("//li[@id='topcartlink']//a")).click();

//To  click the check boxes 
			driver.findElement(By.xpath("//td[1]/input")).click();
			driver.findElement(By.xpath("(//td[1]/input)[2]")).click();
			driver.findElement(By.xpath(("(//td[1]/input)[3]"))).click();
			Thread.sleep(3000);	
//Click the update shopping cart
		
			driver.findElement(By.name("updatecart")).click();
			
//logout the mail
			
			 driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
			Thread.sleep(3000);	
			
//close the browser
			driver.close();
			driver.quit();

	}

}
