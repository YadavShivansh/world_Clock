package worldClock.StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utils.HelperClass;
import com.utils.excelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import worldClock.PageObjects.WorldClockPage;

public class OneCognizantStepDefination {
	static WorldClockPage W;
	static HelperClass b=new HelperClass();
	public static WebDriver driver;
	String path1= System.getProperty("user.dir")+"\\src\\test\\resources\\Output.xlsx";
	 int number;

	@Given("user scrolls to One Cognizant button")
	public void user_scrolls_to_one_cognizant_button() {
		driver = HelperClass.getDriver();
		W=new WorldClockPage(driver);
		W.scrollup();
	}

	@When("user clicks on One cognizant and navigates to one cognizant window")
	public void user_clicks_on_one_cognizant_and_navigates_to_one_cognizant_window() {
		W.clickOneCognizant();
		String originalWindow = driver.getWindowHandle();
		
		for (String windowHandle : driver.getWindowHandles()) {		//to handle windows
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2)); // to provide timeout

		Assert.assertEquals(W.title(),"OneCognizant");

		
	}

	@When("user clicks on view all apps")
	public void user_clicks_on_view_all_apps() {
		W=new WorldClockPage(driver);
		W.viewAllApps();
	}

	@Then("all enabled and disabled alphabetical apps are verified")
	public void all_enabled_and_disabled_alphabetical_apps_are_verified() throws IOException {
		W=new WorldClockPage(driver);
		int size =W.apps.size();
		for(int j=1;j<=size;j++) {				//to store enabled & disabled alphabets in excel 
			if(j!=24 && j<24) {
			excelUtils.setCellData(path1,"Sheet1", j+6, 0, W.alpha(j).getText());
			}
			else if(j!=24 && j>24) {
				excelUtils.setCellData(path1,"Sheet1", j+5, 0, W.alpha(j).getText());

			}
			else {
				excelUtils.setCellData(path1,"Sheet1", 7, 1, W.alpha(j).getText());

			}
		}
		}
	
	@Then("all the apps corresponding to a number are displayed")
	public void all_the_apps_corresponding_to_the_number_are_displayed(){
		int max=27;
		int min=1;
			Random r= new Random();				//to generate a random number
			number= r.nextInt(max-min+1)+min;
		W=new WorldClockPage(driver);
		try {
			W.hotApps(number);
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}





