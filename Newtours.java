package SeleniumTest;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Newtours {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		String baseurl="http://newtours.demoaut.com/index.php";
		String Expresult="Welcome: Mercury Tours";
		String Expresult2="Contact Information";
		String Expresult3="Note: Your user name is Rajkumar.";
		String Expresult4="Welcome back to Mercury Tours!";
		String Expresult5="Find a Flight: Mercury Tours:";
		String Expresult6="Your itinerary has been booked!";
		
		driver.get(baseurl);
		
		String Actualresult = driver.getTitle();
		
		Assert.assertEquals(Expresult, Actualresult);
		System.out.println("Title Verified successfully");
		Thread.sleep(2000);
				//**********Registration**************
//						driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
//						Thread.sleep(2000);
//						String Actualresult2 = driver.findElement(By.xpath("//font[contains(text(),'Contact ')]")).getText();
//						
//						Assert.assertEquals(Expresult2, Actualresult2);
//						System.out.println("Registration Page Openned succesfully");
//						Thread.sleep(1000);
//						
//						driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Raj");
//						Thread.sleep(2000);
//						driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("kumar");
//						driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9916551317 ");
//						driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("shashi@gmail.com ");
//						driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Mahadevapura ");
//						driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bangalore");
//						driver.findElement(By.xpath("//input[@name='state']")).sendKeys("karnataka ");
//						driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("560048 ");
//						Thread.sleep(2000);
//						
//						Select drp=new Select(driver.findElement(By.name("country")));
//						drp.selectByVisibleText("INDIA");
//						Thread.sleep(2000);
//						driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Rajkumar");
//						driver.findElement(By.xpath("//input[@name='password']")).sendKeys("raju@1234");
//						driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("raju@1234");
//						Thread.sleep(2000);
//						
//						driver.findElement(By.xpath("//input[@name='register']")).click();
//						Thread.sleep(10000);
//						String Actualresult3 = driver.findElement(By.xpath("//b[contains(text(),'Note: Your user name is Rajkumar.')]")).getText();
//					
//						Assert.assertEquals(Expresult3,Actualresult3);
//						System.out.println("Registration Done succesfully");
//						Thread.sleep(2000);
//						driver.findElement(By.xpath("//a[contains(text(),'sign-in')]")).click();
//						Thread.sleep(2000);
//						String Actualresult4 = driver.findElement(By.xpath("//b[contains(text(),'Welcome back to ')]")).getText();
//						
//						Assert.assertEquals(Expresult4, Actualresult4);
//						
		System.out.println("SignIn Page openned successfully");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("nishant86");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Nish@nt123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		String Actualresult5 = driver.getTitle();
		Assert.assertEquals(Expresult5, Actualresult5);
		System.out.println("Logged in successfully");
	
//		driver.findElement(By.xpath("//a[contains(text(),'ITINERARY')]")).click();
//		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
		
		//**************flight booking**************************
			
				for(int i=0;i<2;i++) //For Passenger
				{
					
					Select Pass=new Select(driver.findElement(By.xpath("//select[@name='passCount']")));  //Passenger
					List<WebElement> Pass1 = Pass.getOptions();
					Pass.selectByIndex(i);
					System.out.println("\n For "+Pass1.get(i).getText()+" PASSENGER ");
					Thread.sleep(1000);
					for(int j=0;j<10;j++)//Departuring
					{
						
						Select dep=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));  //Departing From
						List<WebElement> dep1 = dep.getOptions();
						dep.selectByIndex(j); 
						System.out.println("   Departing from: "+dep1.get(j).getText());
						Thread.sleep(1000);
						Select ONm1=new Select(driver.findElement(By.xpath("//select[@name='fromMonth']"))); //ON month
						ONm1.selectByVisibleText("March");
						Select ONd1=new Select(driver.findElement(By.xpath("//select[@name='fromDay']"))); //ON Day
						ONd1.selectByValue("25");
						
						for(int k=0;k<10;k++) //  Arriving
						{
							Select Arr=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));  //Arriving In
							List<WebElement> Arr1 = Arr.getOptions();
							Arr.selectByIndex(k);
							System.out.println("-----------On : March 25 and Arriving In :"+Arr1.get(k).getText()+" and  Returning : March 25 ");	
							Thread.sleep(1000);
							Select ONm2=new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))); //ON month
							ONm2.selectByVisibleText("March");
							Select ONd2=new Select(driver.findElement(By.xpath("//select[@name='toDay']"))); //ON Day
							ONd2.selectByValue("25");
							driver.findElement(By.xpath("//input[@value='Business']")).click();  //Service class
							Thread.sleep(1000);
							Select Airline=new Select(driver.findElement(By.xpath("//select[@name='airline']")));  //Airline
							Airline.selectByVisibleText("Blue Skies Airlines");
							
							driver.findElement(By.xpath("//input[@name='findFlights']")).click();  //Continue button clicked
							Thread.sleep(1000);
							JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(0,1000)");
							Thread.sleep(1000);
							driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
							Thread.sleep(1000);
						//driver.findElement((By.xpath("//b[contains(text(),'$584')]"))
								
							driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("Shashi");	 // first name
							driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("kumar");   //  Last Name
							driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys("456123");	  // Credit card number
							driver.findElement(By.xpath("//input[@name='buyFlights']")).click(); //Secure booking
							Thread.sleep(1000);
							String Actualresult6=driver.findElement(By.xpath("//font[@size='+1']")).getText();
							Thread.sleep(1000);
							Assert.assertEquals(Expresult6, Actualresult6);	
							
							driver.findElement(By.xpath("//img[@src='/images/forms/backtoflights.gif']")).click();
							Thread.sleep(1000);
							System.out.println("-----Your itinerary has been booked! and  DEPART Price: $281 and RETURN Price: $303");
						}
						
						}
					System.out.println("-----Your itinerary has been booked!");
				}
			}
	}
