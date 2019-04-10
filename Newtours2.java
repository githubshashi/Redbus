package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newtours2 {
	public static void main(String[] args) throws InterruptedException {
		
		String Expected1="Bangalore";
		String Expected2="Mysore";
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Mysore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='db text-trans-uc']")).click();
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='current day'][contains(text(),'10')] ")).click();
		driver.findElement(By.xpath("//label[@class='db text-trans-uc tal']")).click();
		driver.findElement(By.xpath("//div[@class='rb-calendar']//td[@class='wd day'][contains(text(),'11')] ")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(2000);
		String Result2 = driver.findElement(By.xpath("//div[@class='onward d-block fl']//span[@title='Mysore'][contains(text(),'Mysore')]")).getText();
		if(Expected2.equals(Result2))
		{
			System.out.println("Booking Page opened and ready to BOOK as per the trip Plan given");
		}
		else
		{
			System.out.println("Wrong trip plan Provided");
		}

		  JavascriptExecutor js = (JavascriptExecutor) driver;
        	
	        //js.executeScript("window.scrollBy(0,2000)"); // This  will scroll down the page by  1000 pixel vertical	

	       // WebElement Element = driver.findElement(By.xpath("//li[@id='10735044']//div[@class='travels lh-24 f-bold d-color'][contains(text(),'Poornima Tours')]"));
	       // js.executeScript("arguments[0].scrollIntoView();", Element);   //This will scroll the page till the element is found
	        
	      //This will scroll the web page till end.		
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		System.out.println("Done");
		
	}
}
