package worldClock.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
 


public class WorldClockPage extends BasePage {

	public WorldClockPage(WebDriver driver) {
		super(driver);
	}
	
	//xpath for accountmanager icon
	@FindBy(xpath="//*[@id=\"O365_MainLink_MePhoto\"]/div/div/div/div/div[2]")
	public WebElement AccountManager;
	
	//xpath for usermail in account details
	@FindBy(xpath="//*[@id=\"mectrl_currentAccount_secondary\"]")
	public WebElement usermail;
	
	//xpath of WorldClock element at bottom of page
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]")
	public WebElement worldClock;
	
	//xpath of Bangalore place
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[1]")
	public WebElement Bangalore;
	
	//xpath of London place
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[1]")
	public WebElement London;

	//xpath of NewYork place
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[1]")
	public WebElement NewYork;
	
	//xpath of Bangalore Time
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement BangaloreTime;
	
	//xpath of London Time
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement LondonTime;
	
	//xpath of NewYork Time
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement NewYorkTime;
	
	//xpath of Bangalore Time Denotion i.e, am/pm
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/span[2]")
	public WebElement BangaloreTimeDenotion;
	
	//xpath of London Time Denotion i.e, am/pm
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]/span[2]")
	public WebElement LondonTimeDenotion;
	
	//xpath of NewYork Time Denotion i.e, am/pm
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/span[2]")
	public WebElement NewYorkTimeDenotion;
	
	//xpath of Bangalore day and date
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div[2]")
	public WebElement BangaloreDate;

	//xpath of London day and date
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]")
	public WebElement LondonDate;
	
	//xpath of NewYork day and date
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/div[2]")
	public WebElement NewYorkDate;
	
	//xpath of Time Difference between Bangalore and London
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]")
	public WebElement TimeDiff1;
	
	//xpath of Time difference between Bangalore and NewYork
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/div[1]")
	public WebElement TimeDiff2;
	
	//xpath of "All apps and tools" header
	@FindBy(xpath="//div[@id='89c5ffca-2ffb-4052-a723-e99c8c9a14ef']")
	public WebElement All_Apps_Tools;
	
	//xpath of onecognizant button
	@FindBy(xpath="//div[@title=\"OneCognizant\"]")
	public WebElement onecognizant;
	
	//xpath of sidebar
	@FindBy(xpath ="//*[@id=\"compleMenuDraggable\"]/div")
	WebElement sidebar;
	
	//xpath of view all apps button
	@FindBy(xpath="//*[@id=\"div_hotappscontainer\"]/div/div[2]/div/div[3]/div[1]")
	public WebElement viewAllApps;
	
	//xpaths of apps store container stored in a list
	@FindBy(xpath="//*[@id=\"divAppstoreContainer\"]/div[1]/div/div/div[2]/div/div")
	public List<WebElement> apps;
	
	
	


	
	//method to click account manager icon
	public void account() {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		js.executeScript("arguments[0].click();", AccountManager);

	}
	
	//method to return usermail logged in
	public String verify() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return usermail.getText();
	}
	
	//method to scroll down to end of the page
	public void scrolldown() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",worldClock);
	}
	
	//method to store places
	public String[] places() {
		String[] p= new String[3];
		p[0]=Bangalore.getText();
		p[1]=London.getText();
		p[2]=NewYork.getText();
		
		return p;
		}
	
	//method to store timings
	public String[] times() {
		String[] t = new String[3];
		t[0]= BangaloreTime.getText()+" "+BangaloreTimeDenotion.getText();
		t[1]= LondonTime.getText()+" "+LondonTimeDenotion.getText();
		t[2]= NewYorkTime.getText()+" "+NewYorkTimeDenotion.getText();

		return t;
	}
	
	//method to store day and dates
	public String[] dates() {
		String[] d = new String[3];
		d[0]=BangaloreDate.getText();
		d[1]=LondonDate.getText();
		d[2]=NewYorkDate.getText();
		
		return d;
	}
	
	//method to store time differences
	public String[] timeDiff() {
		 String[] diff=new String[3];
		 diff[0]=null;
		 diff[1]=TimeDiff1.getText();
		 diff[2]=TimeDiff2.getText();
		 
		 return diff;
	}
	
	//method to scroll up
	public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",All_Apps_Tools);
	}
	//method to click on oneCognizant button
	public void clickOneCognizant() {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", onecognizant);

	}
	//method to get title of window
	public String title() {
		return driver.getTitle();
	}
	
	//method to click on view all apps 
	public void viewAllApps() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();",sidebar);
		js.executeScript("arguments[0].scrollIntoView();",viewAllApps);
		js.executeScript("arguments[0].click();",viewAllApps);	
		
	}
	//method to click on a particular alphabet
	public WebElement alpha(int n) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement ele=driver.findElement(By.xpath("//*[@id=\"divAppstoreContainer\"]/div[1]/div/div/div[2]/div/div["+n+"]"));
		js.executeScript("arguments[0].click();",ele);
		return ele;
	}
	//method to view all apps corresponding to an alphabet and to capture screenshot of all apps
	public void hotApps(int n) throws InterruptedException, IOException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

				WebElement alphabet=driver.findElement(By.xpath("//*[@id=\"divAppstoreContainer\"]/div[1]/div/div/div[2]/div/div["+n+"]"));
				js.executeScript("arguments[0].click();",alphabet);
				
				Thread.sleep(1000);
				List<WebElement> l=driver.findElements(By.xpath("//div[@class='appStoreAppName']"));
			
				if(l.size()<=12) //condition if all apps are less than or equal to 12
				{
					org.openqa.selenium.TakesScreenshot ts=(org.openqa.selenium.TakesScreenshot)driver;
					Thread.sleep(1000);
					File src1=ts.getScreenshotAs(OutputType.FILE);
					File trg1=new File(System.getProperty("user.dir")+"/screenshots/img[1].png");   
					FileUtils.copyFile(src1, trg1);
				}
				// condition if all apps are greater than 12
				else
				{
					int m=12, i=13, j=1;			//i and j are iterators through all apps
					while(m<=l.size())				//m is for checking while condition i.e, comparing all apps size
					{
						TakesScreenshot ts=(TakesScreenshot)driver;
						Thread.sleep(1000);
						File src1=ts.getScreenshotAs(OutputType.FILE);
						File trg1=new File(System.getProperty("user.dir")+"/screenshots/img["+j+"].png");
						FileUtils.copyFile(src1, trg1);
						i+=6;
						if(i<=l.size())
						{
							WebElement ss=driver.findElement(By.xpath("//*[@id=\"div_appFilteredList\"]/div/div["+i+"]/div"));
							js.executeScript("arguments[0].scrollIntoView();",ss);
						}
						j+=1;
						if(l.size()>n)
							n+=6;
						else
							break;
					}
				}
		
		
	}
}
