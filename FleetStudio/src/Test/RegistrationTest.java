package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.Registration;
import utils.Setup;

public class RegistrationTest {

	public WebDriver driver;
	public Properties prop;
		
	Setup setup = new Setup();
		
	@Test(enabled=true)
	public void registerWithValidCredentialWithOnlyMandatoryFields() {
		Registration registrationPage = new Registration(driver);
		  
		String url = "https://tutorialsninja.com/demo/index.php?route=account/register";
		driver.get(url);
		  
		registrationPage.firstName.sendKeys("firstName");
		registrationPage.lastName.sendKeys("lastname");
		registrationPage.email.sendKeys("email@g.com");
		registrationPage.telephone.sendKeys("1234567890");
		  
		registrationPage.password.sendKeys("123qwe");
		registrationPage.passwordConfirm.sendKeys("123qwe");
		  
		registrationPage.continu.click();
		  
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");	  
	}
	  
	  @Test(enabled=true)
	  public void registerWithValidCredentialWithAllFields() {
		  Registration registrationPage = new Registration(driver);
		  
		  String url = "https://tutorialsninja.com/demo/index.php?route=account/register";
		  driver.get(url);
		  
		  registrationPage.firstName.sendKeys("firstName");
		  registrationPage.lastName.sendKeys("lastname");
		  registrationPage.email.sendKeys("emai@g.com");
		  registrationPage.telephone.sendKeys("1234567890");
		  
		  registrationPage.password.sendKeys("123qwe");
		  registrationPage.passwordConfirm.sendKeys("123qwe");
		  
		  registrationPage.suscribeYes.click();
		  
		  registrationPage.privacyPolicy.click();
		  
		  registrationPage.continu.click();
		  
		  Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");	  
	  }
	  
	  @Test(enabled=false)
	  public void validatingPrivacyPolicyWarningMessage() {
		  Registration registrationPage = new Registration(driver);
		  
		  String url = "https://tutorialsninja.com/demo/index.php?route=account/register";
		  driver.get(url);
		  
		  registrationPage.firstName.sendKeys("firstName");
		  registrationPage.lastName.sendKeys("lastname");
		  registrationPage.email.sendKeys("ema@g.com");
		  registrationPage.telephone.sendKeys("1234567890");
		  
		  registrationPage.password.sendKeys("123qwe");
		  registrationPage.passwordConfirm.sendKeys("123qwe");
		  
		  registrationPage.suscribeYes.click();
		  
		  registrationPage.continu.click();
		  
		  String privacyPolicyWarningMessage =registrationPage.privacyPolicyWarningMessage.getText();
		  
		  Assert.assertEquals(privacyPolicyWarningMessage, "Warning: You must agree to the Privacy Policy!");	  
	  }
	  
	  @Test(enabled=false)
	  public void withoutEnteringDetailsUserClicksOnContinue() {
		  Registration registrationPage = new Registration(driver);
		  
		  String url = "https://tutorialsninja.com/demo/index.php?route=account/register";
		  driver.get(url);
		  
		  registrationPage.continu.click();
		  
		  String registeredPageTitle = "Your Account Has Been Created!";
		  
		  Assert.assertFalse(registeredPageTitle.equals(driver.getTitle()));;	  
	  }
	  
	  @Test(enabled=false, dataProvider="alreadyRegisteredEmail")
	  public void userEntersAlreadyRegisteredEmail(String firstName, String lastName, String email, String phNum,String pass, String cPass) {
		  Registration registrationPage = new Registration(driver);
		  
		  String url = "https://tutorialsninja.com/demo/index.php?route=account/register";
		  driver.get(url);
		  
		  registrationPage.firstName.sendKeys(firstName);
		  registrationPage.lastName.sendKeys(lastName);
		  registrationPage.email.sendKeys(email);
		  registrationPage.telephone.sendKeys(phNum);
		  
		  registrationPage.password.sendKeys(pass);
		  registrationPage.passwordConfirm.sendKeys(cPass);
		  
		  registrationPage.suscribeYes.click();
		  
		  registrationPage.privacyPolicy.click();
		  
		  registrationPage.continu.click();
		  
		  String registeredPageTitle = "Your Account Has Been Created!";
		  
		  Assert.assertFalse(registeredPageTitle.equals(driver.getTitle()));;	  
	  }
	  
	  @DataProvider(name="alreadyRegisteredEmail")
	  public String[][] getData(){
		  String[][] data = {{"abc", "def", "abc@b.c", "123", "123qwer", "123qwer"},
		  					 {"abcd", "defg", "abcd@b.c", "1234", "123qwery", "123qwery"}};
		  return data;
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

	  @BeforeClass
	  public void beforeClass() {
		  this.driver = setup.driver;
	  }


}
