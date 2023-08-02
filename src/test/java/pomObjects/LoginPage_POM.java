package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage_POM extends BasePage 
{
	public LoginPage_POM(WebDriver driver)
	{
	  super(driver);	
	}
	
//	send email
	@FindBy(id="input-email")
	WebElement emailId;
	
	public void SetEmailId(String username)
	{
		emailId.sendKeys(username);
	}
	
	
//	send password
	@FindBy(id="input-password")
	WebElement Password;
	
	public void SetPassword(String password)
	{
		Password.sendKeys(password);
	}
	

//	click login
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	public void ClickLoginBtn()
	{
		loginbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
}
