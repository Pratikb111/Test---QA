import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import browser.BrowserSelection;
 
Package Redbus

public class RedbusProject 
{
WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser()
	{	
		
		driver = BrowserSelection.UsingChrome();				
	}
	
	@Test
	public void TripDetails() throws InterruptedException
	{
		driver.get("https://www.redbus.in/");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='src']")).click();
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("GOA");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='dest']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Mumbai");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='search']/div/div[2]/div/ul/li[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label")).click();
		Thread.sleep(2000);
		
		String date = "10-Oct 2018";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];	
		System.out.println(month_year);
		System.out.println(day);
		
		selectDate(month_year,day);		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='search_btn']")).click();
		Thread.sleep(5000);
		
		
	}	
	public void selectDate(String monthyear, String Selectday) throws InterruptedException
	{		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
				
		for (int i=0; i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			//Selecting the month
			if(elements.get(i).getText().equals(monthyear))
			{				
				//Selecting the date				
				List<WebElement> days = driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
				
				for (WebElement d:days)
				{					
					System.out.println(d.getText());
					if(d.getText().equals(Selectday))
					{
						d.click();
						Thread.sleep(10000);
						return;
					}
				}								
				
			}			
					
		}
		driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button")).click();
		selectDate(monthyear,Selectday);
		
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
 
}
