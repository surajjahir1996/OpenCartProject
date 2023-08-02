package pomObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends BasePage
{

	
public RegisterationPage(WebDriver driver) 
   {
		super(driver);
	
   }

//	send firstname
  @FindBy(id="input-firstname")
  WebElement Firstname;
  
  public void SetUserName(String username)
  {
	  Firstname.sendKeys(username);
  }
  
//  send lastname
  @FindBy(id="input-lastname")
  WebElement Lastname;
  
  public void SetLastName(String lastname)
  {
	  Lastname.sendKeys(lastname);
  }
  
//  send email
  @FindBy(id="input-email")
  WebElement Email;
  
  public void SetEmailId(String email)
  {
	  Email.sendKeys(email);
  }
  
  
//  send telephone
  @FindBy(id="input-telephone")
  WebElement telephoneNo;
  
  public void SetTelephoneNum(String telephoneNum )
  {
	  telephoneNo.sendKeys(telephoneNum);  
  }
  
  
//  send confirm password
  @FindBy(id="input-confirm")
  WebElement confirmPass;
  
  public void SetConfirmPass(String confirmpass)
  {
	  confirmPass.sendKeys(confirmpass);
  }
  
  
  
//	send password
  @FindBy(id="input-password")
  WebElement Password;
	
  public void SetPassword(String password)
  {
	 Password.sendKeys(password);
  }
	
// click check box
  @FindBy(xpath="//input[@type='checkbox']")
  WebElement chkBox;
	
 public void ChkboxPolicy()
  {
 	chkBox.click();
  }
 
// click continue btn
 @FindBy(xpath="//input[@class='btn btn-primary']")
 WebElement continueBtn;
 
 public void ClickContinueBtn()
  {
	continueBtn.click(); 
  }	
 
 
// get confirm mesg
 
 @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
 WebElement confirmMesg;
 
 public String GetConfirmMesg()
 {
	 
try
 {
	 return (confirmMesg.getText());
 }
catch(Exception e)
{
	return(e.getMessage());
}
 
 
	
}
}
