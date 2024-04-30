package Tasks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String url="http://sampleapp.tricentis.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
//Verify the "Enter Vehicle Data "
		driver.findElement(By.id("nav_automobile")).click();
	    boolean Firstname = driver.findElement(By.id("insurance-form")).isDisplayed();
	     if (Firstname==true) {
	    System.out.println("Verify Vehicle Data"+Firstname);
	    
		Select slt=new Select(driver.findElement(By.id("make")));
		slt.selectByVisibleText("Honda");
		driver.findElement(By.id("engineperformance")).sendKeys("65");
     //Calendar
		int day=11;
		driver.findElement(By.id("opendateofmanufacturecalender")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+day+"]")).click();
     //dropdown
	    int seat=2;
		Select slt1=new Select(driver.findElement(By.id("numberofseats")));
		slt1.selectByIndex(seat);
     //scrolling the page
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window,scrollBy(0,300)");
     //dropdown2
		String fuel="Petrol";
		Select slt2=new Select(driver.findElement(By.id("fuel")));
		slt2.selectByVisibleText(fuel); 
		driver.findElement(By.id("listprice")).sendKeys("95000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("Ap.ybl2211");
		driver.findElement(By.id("annualmileage")).sendKeys("625");
     //screenshot 
		WebElement section=driver.findElement(By.xpath("//div[@class='page']"));
		File src=section.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\screen shot\\img1.png"));
		System.out.println(" The screenshot is successfull");
     //clicked on next button
		driver.findElement(By.id("nextenterinsurantdata")).click();
	
	     }else {
	    	 System.out.println("false");
	     }
// 2 Verifying the " Insurant Data "
	     Thread.sleep(2000);
	     boolean  Insurantdata= driver.findElement(By.id("insurance-form")).isDisplayed();
	     if (Insurantdata==true) {
	    System.out.println(Insurantdata);
		driver.findElement(By.id("firstname")).sendKeys("Chandra");
		driver.findElement(By.id("lastname")).sendKeys("Reddy");
     //Calendar
		 String year = "2000";
		    int day = 22;

		    driver.findElement(By.id("opendateofbirthcalender")).click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    while (true) {
		    String text = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		    if (text.equals(year)) {
		    break;
		    } else {
		    driver.findElement(By.className("ui-datepicker-prev")).click();
		    }
		    }
		    WebElement desiredDay = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']"));
	        desiredDay.click();

		
     //street Address
		driver.findElement(By.id("streetaddress")).sendKeys("ABCD colony");
     //dropdown
		String country="India";
		Select slt3=new Select(driver.findElement(By.id("country")));
		slt3.selectByVisibleText(country); 
     //scrolling the page
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window,scrollBy(0,200)");
	
	    driver.findElement(By.id("zipcode")).sendKeys("500038");
	    driver.findElement(By.id("city")).sendKeys("Hyderbad");
     //dropdown
	  	String occupation="Farmer";
	  	Select slt4=new Select(driver.findElement(By.id("occupation")));
	  	slt4.selectByVisibleText(occupation); 
	  		
	  	driver.findElement(By.xpath("(//span[@class='ideal-check'])[1]")).click();
	  	driver.findElement(By.id("website")).sendKeys("abcd.com");
	  	driver.findElement(By.id("nextenterproductdata")).click();
	     }else {
	    	 System.out.println("false");
	     }
// '3' Verifing the " Product Data "
	     
	     boolean   ProductData= driver.findElement(By.xpath("(//section[@class='idealsteps-step'])[3]")).isDisplayed();
	     if (ProductData==true) {
	     System.out.println(ProductData);
		 String month = "November";
		 int day = 21;

		 driver.findElement(By.id("openstartdatecalender")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 while (true) {
		 String text = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		 if (text.equals(month)) {
		  break;
		 } else {
		 driver.findElement(By.className("ui-datepicker-next")).click();
		 }
		 }
		 WebElement desiredDay = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']"));
		 desiredDay.click();
			
			String InsuranceSum=" 10.000.000,00";
		  	Select drop1=new Select(driver.findElement(By.id("insurancesum")));
		  	drop1.selectByVisibleText(InsuranceSum); 
		  	
		  	String MeritRating="Bonus 5";
		  	Select drop2=new Select(driver.findElement(By.id("meritrating")));
		  	drop2.selectByVisibleText(MeritRating); 
		  	
		  	String DamageInsurance="Full Coverage";
		  	Select drop3=new Select(driver.findElement(By.id("damageinsurance")));
		  	drop3.selectByVisibleText(DamageInsurance); 
			
		  	driver.findElement(By.xpath("(//span[@class='ideal-check'])[5]")).click();
		  	
			String CourtesyCar=" No";
		  	Select drop4=new Select(driver.findElement(By.id("courtesycar")));
		  	drop4.selectByVisibleText(CourtesyCar); 
		  	
		 //screenshot 
			WebElement section=driver.findElement(By.xpath("(//section[@class='idealsteps-step'])[3]"));
			File src=section.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\screen shot\\img2.png"));
			System.out.println(" The screenshot is successfull");
			
			driver.findElement(By.id("nextselectpriceoption")).click();
	  		
	 }else {
    	 System.out.println("false");
	 }
//
    	 boolean   priceData= driver.findElement(By.xpath("//table[@id='priceTable']//tfoot")).isDisplayed();
	     if (priceData==true) {
	    System.out.println(priceData);
	    driver.findElement(By.xpath("(//span[@class='ideal-radio'])[5]")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='next'])[3]")));
	    ele.click();
	     }else {
	    	 System.out.println("false");
	     }
	     
//Verify " Send Quote "     (//table[@id='priceTable']//th)[7]
	     
	     boolean   sendquoat= driver.findElement(By.xpath("//div[@class='idealsteps-wrap']")).isDisplayed();
	     if (sendquoat==true) {
	    System.out.println(sendquoat);
	    driver.findElement(By.id("email")).sendKeys("chandra22@gmail.com");
	    driver.findElement(By.id("phone")).sendKeys("9876543210");
	    driver.findElement(By.id("username")).sendKeys("chandrareddy");
	    driver.findElement(By.id("password")).sendKeys("Chandra2");
	    driver.findElement(By.id("confirmpassword")).sendKeys("Chandra2");
	    driver.findElement(By.id("Comments")).sendKeys("No Comments");
	    
	    driver.findElement(By.id("sendemail")).click();
	  //screenshot 
	  		WebElement section=driver.findElement(By.xpath("//div[@class='idealsteps-wrap']"));
	  		File src=section.getScreenshotAs(OutputType.FILE);
	  		FileUtils.copyFile(src, new File("C:\\screen shot\\img.png"));
	  		System.out.println(" The screenshot is successfull");
	     }else {
	    	 System.out.println("false");
	     }
	     
	   
	 

	}

}
