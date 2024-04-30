package Tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class TC010 {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stub
		String url="http://sampleapp.tricentis.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
//Verify the "Enter Vehicle Data "
		driver.findElement(By.id("nav_automobile")).click();
			    
		FileInputStream file=new FileInputStream("C:\\Users\\balachandra.y\\OneDrive - Rootshell Enterprise Solutions Inc\\Desktop//Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
			    
		 String make=workbook.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		 int engine=(int) workbook.getSheet("Sheet1").getRow(2).getCell(1).getNumericCellValue();
		 String dataString=workbook.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		 int seates=(int) workbook.getSheet("Sheet1").getRow(2).getCell(3).getNumericCellValue();
		 String fuel=workbook.getSheet("Sheet1").getRow(2).getCell(4).getStringCellValue();	    	
		 int price=(int) workbook.getSheet("Sheet1").getRow(2).getCell(5).getNumericCellValue();
		 String license=workbook.getSheet("Sheet1").getRow(2).getCell(6).getStringCellValue();	  
		 int mileage=(int) workbook.getSheet("Sheet1").getRow(2).getCell(7).getNumericCellValue();
		  	
		Select slt=new Select(driver.findElement(By.xpath("//select[@id='make']")));
		slt.selectByVisibleText(make);
		driver.findElement(By.id("engineperformance")).sendKeys(String.valueOf(engine));
		driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys(dataString);
		Select slt1=new Select(driver.findElement(By.id("numberofseats")));
		slt1.selectByVisibleText(String.valueOf(seates));
		Select slt2=new Select(driver.findElement(By.id("fuel")));
		slt2.selectByVisibleText(fuel); 
		driver.findElement(By.id("listprice")).sendKeys(String.valueOf(price));
		driver.findElement(By.id("licenseplatenumber")).sendKeys(license);
		driver.findElement(By.id("annualmileage")).sendKeys(String.valueOf(mileage));
        //clicked on next button
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
// 	Enter Insurant Data 7
		 String firstname=workbook.getSheet("Sheet1").getRow(7).getCell(0).getStringCellValue();
		 String lastname=workbook.getSheet("Sheet1").getRow(7).getCell(1).getStringCellValue();
		 String dateofbirth=workbook.getSheet("Sheet1").getRow(7).getCell(2).getStringCellValue();
		 String address=workbook.getSheet("Sheet1").getRow(7).getCell(4).getStringCellValue();
		 String country=workbook.getSheet("Sheet1").getRow(7).getCell(5).getStringCellValue();
		 int code=(int) workbook.getSheet("Sheet1").getRow(7).getCell(6).getNumericCellValue();
		 String city=workbook.getSheet("Sheet1").getRow(7).getCell(7).getStringCellValue();
		 String occupation=workbook.getSheet("Sheet1").getRow(7).getCell(8).getStringCellValue();
		 String hobbies=workbook.getSheet("Sheet1").getRow(7).getCell(9).getStringCellValue();
		 String website=workbook.getSheet("Sheet1").getRow(7).getCell(10).getStringCellValue();
		
			driver.findElement(By.id("firstname")).sendKeys(firstname);
			driver.findElement(By.id("lastname")).sendKeys(lastname);
			driver.findElement(By.id("birthdate")).sendKeys(dateofbirth);
			driver.findElement(By.id("streetaddress")).sendKeys(address);
			Select slt3=new Select(driver.findElement(By.id("country")));
		    slt3.selectByVisibleText(country); 
         //scrolling the page
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window,scrollBy(0,300)");
			
			driver.findElement(By.id("zipcode")).sendKeys(String.valueOf(code));                           
			driver.findElement(By.id("city")).sendKeys(city);
			Select slt4=new Select(driver.findElement(By.id("occupation")));
			slt4.selectByVisibleText(occupation); 	
			
			List<WebElement> elements = driver.findElements(By.name("Hobbies"));
			int button = elements.size();
			for (int j = 0; j < button; j++) {
			    String value = elements.get(j).getAttribute("value");
			    if (value.equalsIgnoreCase(hobbies)) {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(elements.get(j)));

			        // Scroll into view if necessary
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

			        // Click the checkbox
			        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
			        
			        // Alternatively, you can try clicking the checkbox directly
			        // checkbox.click();

			        break; // Optionally, you might want to break out of the loop after clicking
			    }
			}
			driver.findElement(By.id("website")).sendKeys(website);
		  	driver.findElement(By.id("nextenterproductdata")).click();
		  	
// '3' Verifing the " Product Data "	
		  	
		  	 String startdate=workbook.getSheet("Sheet1").getRow(11).getCell(0).getStringCellValue();
			 String insurance=workbook.getSheet("Sheet1").getRow(11).getCell(1).getStringCellValue();
			 String rating=workbook.getSheet("Sheet1").getRow(11).getCell(2).getStringCellValue();
			 String damage=workbook.getSheet("Sheet1").getRow(11).getCell(3).getStringCellValue();
			 String optional=workbook.getSheet("Sheet1").getRow(11).getCell(4).getStringCellValue(); 	
			 String car=workbook.getSheet("Sheet1").getRow(11).getCell(5).getStringCellValue();
			 
			    driver.findElement(By.id("startdate")).sendKeys(startdate);
				Select drop1=new Select(driver.findElement(By.id("insurancesum")));
			  	drop1.selectByVisibleText(insurance); 
			  	Select drop2=new Select(driver.findElement(By.id("meritrating")));
			  	drop2.selectByVisibleText(rating); 
			  	Select drop3=new Select(driver.findElement(By.id("damageinsurance")));
			  	drop3.selectByVisibleText(damage); 

			  	List<WebElement> elename = driver.findElements(By.name("Optional Products[]"));
				int but = elename.size();
				for (int b = 0; b < but; b++) {
				    String vlu = elename.get(b).getAttribute("id");
				    if (vlu.equalsIgnoreCase(optional)) {
				        WebDriverWait wit = new WebDriverWait(driver, Duration.ofSeconds(15));
				        WebElement box = wit.until(ExpectedConditions.elementToBeClickable(elename.get(b)));
				        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", box);
				        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", box);
				        break; 
				    }
				}
			  	
			  	Select drop4=new Select(driver.findElement(By.id("courtesycar")));
			  	drop4.selectByVisibleText(car); 
			  	
				driver.findElement(By.id("nextselectpriceoption")).click();
//  Select Price Data	
				
				 String priceoption=workbook.getSheet("Sheet1").getRow(15).getCell(0).getStringCellValue();
				
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
//	
//				 List<WebElement> baluopt = driver.findElements(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]//label//child::input"));
//				 int balusize = baluopt.size();
//				 for (int k = 0; k < balusize; k++) {
//				     String kvalue = baluopt.get(k).getAttribute("value");
//				     if (kvalue.equalsIgnoreCase(priceoption)) {
//				         WebDriverWait baluwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				         WebElement baluele = baluwait.until(ExpectedConditions.elementToBeClickable(baluopt.get(k)));
//				         // Scroll into view
//				         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baluele);
//				         ((JavascriptExecutor) driver).executeScript("arguments[0].click();",baluele);
//				         Thread.sleep(500); // Use with caution, only if necessary		         
//				         // Try clicking the element again
//				         baluele.click();
//				     }
//				 }
//				 
//				 Thread.sleep(2000);
//				  WebDriverWait abcd = new WebDriverWait(driver, Duration.ofSeconds(10)); 
//				    WebElement efg = abcd.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='next'])[3]")));
//				    efg.click();
			
//Verify " Send Quote "   

			     String mail=workbook.getSheet("Sheet1").getRow(19).getCell(0).getStringCellValue();
				 int phone=(int) workbook.getSheet("Sheet1").getRow(19).getCell(1).getNumericCellValue();
				 String username=workbook.getSheet("Sheet1").getRow(19).getCell(2).getStringCellValue();
				 String password=workbook.getSheet("Sheet1").getRow(19).getCell(3).getStringCellValue();
				 String confirmpassword=workbook.getSheet("Sheet1").getRow(19).getCell(4).getStringCellValue(); 	
				 String comments=workbook.getSheet("Sheet1").getRow(19).getCell(5).getStringCellValue();
				 
				    driver.findElement(By.id("email")).sendKeys(mail);
				    driver.findElement(By.id("phone")).sendKeys(String.valueOf(phone));
				    driver.findElement(By.id("username")).sendKeys(username);
				    driver.findElement(By.id("password")).sendKeys(password);
				    driver.findElement(By.id("confirmpassword")).sendKeys(confirmpassword);
				    driver.findElement(By.id("Comments")).sendKeys(comments);
				    
				    driver.findElement(By.id("sendemail")).click();
		  	
		  	
			  	
	    }		
			    
	}

	
