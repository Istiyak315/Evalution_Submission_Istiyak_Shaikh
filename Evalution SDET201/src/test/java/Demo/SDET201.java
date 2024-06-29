package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SDET201 {
WebDriver driver;
	
	@BeforeTest
	public void Login() throws InterruptedException {
		
		ChromeDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(4000);
		
		//logging with valid username and password
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
	}
	
	@Test
	public void test2() throws InterruptedException {
		
		//After Login, click on Admin and select User Management > Users:
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@class=\"oxd-main-menu-item\"])[1]")).click();
		
		Thread.sleep(3000);
		
		
		//Select 'Ranga Akunuri' is not working i used 'john smith' from the Employee Name dropdown (or another available name)
		
		WebElement wb= driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		wb.sendKeys("john");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@role=\"option\"])[2]")).click();
		
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		
		// Assert the Employee name of ‘James Butler’ and check the status whether enabled or not from the web table
		
		driver.navigate().refresh();
		
		WebElement sb=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		sb.sendKeys("jam");
		
		
		driver.findElement(By.xpath("[role=option]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		
		
		
	}
	
	@AfterTest
	public void Logout() {
		
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
	

}



