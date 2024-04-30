package Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url="https://www.hyrtutorials.com/p/waits-demo.html";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(url);
		
		WebElement section=driver.findElement(By.id("header-inner"));
		File src=section.getScreenshotAs(OutputType.FILE);
		File deskFile=new File("./Screenshots/img.jpg");
		FileUtils.copyFile(src, deskFile);
		System.out.println(" The screenshot is successfull");


	}

}
