package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomObjects.HomePage_POM;
import pomObjects.LoginPage_POM;
import pomObjects.myAccountPage_POM;
import testBase.BaseClass;
import utilityPackage.DataProviders;

public class TC003Test_Login_DDT extends BaseClass 
{
	@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class)
	public void TestLoginDDT(String Email,String Pass,String exp) //beacuse xlfile have three col email pass and result
	{
		
		try
		{
			
//		Test Execution starting...........
		HomePage_POM hp=new HomePage_POM(driver);
		hp.ClickMyAccount();
		hp.Clicklogin();
		
		LoginPage_POM lp=new LoginPage_POM(driver);
		lp.SetEmailId(Email);
		lp.SetPassword(Pass);
		lp.ClickLoginBtn();
		
//		Validation
		
		myAccountPage_POM ap= new myAccountPage_POM(driver);
		boolean MyAcPage=ap.isMyAccountPageExist();
		
//		we have xl sheet data by using that we have to do validation
		
		
		if(exp.equals("Invalid"))
		{
			if(MyAcPage==true)  // login Is successful after invalid data
			{
				
				ap.ClickLogoutBtn();
				Assert.assertTrue(false);
				System.out.println("my tc is failed");
			}
			else
			{
//				data is ivalid and login page is not appear then my tc is passed
//				beacuse after sending the invalid data we should not login into the system
				Assert.assertTrue(true);
				System.out.println("my tc is passed");
			}
		}
		
		
		
		if(exp.equals("Valid"))
		{
			if(MyAcPage==true)  // my login is here successful
			{
//	we have to take another parameter from xl file so we do logout
				ap.ClickLogoutBtn();
				Assert.assertTrue(true);
				System.out.println("my tc is passed ");
			}
			else
			{
//				my tc is failed
				Assert.assertTrue(false);
				System.out.println("my tc is failed ");
			}
		}
	
		
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	
	
}
}
