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

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	
	public static Logger log=LogManager.getLogger(ValidateNavbar.class.getName());
	
	@BeforeClass
	
	public void initialize() throws IOException
	{
		driver=InitialiseDriver();
		//using prop obj from Base class(Inheritance) to get url form data.properties
		
		
	}


	
	@Test(dataProvider="getdata")
	public void Login(String username,String password,String txt) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		LoginPage l1=new LoginPage(driver);
		l1.getemail().sendKeys(username);
		l1.getpassword().sendKeys(password);
		System.out.println(txt);
		l1.getsignin().click();
		log.info("Submit is clicked");
		
	}
	
	@DataProvider
	
	public Object[][] getdata()
	{
		Object[][] data= new Object[2][3];
		
		data[0][0]="Unrestricted@gmail.com";
		data[0][1]="1234";
		data[0][2]="Unrestricted";
		data[1][0]="restricted@gmail.com";
		data[1][1]="5678";
		data[1][2]="restricted";
		
		return data;
		
	}
	
	@AfterClass
	
	public void teardown()
	{
		driver.close();
		driver=null;
		
	}

}
