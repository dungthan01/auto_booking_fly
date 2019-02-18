package OneWay;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import OneWay.Model.*;

public class Utils {
	public static WebDriver driver;
	public static String baseurl = "http://elines.tratotec.net/";
	public static String driverpath = "C:\\\\chromedriver.exe";
	
	public static void filterAction(WebDriver dr, filterModelInput model) {
		
		dr.findElement(By.id("FromAirportText")).click();
		
		WebElement fromElement = new WebDriverWait(dr, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='qt_list-departure']//a[@airportcode='" + model.From + "']")));
		fromElement.click();
		
		WebElement toElement = new WebDriverWait(dr, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='qt_list-return']//a[@airportcode='" + model.To + "']")));
		toElement.click();
		
		dr.findElement(By.id("DepartureDateFake")).click();

		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement dateWidget = dr.findElement(By.id("ui-datepicker-div"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
		
		for (WebElement cell: columns){
			   //Select 13th Date 
		   if (cell.getText().equals(model.DepartureDate)){
		      cell.findElement(By.linkText(model.DepartureDate)).click();
		      break;
		   }
		}
		
		dr.findElement(By.className("submit_tk")).click();
	}
}
