package Tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stub
		String url="http://sampleapp.tricentis.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(url);
//Verify the "Enter Vehicle Data "
		driver.findElement(By.id("nav_automobile")).click();
	    
	    FileInputStream file=new FileInputStream("C:\\Users\\balachandra.y\\OneDrive - Rootshell Enterprise Solutions Inc\\Desktop//Book1.xlsx");
	    XSSFWorkbook workbook=new XSSFWorkbook(file);
	    XSSFSheet sheet=workbook.getSheet("Sheet1");
	    
	      int rowcount=sheet.getLastRowNum();
	//    System.out.println(rowcount); 
	    
	    for (int i=2;i<=rowcount;i++) {
	    	XSSFRow row=sheet.getRow(i);
	    	
	    	String make=row.getCell(0).getStringCellValue();
	    	int engine=(int)row.getCell(1).getNumericCellValue();
	    	String dateString = row.getCell(2).getStringCellValue();
	    	int seates=(int)row.getCell(3).getNumericCellValue();
	    	String fuelbox=row.getCell(4).getStringCellValue();
	    	int price=(int)row.getCell(5).getNumericCellValue();
	    	String license=row.getCell(6).getStringCellValue();
	    	int mileage=(int)row.getCell(7).getNumericCellValue();
	    
	    	
			Select slt=new Select(driver.findElement(By.xpath("//select[@id='make']")));
			slt.selectByVisibleText(make);
			driver.findElement(By.id("engineperformance")).sendKeys(String.valueOf(engine));
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date formattedDate = dateFormat.parse(dateString);
			String formattedDateString = dateFormat.format(formattedDate);
			Select slt1=new Select(driver.findElement(By.id("numberofseats")));
			slt1.selectByVisibleText(String.valueOf(seates));
			Select slt2=new Select(driver.findElement(By.id("fuel")));
			slt2.selectByVisibleText(fuelbox); 
			driver.findElement(By.id("listprice")).sendKeys(String.valueOf(price));
			driver.findElement(By.id("licenseplatenumber")).sendKeys(license);
			driver.findElement(By.id("annualmileage")).sendKeys(String.valueOf(mileage));
			//clicked on next button
		    driver.findElement(By.id("nextenterinsurantdata")).click();
	    	
	         }
	    
		   
//    Enter Insurant Data 7	    
		    
		    for (int b=7;b<=rowcount;b++) {
		    	XSSFRow row=sheet.getRow(b);
		    	String firstname=row.getCell(0).getStringCellValue();
		    	String lastname=row.getCell(1).getStringCellValue();
		    	String date=row.getCell(2).getStringCellValue();
		    	String gender=row.getCell(3).getStringCellValue();
		    	String address=row.getCell(4).getStringCellValue();
		    	String country=row.getCell(5).getStringCellValue();
		    	int zipcode=(int)row.getCell(6).getNumericCellValue();
		    	String city=row.getCell(7).getStringCellValue();
		    	String Occupation=row.getCell(8).getStringCellValue();
		    	String Hobbies=row.getCell(9).getStringCellValue();
		    	String Website=row.getCell(10).getStringCellValue();
		    	
		    	
		    	driver.findElement(By.id("firstname")).sendKeys(firstname);
				driver.findElement(By.id("lastname")).sendKeys(lastname);
				driver.findElement(By.id("opendateofbirthcalender")).click();     //   date}
				driver.findElement(By.className("ideal-radio")).click();
				driver.findElement(By.id("streetaddress")).sendKeys(address);
				Select slt3=new Select(driver.findElement(By.id("country")));
			    slt3.selectByVisibleText(country); 
//scrolling the page
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window,scrollBy(0,200)");
				
				driver.findElement(By.id("zipcode")).sendKeys();                           //zip code
				driver.findElement(By.id("city")).sendKeys(city);
				Select slt4=new Select(driver.findElement(By.id("occupation")));
				slt4.selectByVisibleText(Occupation); 
				  		
				driver.findElement(By.xpath("(//span[@class='ideal-check'])[1]")).click();             //
				driver.findElement(By.id("website")).sendKeys(Website);
				
				List<WebElement> ele=driver.findElements(By.xpath("(//span[@class='ideal-radio'])[1]"));
				int button=ele.size();
				for(int j=0;j<=button;j++) {
					String value=ele.get(j).getAttribute("Male");
					if(value.equalsIgnoreCase(gender)) {
						ele.get(j).click();
					}
				}
				  	
		    }
		    driver.findElement(By.id("nextenterproductdata")).click();
//  Enter Product Data 6
		    for (int i=11;i<=rowcount;i++) {
		    	XSSFRow row=sheet.getRow(i);
		    	int startdate=(int)row.getCell(6).getNumericCellValue();
		    	int Insurance=(int)row.getCell(6).getNumericCellValue();
		    	String  Merit=row.getCell(0).getStringCellValue();
		    	String  Damage=row.getCell(1).getStringCellValue();
		    	String Optional=row.getCell(2).getStringCellValue();
		    	String Courtesy =row.getCell(3).getStringCellValue();
		    	
		    	// date balance
		    	
		    	Select drop1=new Select(driver.findElement(By.id("insurancesum")));
			  //	drop1.selectByVisibleText(url) 
			  	Select drop2=new Select(driver.findElement(By.id("meritrating")));
			  	drop2.selectByVisibleText(Merit); 
			  	
			  	String DamageInsurance="Full Coverage";
			  	Select drop3=new Select(driver.findElement(By.id("damageinsurance")));
			  	drop3.selectByVisibleText( Damage); 
				
			  	driver.findElement(By.xpath("(//span[@class='ideal-check'])[5]")).click();    //click  opt
		
			  	Select drop4=new Select(driver.findElement(By.id("courtesycar")));
			  	drop4.selectByVisibleText(Courtesy); 
			  	
		    }
		       driver.findElement(By.id("nextselectpriceoption")).click();
		       
		       for (int i=15;i<=rowcount;i++) {
			    	XSSFRow row=sheet.getRow(i);
			    	String platinum =row.getCell(3).getStringCellValue();
			    	
			    	  driver.findElement(By.xpath("(//span[@class='ideal-radio'])[5]")).click();
			    	  
		       }
			  	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
			  	    WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='next'])[3]")));
			  	    ele.click();
			  	     for (int i=19;i<=rowcount;i++) {
					    	XSSFRow row=sheet.getRow(i);
					    	String mail=row.getCell(2).getStringCellValue();
					    	int phone=(int)row.getCell(6).getNumericCellValue();
					    	String  username=row.getCell(0).getStringCellValue();
					    	String  password=row.getCell(1).getStringCellValue();
					    	String password2=row.getCell(2).getStringCellValue();
					    	String comment=row.getCell(2).getStringCellValue();
					    	
					    	driver.findElement(By.id("email")).sendKeys(mail);
					  	    driver.findElement(By.id("phone")).sendKeys(String.valueOf(phone));
					  	    driver.findElement(By.id("username")).sendKeys(username);
					  	    driver.findElement(By.id("password")).sendKeys(password);
					  	    driver.findElement(By.id("confirmpassword")).sendKeys(password2);
					  	    driver.findElement(By.id("Comments")).sendKeys( comment);
					  	    
			  	     }
					  	    
					  	    driver.findElement(By.id("sendemail")).click();
					    	
		       
	}

}
