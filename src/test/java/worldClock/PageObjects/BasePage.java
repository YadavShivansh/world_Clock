package worldClock.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	static WebDriver driver;
	//Base page for initialization which extended by other page object classes
	@SuppressWarnings("static-access")
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);		//pageFactory initialization
	}
}
