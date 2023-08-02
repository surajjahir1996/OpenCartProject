package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomObjects.HomePage_POM;
import pomObjects.RegisterationPage;
import testBase.BaseClass;

public class TC01_Test_Account_Resgistration extends BaseClass
{
    @Test(groups= {"Master","Regression"})
	public void TestRegistration() throws InterruptedException
	{
    	try 
    	{
    	HomePage_POM hp=new HomePage_POM(driver);
    	hp.ClickMyAccount();
    	hp.ClickRegister();
//    	home page work done now reg page
    	
	  RegisterationPage rp= new RegisterationPage(driver);
	  
	  rp.SetUserName(randomString().toUpperCase());
	  
	  rp.SetLastName(randomString().toUpperCase());
	  
	  rp.SetEmailId(randomString()+"@gmail.com");
	  
	  rp.SetTelephoneNum(randomAlphanumeric());
	  
//	  we have to send same value pass for pass and confirm pass so we store the value
	  String password= randomAlphanumeric(); // same pass store in variable
	  
	  rp.SetPassword(password);      // send pass
	  
	  rp.SetConfirmPass(password);   // send confirm pass
	 
	  rp.ChkboxPolicy();
	  Thread.sleep(5000);
	  
	  rp.ClickContinueBtn();
	  
    
//	  now assertion is apply
	  
	  String confirmMesg=rp.GetConfirmMesg();
	  
	  Assert.assertEquals(confirmMesg,"Your Account Has Been Created!");
	  System.out.println("My Tc001 is Passed");
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    		e.getMessage();
    	}
	  
	  
	}
	
		
}
