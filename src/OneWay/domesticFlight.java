package OneWay;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import OneWay.Model.filterModelInput;

public class domesticFlight {
	@BeforeTest
	public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", Utils.driverpath);
	  Utils.driver = new ChromeDriver();
	  Utils.driver.get(Utils.baseurl);
	  Utils.driver.manage().window().maximize();
    }
	
	@BeforeMethod
	public void GoToHomePage() {
		Utils.driver.navigate().to(Utils.baseurl);
    }
	
	@Test (priority = 0)
	public void check_same_from_to() {
		
		filterModelInput model = filterModelInput.createNew("HAN", "HAN", "21");
		
		Utils.filterAction(Utils.driver, model);
		
		// verify data
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = Utils.driver.findElements(By.className("out-bound"));
		
		assertEquals(elements.size(), 0);
	}
	
	@Test (priority = 1)
	public void check_different_from_to_no_data() {
		
		filterModelInput model = filterModelInput.createNew("HAN", "THD", "21");
		
		Utils.filterAction(Utils.driver, model);
		
		// verify data
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = Utils.driver.findElements(By.className("out-bound"));
		
		assertEquals(elements.size(), 0);
	}
	
	@Test (priority = 2)
	public void check_different_from_to_have_data_vn() {
		
		filterModelInput model = filterModelInput.createNew("HAN", "SGN", "21");
		
		Utils.filterAction(Utils.driver, model);
		
		// verify data
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = Utils.driver.findElements(By.className("out-bound"));
		
		WebElement elementImgVN = Utils.driver.findElement(By.xpath("//img[@src='/Themes/Elines/images/VN.png']"));
		
		assertTrue(elements.size() > 0 && elementImgVN != null);
	}
	
	@Test (priority = 3)
	public void check_different_from_to_have_no_data_vn() {
		
		filterModelInput model = filterModelInput.createNew("HAN", "VDH", "19");
		
		Utils.filterAction(Utils.driver, model);
		
		// verify data
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = Utils.driver.findElements(By.className("out-bound"));
		
		List<WebElement> elementImgVN = Utils.driver.findElements(By.xpath("//img[@src='/Themes/Elines/images/VN.png']"));
		
		assertTrue(elements.size() == 0 && elementImgVN.size() == 0);
	}
	
	@Test (priority = 4)
	public void check_different_from_to_have_data_vj() {
		
		filterModelInput model = filterModelInput.createNew("VDH", "SGN", "21");
		
		Utils.filterAction(Utils.driver, model);
		
		// verify data
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = Utils.driver.findElements(By.className("out-bound"));
		
		WebElement elementImgVJ = Utils.driver.findElement(By.xpath("//img[@src='/Themes/Elines/images/VJ.png']"));
		
		assertTrue(elements.size() > 0 && elementImgVJ != null);
	}
	
	@Test (priority = 5)
	public void check_different_from_to_have_no_data_vj() {
		
		filterModelInput model = filterModelInput.createNew("HN", "VHD", "19");
		
		Utils.filterAction(Utils.driver, model);
		
		// verify data
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = Utils.driver.findElements(By.className("out-bound"));
		
		List<WebElement> elementImgVJ = Utils.driver.findElements(By.xpath("//img[@src='/Themes/Elines/images/VJ.png']"));
		
		assertTrue(elements.size() == 0 && elementImgVJ.size() == 0);
	}
	
	@AfterTest
	public void afterTest() {
		  //System.out.println("Test Passed!");
		Utils.driver.close();
	}
  
}
