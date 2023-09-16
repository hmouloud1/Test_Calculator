package calculators.calculator;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
//This is a Page Objects Model where we store Element of the page
//Also we add methods that interact with the page
public class POMCalc {
	 WebDriver driver;
	//repository of keyboard keys can be added here as needed
	 By zero = By.id("zero");
	 By one = By.id("one");
	 By three = By.id("three");
	 By eight = By.id("eight");
	 By plus = By.id("plus");
	 By subtract = By.id("subtract");
	 By multiply = By.id("multiply");
	 By equal = By.id("equals");
	 By display = By.xpath("//div[@id='display']/div");
	 
	//This is a class constructor
	public POMCalc(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//This method will click the element passed as a parameter
	public void keyClick(By element)
	{
		driver.findElement(element).click();
	}
	
	//This method will click the webelement passed as a parameter
	public void stepScrenShot(String scName) throws IOException
	{
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File img = scrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File(scName));
	}
	
	// This method will read and validate that the valued keyed in is correct
	public boolean checkValueKeyIn(String expectedValue) throws IOException
	{
		//Take screen shot of the step and save it in result.screenshots folder
		stepScrenShot("./result.screenshots/screen_shot_"+expectedValue+".png");

		//Verify the values (keyed in or calculated) vs the one displayed
		String actualValue = driver.findElement(display).getText();
		if(expectedValue.equalsIgnoreCase(actualValue))
		{
			System.out.println("Step Passed: The expected value is: " + expectedValue
					+ " and the actual value is : "+ actualValue);
		}else
		{
			System.out.println("Step Failed: The expected value is: " + expectedValue
					+ " and the actual value is : "+ actualValue);
			
			//Fail test case at this step
			Assert.assertTrue("Test case Fails: The expected value is: " + expectedValue
					+ " and the actual value is : "+ actualValue, false);
		}
		return true;
	}

}
