package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage_POM extends BasePage
{
//	constructor
	public myAccountPage_POM(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountHeading;
	
//	create a return type method
	
	public boolean isMyAccountPageExist()
	{
		try
		{
		  return(myAccountHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	
//	click on logout btn
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	WebElement Logout;
	
	public void ClickLogoutBtn()
	{
		Logout.click();
	}
	
	
	
	
	
	
	
	
}
