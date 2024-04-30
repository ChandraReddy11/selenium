package BingAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://www.bing.com/search?q";
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

}
