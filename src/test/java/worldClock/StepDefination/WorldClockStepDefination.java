package worldClock.StepDefination;

import java.io.IOException;
import java.time.*;
import java.time.format.*;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utils.HelperClass;
import com.utils.excelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import worldClock.PageObjects.WorldClockPage;

public class WorldClockStepDefination {
	public static WorldClockPage W;
	public static WebDriver driver;
	String path= System.getProperty("user.dir")+"\\src\\test\\resources\\Output.xlsx";

	@Given("user navigated Be.cognizant portal home page")
	public void user_navigated_be_cognizant_portal_home_page() {
	    driver=HelperClass.getDriver();
	}

	@When("user scrolls till end of page")
	public void user_scrolls_till_end_of_page() {
		W=new WorldClockPage(driver);
		W.scrolldown();
	}

	@Then("world clock should be displayed")
	public void world_clock_should_be_displayed() {
		W=new WorldClockPage(driver);

	    if(W.worldClock.isDisplayed()) {
	    	System.out.println("The world clock webElement is displayed");
	    }
	    else {
	    	System.out.println("The world clock webelement is not displayed");
	    }
	}

	@When("timezones of Bangalore, London and NewYork are displayed")
	public void timezones_of_bangalore_london_and_new_york_are_displayed() {
		W=new WorldClockPage(driver);

	    Assert.assertTrue(W.Bangalore.isDisplayed());
	    Assert.assertTrue(W.London.isDisplayed());
	    Assert.assertTrue(W.NewYork.isDisplayed());
	    
	}

	
	@Then("tiemzones are verified")
	public void tiemzones_are_verified() throws IOException {
		W=new WorldClockPage(driver);
		String[] places= W.places();
		String[] Time= W.times();
		
		for(int i=0;i<3;i++) {
			excelUtils.setCellData(path,"Sheet1",i+1, 0,places[i]);					//to store places and times in excel
			excelUtils.setCellData(path,"Sheet1",i+1, 1,Time[i]);

		}
		//haspmap for storing places as keys and zone Ids as values respectively
		HashMap<String,String> zones=new HashMap<String,String>();
		zones.put(places[0],"Asia/Kolkata");
		zones.put(places[1],"Europe/London");
		zones.put(places[2],"America/New_York");
		
		ZonedDateTime time1 = ZonedDateTime.now(ZoneId.of(zones.get(places[0])));
        ZonedDateTime time2 = ZonedDateTime.now(ZoneId.of(zones.get(places[1])));
        ZonedDateTime time3 = ZonedDateTime.now(ZoneId.of(zones.get(places[2])));
        
        DateTimeFormatter TIME_FORMATTER=DateTimeFormatter.ofPattern("h:mm a");		//formatter to convert zonedDatetime to string
        
        String timing1 =TIME_FORMATTER.format(time1);
        String timing2 =TIME_FORMATTER.format(time2);
        String timing3 =TIME_FORMATTER.format(time3);
        
        Assert.assertEquals(Time[0].toLowerCase(), timing1.toLowerCase());			//assertions b/w worldclock time and actual time
		Assert.assertEquals(Time[1].toLowerCase(), timing2.toLowerCase());
		Assert.assertEquals(Time[2].toLowerCase(), timing3.toLowerCase());

	    
	}

	@When("Day\\/date of Bangalore, London and NewYork are displayed")
	public void day_date_of_bangalore_london_and_new_york_are_displayed() {
		W=new WorldClockPage(driver);

	    Assert.assertTrue(W.BangaloreDate.isDisplayed());
	    Assert.assertTrue(W.LondonDate.isDisplayed());
	    Assert.assertTrue(W.NewYorkDate.isDisplayed());
	}

