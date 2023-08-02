package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_POM extends BasePage 
{

  
//   create a constructor
  public HomePage_POM(WebDriver driver)
  {
	super(driver);
	
  }
  
//  find elements
//  click my account
  @FindBy(xpath="//a[@title='My Account']")
  WebElement myAccount;
  
  public void ClickMyAccount()
  {
	myAccount.click();  
  }
  
  @FindBy(linkText="Register")
  WebElement Register;
  
  
  public void ClickRegister()
  {
	  Register.click();
  }
  
  
//  click on login
  @FindBy(xpath="//a[text()='Login']")
  WebElement login;
  
  public void Clicklogin()
  {
	login.click();
  }
  
  
  
 	
}
