package Tasks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://www.flipkart.com/";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(url);
		WebElement element=driver.findElement(By.xpath("//input[@type='text']"));
		element.sendKeys("i phone");
		element.submit();
// 1
		List<WebElement> flipkart=driver.findElements(By.xpath("//img[@loading='eager']"));
		Random ran=new Random();
		int randomIndex1 = ran.nextInt(flipkart.size());
		WebElement randomProduct1 = flipkart.get(randomIndex1);
		randomProduct1.click();
		   String ordernumber1 = driver.findElement(By.xpath("//div[@class='order-number']")).getText();
	         System.out.println( ordernumber1);
		//
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.reliancedigital.in/");
		driver.findElement(By.id("wzrk-cancel")).click();
		

// 2
		WebElement element1=driver.findElement(By.xpath("//input[@id='suggestionBoxEle']"));
		element1.sendKeys("iphone");
		element1.submit();
		//// scrolling the page
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window,scrollBy(0,200)");
	      
		List<WebElement> reliance=driver.findElements(By.xpath("//div[@class='sp__productbox']"));
		Random ran1=new Random();
		int randomIndex2 = ran1.nextInt(reliance.size());
		WebElement randomProduct2 = reliance.get(randomIndex2);
		randomProduct2.click();
		   String ordernumber2 = driver.findElement(By.xpath("//div[@class='order-number']")).getText();
	         System.out.println( ordernumber2);
// 3
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.croma.com/");
		
		
		 
	

	}

}