	@Then("Day\\/dates are verified")
	public void day_dates_are_verified() throws IOException {
		W=new WorldClockPage(driver);
		String[] places= W.places();
		String[] DayDate=W.dates();
		
		for(int i=0;i<3;i++) {
			excelUtils.setCellData(path,"Sheet1",i+1, 2,DayDate[i]);		//to store dates in excel sheet
		}
		
		//haspmap for storing places as keys and zone Ids as values respectively
		HashMap<String,String> zones=new HashMap<String,String>();
		zones.put(places[0],"Asia/Kolkata");
		zones.put(places[1],"Europe/London");
		zones.put(places[2],"America/New_York");
		
		ZonedDateTime time1 = ZonedDateTime.now(ZoneId.of(zones.get(places[0])));
        ZonedDateTime time2 = ZonedDateTime.now(ZoneId.of(zones.get(places[1])));
        ZonedDateTime time3 = ZonedDateTime.now(ZoneId.of(zones.get(places[2])));

        //formatter to convert zoneddate to string
       DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("EEEE, M/d/yyyy");

       String DayDate1 =CUSTOM_FORMATTER.format(time1);
       String DayDate2 =CUSTOM_FORMATTER.format(time2);
       String DayDate3 =CUSTOM_FORMATTER.format(time3);
       //assertions
       if(DayDate1.contains(DayDate[0])) {
        Assert.assertEquals(DayDate[0], DayDate1);
       }
       if(DayDate2.contains(DayDate[1])) {
		Assert.assertEquals(DayDate[1], DayDate2);
       }
       if(DayDate3.contains(DayDate[2])) {
		Assert.assertEquals(DayDate[2], DayDate3);
       }

		
	}

	@When("time differences for London and NewYork are displayed")
	public void time_differences_for_london_and_new_york_are_displayed() {
		W=new WorldClockPage(driver);
		Assert.assertTrue(W.TimeDiff1.isDisplayed());
		Assert.assertTrue(W.TimeDiff2.isDisplayed());
	    
	}

	@Then("time differneces are compared to Bangalore time")
	public void time_differneces_are_compared_to_bangalore_time() throws IOException {
		W=new WorldClockPage(driver);
		String[] p= W.places();
		String[] Time_diff=W.timeDiff();
		for(int i=0;i<3;i++) {
			excelUtils.setCellData(path,"Sheet1",i+1, 3,Time_diff[i]);			//to store time differnces in excel
		}
		
		HashMap<String,String> zones=new HashMap<String,String>();
		zones.put(p[0],"Asia/Kolkata");
		zones.put(p[1],"Europe/London");
		zones.put(p[2],"America/New_York");
		
		
		LocalDateTime dt = LocalDateTime.now();
		ZonedDateTime fromZonedDateTime = dt.atZone(ZoneId.of(zones.get(p[0])));
		ZonedDateTime toZonedDateTime1 = dt.atZone(ZoneId.of(zones.get(p[1])));
		ZonedDateTime toZonedDateTime2 = dt.atZone(ZoneId.of(zones.get(p[2])));
       
		//duration of time diffences btw zones in duration format
		Duration diff1 = Duration.between(fromZonedDateTime, toZonedDateTime1);
		Duration diff2 = Duration.between(fromZonedDateTime, toZonedDateTime2);
        
		//store the differnences as strings like PT5H30M and PT10H30M 
		String d1=HelperClass.formatDuration(diff1);
		String d2=HelperClass.formatDuration(diff2);
		String s="";
		String s1="";
		if(d1.contains("-")) {
			s=d1.replace("-","")+" behind";
			s1=d2.replace("-","")+" behind";
		}
		else {
			s=d1+" ahead";
			s1=d2+" ahead";
		}
		
		//assertions of time differences

		if(Time_diff[1].contains("-")) {
		Assert.assertEquals(HelperClass.formatDuration(diff1),Time_diff[1]);
		Assert.assertEquals(HelperClass.formatDuration(diff2),Time_diff[2]);
		}
		else {
			Assert.assertEquals(s,Time_diff[1]);
			Assert.assertEquals(s1,Time_diff[2]);
		}
	
	}
}
