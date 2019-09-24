package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;





public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	

	public WebDriver InitialiseDriver() throws IOException {
		
		//Creating Properties Obj to load properties file
		prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Activants46\\eclipse-workspace\\end2EndProject\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		//Getting the browser name from the file
		String browsername=prop.getProperty("browser");
		
		//use equals method to compare content in Java
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Activants46\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browsername.equals("FireFox"))
		{
			//
		}
		else if(browsername.equals("IE")) 
		{
			//
		}
		
		//putting wait and maximising window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void screenshot(String result) throws IOException
	{
		 File SrcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(SrcFile,new File("C:\\Test\\"+result+"screenshot.png"));
		
		
		 
	}

}
