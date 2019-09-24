package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	By Login=By.xpath("//a[contains(@href,'sign_in')]");
	By Featuredtext=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	
	public WebElement getLogin()
	{
		return driver.findElement(Login);
	}
	
	public WebElement getfeaturedtext()
	{
		return driver.findElement(Featuredtext);
	}
	
	public WebElement getnavbar()
	{
		return driver.findElement(navbar);
	}

}
