package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.HomePage_POM;
import pomObjects.LoginPage_POM;
import pomObjects.myAccountPage_POM;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass 
{
    @Test(groups= {"Master","Sanity"})
	public void Test_Login()
	{
     try 
     {	
	  HomePage_POM hp= new  HomePage_POM(driver);
	    hp.ClickMyAccount();
		hp.Clicklogin();
		
		LoginPage_POM lp=new LoginPage_POM(driver);
		lp.SetEmailId(rb.getString("username"));
		lp.SetPassword(rb.getString("password"));
		lp.ClickLoginBtn();
		
		myAccountPage_POM ap= new myAccountPage_POM(driver);
		boolean MyAcPage=ap.isMyAccountPageExist();
		Assert.assertEquals(MyAcPage, true,"my tc002 is passed");
     }
     catch(Exception e)
     {
    	 Assert.fail();
     }
		
		
	}
	
	
	
	
	
}
