package worldClock.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"i0116\"]")				//xpath for sending usermail
	WebElement SigninEmail;
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")		//xpath for clicking next
	WebElement Next;
	
	@FindBy(xpath="//*[@id=\"i0118\"]")				//xpath for sending password
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']")		//xpath for clicking singin
	WebElement signin;

	
	@FindBy(xpath="//*[@id=\"KmsiCheckboxField\"]")	//xpath for checkbox of stay signedin
	WebElement staysignedCheckBox;
	
	@FindBy(xpath="//*[@id=\"idSIButton9\"]")		//xpath for clicking on yes for stay signedin
	WebElement yesclick;
	
	
	//different methods for sign-in page
	
	//method for Entering user mail/phone/skype
	public void setEmail(String usermail) {   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		//provide time wait
		SigninEmail.sendKeys(usermail);											//send usermail and click
		Next.click();

	}
	
	//method for entering password
	public void setPassword(String pass) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		//provide time wait
		password.sendKeys(pass);												//send password and signin
		signin.click();
		
		

	}
	
	//method for stay signed in
	public void staySignedin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		//provide time wait authentication
		staysignedCheckBox.click();												//click check box for stay signed in
		yesclick.click();
	}

}
