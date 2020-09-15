package Pratik;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "A:\\software\\selenium_chrome_driver\\chromedriver.exe");
		
		// creating object of chrom driver
		WebDriver driver = new ChromeDriver();
		
		// maximized the browser
		driver.manage().window().maximize();
		
		// opening desired URL
		driver.get("http://seleniummaster.com/sitecontent/seleniummenutest/seleniummenutest.html");

		// clicking on "Menu 2"
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/p[1]")).click();
		// after clicking on menu 2 waited for 2 seconds
		Thread.sleep(2000);
		
		// clicking on "item 1" of "Menu 2"
		driver.findElement(By.xpath("//td[2]//div[1]//table[1]//tbody[1]//tr[1]//td[1]//a[1]")).click();
		Thread.sleep(10000);
		
		/*driver.navigate().back(); is not working in new updated ChromeDriver, because of that used 
		 driver.navigate.to("Desired URL")*/	
		driver.navigate().to("http://seleniummaster.com/sitecontent/seleniummenutest/seleniummenutest.html");
		Thread.sleep(2000);
		
		// clicked on other "Menu 3"
		driver.findElement(By.xpath("//p[contains(text(),'Menu 3')]")).click();
		Thread.sleep(2000);
		
		// click on other menu's Item 1
		driver.findElement(By.xpath("//td[3]//div[1]//table[1]//tbody[1]//tr[1]//td[1]//a[1]")).click();
		

	}

}
