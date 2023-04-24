package Day19th;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Libraries;



public class Alerts extends Libraries
 {
	@BeforeSuite
	public void beforeSuite()
	{
		try 
		{
			ReadPropertiesFile();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@BeforeTest
	public void setup() throws IOException
	{
		LaunchBrowser();
	}
	@Test(priority=-2)
	public void AlertsPageLoad()
	{
		driver.get(objProperties.getProperty("ALertsUrl"));
		//Thread.sleep(5000);
		String TitleOfAlertsPage = driver.getTitle();
		Assert.assertEquals(TitleOfAlertsPage, "Practice handling Alerts in selenium webdriver");
	}
	@Test(priority=1)
	public void NormalAlertsValidation() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		Alert normalAlert=driver.switchTo().alert();
		String normalAlertText=normalAlert.getText();
		System.out.println(normalAlertText);
		Assert.assertEquals(normalAlertText,"I am alert");
		Thread.sleep(3000);
		normalAlert.accept();
	}
	@Test(priority=2)
	public void ConfirmationBoxAlertsValidation() throws InterruptedException
	{
		driver.findElement(By.name("confirmation")).click();
		Alert ConfirmationBoxAlert= driver.switchTo().alert();
		String ConfirmationBoxAlertText=ConfirmationBoxAlert.getText();
		System.out.println(ConfirmationBoxAlertText);
		Assert.assertEquals(ConfirmationBoxAlertText, "I am confirm");
		Thread.sleep(3000);
		ConfirmationBoxAlert.accept();
		
	}
	@Test(priority=3)
	public void PromptAlertValidation() throws InterruptedException
	{
		driver.findElement(By.name("prompt")).click();
		Alert PromptAlert= driver.switchTo().alert();
		String PromptAlertText=PromptAlert.getText();
		System.out.println(PromptAlertText);
		Assert.assertEquals(PromptAlertText, "I am prompt");
		Thread.sleep(3000);
		PromptAlert.dismiss();
		
	}
	@Test(priority=4)
	public void DoubleClickAlertValidation() throws InterruptedException
	{
		Actions act=new Actions(driver);
		WebElement doubleclick=driver.findElement(By.id("double-click"));
		act.doubleClick(doubleclick).build().perform();
		Alert DoubleClickAlert= driver.switchTo().alert();
		String DoubleClickAlertText=DoubleClickAlert.getText();
		System.out.println(DoubleClickAlertText);
		Assert.assertEquals(DoubleClickAlertText, "You double clicked me!!!, You got to be kidding me");
		Thread.sleep(3000);
		DoubleClickAlert.dismiss();
		
	}
	
     @AfterTest
	public void close() 
	{
    	 tearDown();
	}
 }
