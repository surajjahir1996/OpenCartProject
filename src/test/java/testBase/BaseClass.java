package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass

//in this class we have to create a setup and tear down method
{
	public static WebDriver driver;
	public ResourceBundle rb;   // to call non static ele and config file
	
	
	
@BeforeClass(groups= {"Master","Sanity","Regression"})
@Parameters("browser")
 public void Setup(String browserName)
 {
//	call that method
	rb=ResourceBundle.getBundle("config");  // to load config.properties
	

	if(browserName.equals("chrome"))
	{
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	}
	else if(browserName.equals("edge"))
	{
	 WebDriverManager.edgedriver().setup();
	  driver= new EdgeDriver();
	}
	else
	{
	 WebDriverManager.firefoxdriver().setup();
	  driver= new FirefoxDriver();	
	}
	
	
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get(rb.getString("AppUrl"));  // repeated variable store in config.properties file so use that
 }
	
@AfterClass(groups= {"Master","Sanity","Regression"})
public void TearDown()
{
	driver.quit();
}

public String randomString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return (generatedString);
}


//this method for enter random data in email field which ever you want

public String randomNumber()
{
	String generatedNumber=RandomStringUtils.randomNumeric(3);
	return(generatedNumber);
}
	

public String randomAlphanumeric()
{
	String generatedAlphanum=RandomStringUtils.randomAlphanumeric(6);
	return(generatedAlphanum);
}

public String captureScreen(String tname) 
{
//	create the timestamp for our tc with year,month,date,hour,min,sec etc
	
  /*	SimpleDateFormat df= new SimpleDateFormat();
	    Date dt= new Date();
    String timestamp=df.format(dt);   */
	
//	instead of these we use this statment
	
	String timeStamp=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
	
//	now we create a method for screenshot 
	 
	TakesScreenshot ts=(TakesScreenshot)driver;
	File sourefile=ts.getScreenshotAs(OutputType.FILE);
	
	//File DestFile= new File("./ScreenShots"+tname+".jpg");
	
String DestFile=System.getProperty("user.dir")+"\\ScreenShots\\" + tname +"_"+ timeStamp +".png";

//suppose screenshot is not available then above statment will throw some excet

    try
    {
    	FileUtils.copyFile(sourefile,new File(DestFile));
    }
    catch(Exception e)
    {
    	e.getMessage();
    }
	
	return DestFile;
}
	
	
	
}
