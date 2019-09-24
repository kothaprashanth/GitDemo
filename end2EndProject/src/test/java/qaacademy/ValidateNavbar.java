package qaacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavbar extends Base {
	
	public static Logger log=LogManager.getLogger(ValidateNavbar.class.getName());
	
	@BeforeClass
	
	public void initialize() throws IOException
	{
		driver=InitialiseDriver();
		//using prop obj from Base class(Inheritance) to get url form data.properties
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void ValidateNavigationbar() throws IOException
	{
		
		LandingPage l= new LandingPage(driver);
		
		boolean var=l.getnavbar().isDisplayed();
		System.out.println(var);

		Assert.assertTrue(l.getnavbar().isDisplayed());
		log.info("NavBar is displayed");
		
		
	}
	
	@AfterClass
	
	public void teardown()
	{
		driver.close();
		driver=null;
		
	}
	
	

}
