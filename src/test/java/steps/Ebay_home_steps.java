package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Ebay_home_steps {
	WebDriver driver;

	public Ebay_home_steps(BaseClass base)
	{
		this.driver = base.getDriver();
	}
	
	@Given("I am on Ebay home page")
	public void i_am_on_Ebay_home_page()
	{
		driver.get("https://www.ebay.com");
		System.out.println("I am on Ebay home page");
	}
	@When("I click on advanced link")
	public void i_click_on_advanced_link()
	{
		driver.findElement(By.xpath("//a[@title='Advanced Search']")).click();
		System.out.println("I click on advanced link");
	}
	@Then("I navigate to Advanced search page")
	public void i_navigate_to_advances_search_page()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Advanced Search | eBay", title);
		System.out.println("I navigate to Advanced search page");
	}

	@Given("I am on ebay home page")
	public void i_am_on_ebay_home_page() {
		driver.get("https://www.ebay.com");
		System.out.println("I am on Ebay home page");
	}
	@When("I search for {string}")
	public void i_search_for(String string) {
		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys(string);	
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	}
	@Then("I validate altleast {int} search items present")
	public void i_validate_altleast_search_items_present(Integer int1) {
	    String itemCount = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/span[1")).getText().trim();
        String itc = itemCount.replace(",", "");
	    int count = Integer.parseInt(itc); 
        if(count <= int1)
        {
        	System.out.println("less than 1000 results");
        }
	}

}
