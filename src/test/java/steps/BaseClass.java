package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private WebDriver driver;
	
	@Before
	public void setDriver()
	{
		ChromeOptions co = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
	}
	
	@After
	public void tearDriver(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr,"image/png",scenario.getName());
		}
		driver.quit();
	}

	public WebDriver getDriver()
	{
		return driver;
	}
}
