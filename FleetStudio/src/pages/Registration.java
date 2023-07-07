package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
public WebDriver driver;
	
	@FindBy(xpath = "//input[@name='firstname']" )
	public WebElement firstName;
	@FindBy(xpath = "//input[@name='lastname']" )
	public WebElement lastName;
	@FindBy(xpath = "//input[@name='email']" )
	public WebElement email;
	@FindBy(xpath = "//input[@name='telephone']" )
	public WebElement telephone;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@name='confirm']")
	public WebElement passwordConfirm;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	public WebElement suscribeYes;
	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	public WebElement suscribeNo;
	
	@FindBy(xpath = "//input[@name='agree']")
	public WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continu;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public WebElement alreadyRegisteredEmailWarningMessage;
	
	public Registration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
