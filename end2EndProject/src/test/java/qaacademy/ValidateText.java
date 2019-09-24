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
import resources.Base;

public class ValidateText extends Base {
	
	public static Logger log=LogManager.getLogger(ValidateText.class.getName());
	@BeforeClass
	
	public void initialize() throws IOException
	{
		driver=InitialiseDriver();
		//using prop obj from Base class(Inheritance) to get url form data.properties
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	@Test
	public void validatetextInmainpage() throws IOException
	{
		
		LandingPage l= new LandingPage(driver);
		
		String txt=l.getfeaturedtext().getText();
		
		Assert.assertEquals(txt, "FEATURED COURSES123");
		
	
		
		
	}
	
	@AfterClass
	
	public void teardown()
	{
		driver.close();
		driver=null;
		
	}
	
	

}
