import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

Package Browser

public class BrowserSelection 
{
	static WebDriver driver;
		
	public static WebDriver UsingChrome()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumLibs\\\\chromedriver_win32\\chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		return driver;
	}		
 
}
