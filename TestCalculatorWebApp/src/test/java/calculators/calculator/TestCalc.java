package calculators.calculator;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCalc {
	WebDriver driver;
	POMCalc  pageCalc;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("steup method");
	    driver.get("https://duffmanns.github.io/calc-test/calculator/app/index.html");
	    driver.manage().window().maximize();
	    pageCalc = new POMCalc(driver);
	}
	@AfterClass
	public void teardown ()
	{
		driver.close();
		driver.quit();
	}
	
	// This method will test the scenario (10-8) * 3
	@Test(enabled = true)
	  void testCase_001()  throws IOException, InterruptedException
	 {
		pageCalc.keyClick(pageCalc.one);
		pageCalc.checkValueKeyIn("1");
	    Thread.sleep(1000);
	    
	    pageCalc.keyClick(pageCalc.zero);
	    pageCalc.checkValueKeyIn("10");
	    Thread.sleep(1000);
	    
	    pageCalc.keyClick(pageCalc.subtract);
	    Thread.sleep(1000);
	    
	    pageCalc.keyClick(pageCalc.eight);
	    pageCalc.checkValueKeyIn("8");
	    Thread.sleep(1000);
	    
	    pageCalc.keyClick(pageCalc.multiply);
	    pageCalc.checkValueKeyIn("2");
	    Thread.sleep(1000);
	    
	    pageCalc.keyClick(pageCalc.three);
	    pageCalc.checkValueKeyIn("3");
	    Thread.sleep(1000);
	    
	    pageCalc.keyClick(pageCalc.equal);
	    pageCalc.checkValueKeyIn("6");
		
	 }
	//This is the main method to run the testng file
     public static void main(String[] args) throws InterruptedException,  IOException 
	 {
    	    TestNG testng = new TestNG();
    	    List<String> suites = Lists.newArrayList();	
			suites.add(".//testng.xml");//path to xml..
			testng.setTestSuites(suites);
			testng.run();
	 }
}
