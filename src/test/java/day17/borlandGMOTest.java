package day17;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class borlandGMOTest {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Open URL
		driver.get("http://demo.borland.com/gmopost/");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Click on Enter GMO OnLine
		driver.findElement(By.xpath("//input[@value='Enter GMO OnLine']")).click();
		
		// click on 3 Person Dom Tent 
		driver.findElement(By.name("QTY_TENTS")).clear();
		driver.findElement(By.name("QTY_TENTS")).sendKeys("2");
		driver.findElement(By.name("bSubmit")).click();
		
		//Dom Tent Unit Price
	     String unitPriceWith$=driver.findElement(By.xpath("//tbody/tr[2]/td[4]")).getText();
		 System.out.println("UnitPrice of Dom Tent is "+unitPriceWith$);
		 String unitPriceWithout$=unitPriceWith$.substring(2).trim();
		 System.out.println("After romove $ Unit Price is "+unitPriceWithout$);
		 float calculatedTotalPrice=Float.parseFloat(unitPriceWithout$)*2;
		 System.out.println("After calculation the Total Price is "+calculatedTotalPrice);
		 
		 //getting Total Price from the App
		 String totalPriceWith$=driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();
		 System.out.println("Total Price with $ is "+totalPriceWith$);
		 String totalPriceWithout$=totalPriceWith$.substring(2).trim();
		 System.out.println("Total Price without $ is "+totalPriceWithout$);
		 float totalPricefromApp=Float.parseFloat(totalPriceWithout$);
		 System.out.println(totalPricefromApp);
		 
		 //getting Sales Tax
		 String salesTaxWith$= driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
		 System.out.println("SalesTax with $ is "+salesTaxWith$);
		 String salesTaxWithout$=salesTaxWith$.substring(2).trim();
		 System.out.println("SalesTax without $ is "+salesTaxWithout$);
		 float salesTaxWithout$FromApp =Float.parseFloat(salesTaxWithout$);
		 System.out.println(salesTaxWithout$FromApp);
		 
         //Shipping charges
		 String shippingChargesWith$=driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText();
		 System.out.println("Shipping charges With $ is "+shippingChargesWith$);
		 String shippingChargesWithout$=shippingChargesWith$.substring(2).trim();
		 System.out.println("Shipping charges Without $ is "+shippingChargesWithout$);
		 float shippingChargesWithout$FromApp =Float.parseFloat(shippingChargesWithout$);
		 System.out.println(shippingChargesWithout$FromApp);
		 
		 //gettin GrandTotal
		  String grandTotalWith$=driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText();
		  System.out.println("Grand Total with $ is "+grandTotalWith$);
		  String grandTotalWithout$=grandTotalWith$.substring(2).trim();
		  System.out.println("Grand Total without $ is "+grandTotalWithout$);
		  float grandTotalWithout$fromApp=Float.parseFloat(grandTotalWithout$);
		  System.out.println(grandTotalWithout$fromApp);
		  
		  //Caluculating Grand Total
		  float calGrandtotal=calculatedTotalPrice+salesTaxWithout$FromApp+shippingChargesWithout$FromApp;
		  System.out.println(calGrandtotal);
		  
		  if(grandTotalWithout$fromApp==calGrandtotal)
		  {
			  System.out.println("Calculation is Success");
		  }
		  else
		  {
			  System.out.println("Calculation is Failed");
		  }
		  
		  //Close App
		  driver.close();
		 
	}

}
