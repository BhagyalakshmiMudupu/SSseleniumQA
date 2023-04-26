package Day20th;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Libraries;

public class frames extends Libraries {
	@BeforeSuite
	public void beforeSuite() {
		try {
			ReadPropertiesFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void setup() throws IOException {
		LaunchBrowser();
	}

	@Test(priority = 1)
	public void framesPageLoad() {
		driver.get(objProperties.getProperty("FramesUrl1"));
		// Thread.sleep(5000);
		String TitleOfFramesPage = driver.getTitle();
		Assert.assertEquals(TitleOfFramesPage, "Frames Practice - H Y R Tutorials");
	}

	@Test(priority = 2)
	public void frame1Validation() throws InterruptedException {
		driver.switchTo().frame("frm1");
		WebElement menuopt = driver.findElement(By.id("selectnav2"));
		Select menuoptions = new Select(menuopt);
		List<WebElement> menuoptionslist = menuoptions.getOptions();

		System.out.println(menuoptionslist.size());

		for (int i = 0; i < menuoptionslist.size(); i++) {
			// System.out.println(menuoptionslist.get(i).getText());
			menuoptions.selectByVisibleText("Home");
		}

		WebElement Menuopt = driver.findElement(By.id("selectnav1"));
		Select Menuoptions = new Select(Menuopt);
		List<WebElement> Menuoptionslist = Menuoptions.getOptions();

		System.out.println(Menuoptionslist.size());

		for (int i = 0; i < Menuoptionslist.size(); i++) {

			// Thread.sleep(5000);
			System.out.println("frame2list" + Menuoptionslist.get(i).getText());
			String dropDownValue = Menuoptionslist.get(i).getText();
			if (dropDownValue.equalsIgnoreCase("- Testing")) {
				//Menuoptions.selectByVisibleText("- Testing");
				 Menuoptionslist.get(i).click();
				break;
			}

		}

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

	/*
	 * @Test(priority=3) public void outofframe() {
	 * driver.findElement(By.id("name")).sendKeys("Search"); }
	 */
	@Test(priority = 4)
	public void frame3Validation() {
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frm3']"));
		driver.switchTo().frame(frame3);
		WebElement frame3menu = driver.findElement(By.xpath("//select[@id='selectnav2']"));
		Select frame3menuoptions = new Select(frame3menu);
		List<WebElement> frame3menuoptionslist = frame3menuoptions.getOptions();
		System.out.println(frame3menuoptionslist.size());
		for (int i = 0; i < frame3menuoptionslist.size(); i++) {

			// Thread.sleep(5000);
			System.out.println("frame3list" + frame3menuoptionslist.get(i).getText());
			String framedrpdownvalues =frame3menuoptionslist.get(i).getText();
			if(framedrpdownvalues.equalsIgnoreCase("-- TestNG"));
			//frame3menuoptions.selectByVisibleText("-- TestNG");
			frame3menuoptionslist.get(i).click();
			break;
		}
	}

	@AfterTest
	public void close() {
		tearDown();
	}
}
