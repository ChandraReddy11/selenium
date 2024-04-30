package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://www.hyrtutorials.com/p/waits-demo.html";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(url);
		 		driver.findElement(By.id("btn2")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fuel")));
		driver.findElement(By.id("txt2")).sendKeys("chandra reddy");
		


	}

}
