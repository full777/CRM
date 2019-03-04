package crm.com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseBrowser {
	public static WebDriver driver;
		public UseBrowser(){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
					driver=new ChromeDriver();
					//driver.get("http://localhost:9999/JavaPrj_6");
					driver.manage().window();
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//µÈ´ý
		}	
	
}
