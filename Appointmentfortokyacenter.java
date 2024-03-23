package makeAppointment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Appointmentfortokyacenter {
	WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 driver.get("https://katalon-demo-cura.herokuapp.com/");
		
	}
	@Test
	public void Makeappoinment() throws Exception
	{   driver.findElement(By.id("btn-make-appointment")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
	    Thread.sleep(1000);
	    driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
	    Thread.sleep(1000);
	    driver.findElement(By.id("btn-login")).click();
	    Thread.sleep(1000);
	    WebElement facility=driver.findElement(By.id("combo_facility"));
	    List<WebElement> alllinks=facility.findElements(By.tagName("option"));
	    for(int count=0;count<alllinks.size();count++)
	    {
	    	alllinks.get(count).click();
	    	Thread.sleep(1000);
	    	System.out.println(alllinks.get(count).getText());
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("radio_program_medicare")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("txt_visit_date")).sendKeys("26/03/2024");
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("txt_comment")).sendKeys("consider as soon as possible");
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("btn-book-appointment")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a")).click();
	    	Thread.sleep(1000);
	    	
	    	 facility=driver.findElement(By.id("combo_facility"));// as list is empty
		     alllinks=facility.findElements(By.tagName("option"));// ass list is empty
		     driver.findElement(By.id("btn-make-appointment")).click();
		     Thread.sleep(1000);
		     
		     
	    	
	    	
	    	
	    }
	    driver.quit();
	    
	    
		
	}

}
