package worldClock.StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import worldClock.PageObjects.LoginPage;
import worldClock.PageObjects.WorldClockPage;

public class LoginStepDefination {
	static LoginPage p ;
	static Properties Pr;
	static WorldClockPage W;
	static HelperClass b=new HelperClass();
	public static WebDriver driver;
	
	@Given("navigate the browser to Be.cognizant portal with the url")
	public void navigate_the_browser_to_be_cognizant_portal_with_the_url(){
		driver = HelperClass.getDriver();		//calling driver from helper class

	}
	@When("user provides valid credintials with usermail\\/phone\\/skype")
	public void user_provides_valid_credintials_with_usermail_phone_skype() throws IOException {
    	Pr=HelperClass.getProperties();
    	p=new LoginPage(driver);
    	
		try{
			p.setEmail(Pr.getProperty("email"));			//handles usermail login page
		}
			catch(Exception e) {
			}
		try {
			p.setPassword(Pr.getProperty("password"));		//handles password login page
		}
            catch(Exception e) {
			}
		try {
			p.staySignedin();								//handles stay signed page
		}
		    catch(Exception e) {
			}
       
       }
	    
	@When("verify the title of the be cognizant portal")
	public void verify_the_title_of_the_be_cognizant_portal() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));    //verifying the title of homepage
		Assert.assertEquals(driver.getTitle(),"Be.Cognizant - Home");
	}
	@When("user clicks on account manager icon")
	public void user_clicks_on_account_manager_icon() {
		W=new WorldClockPage(driver);									//to click on account manager
		W.account();

	}
	
	@Then("valid usermail should be displayed")
	public void valid_usermail_should_be_displayed() throws IOException {
		W=new WorldClockPage(driver);
		System.out.println(W.verify());
		Assert.assertEquals(W.verify(), Pr.getProperty("email"));		//to verify the usermail
		if(W.verify().equalsIgnoreCase(Pr.getProperty("email"))){
			System.out.println("Website launch is cognizant portal with correct user");
		}
		else {
			System.out.println("Website launch is incorrect");

		}
		W.account();

	}
}
