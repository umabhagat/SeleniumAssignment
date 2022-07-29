package Assignment;

//import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Program1 {

	public static void main(String[] args) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\UMA\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.facebook.com/reg");
	 Thread.sleep(2000);//add wait
	 String Title=driver.getTitle();
	 System.out.println(Title);
	 if(Title.equalsIgnoreCase("Sign up for Facebook | Facebook"))
	 {
	 System.out.println("Pass");
	 }
	 else
	 {
	 System.out.println("Fail");
	 }
	 driver.findElement(By.name("firstname")).sendKeys("Uma");
	 driver.findElement(By.name("lastname")).sendKeys("Bhagat");

	driver.findElement(By.name("reg_email__")).sendKeys("7626972692");

	//driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abc@gmail.com");

	driver.findElement(By.id("password_step_input")).sendKeys("Test@12345");

	 //Selection of date in dropdown
	 WebElement Day=driver.findElement(By.id("day"));
	 Select date= new Select(Day);
	 date.selectByIndex(19);
	 System.out.println(date.getFirstSelectedOption());

	//Selection of month in dropdown
	 WebElement Month=driver.findElement(By.id("month"));
	 Select month= new Select(Month);
	 month.selectByValue("8");
	 System.out.println(month.getFirstSelectedOption());

	//Selection of year in dropdown
	 WebElement Year=driver.findElement(By.id("year"));
	 Select year= new Select(Year);
	 year.selectByVisibleText("1991");
	 System.out.println(year.getFirstSelectedOption());

	 Thread.sleep(2000);
	 
	 //driver.findElement(By.id("u_0_2_te")).click();
	 
	 driver.findElement(By.name("websubmit")).click();
	 Thread.sleep(2000);
	 
	 String parent= driver.getWindowHandle();
	 driver.switchTo().newWindow(WindowType.WINDOW);
	 driver.get("https://demoqa.com/alertsWindows");
	 String url=driver.getCurrentUrl();
	 System.out.println(url);
	 
	 String Title1=driver.getTitle();
	 System.out.println(Title1);
	 if(Title1.equalsIgnoreCase("ToolsQA"))
	 {
	 System.out.println("Pass");
	 }
	 else
	 {
	 System.out.println("Fail");
	 }
	 
	 driver.findElement(By.xpath("//*[contains(text(),'Alerts')]")).click();
	 //driver.close();
	 WebElement frames = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
	 driver.switchTo().frame(frames);
	 
	 driver.switchTo().defaultContent();
	 
	 driver.switchTo().window(parent);
	}

}
