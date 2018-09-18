package com.qa.ahq.nswtripplanner.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.ahq.nswtripplanner.common.NswTripPlannerTestUtils;


public class NswTripPlannerPage {
	
	WebDriver driver = null;
	NswTripPlannerTestUtils util = new NswTripPlannerTestUtils();
	Properties prop;
	
    /*
	 * List of web elements present of the NSW Trip Planner
	 * page will be listed here.
	 */
	@FindBy(id ="search-input-From")
	public WebElement fromStation;
	
	@FindBy(id = "search-input-To")
	public WebElement toStation;
	
	@FindBy(xpath="//*[@ng-repeat='trip in tripResultsVm.trips track by $index']")
	public List<WebElement> resultList;
	
	/*
	 * Methods related to Trip Planner Page.
	 */
	public NswTripPlannerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	/*
	 * Getter and Setter methods to fetch and set the values of the properties 
	 * from the outside the class.
	 */
	
	public WebElement getFromStation() {
		return fromStation;
	}

	public void setFromStation(WebElement fromStation) {
		this.fromStation = fromStation;
	}

	public WebElement getToStation() {
		return toStation;
	}

	public void setToStation(WebElement toStation) {
		this.toStation = toStation;
	}
	
	public List<WebElement> getResultList() {
		return resultList;
	}
	
	public void pressEnterKey(){
		
		prop = util.LoadPropertiesfile();
		util.enterStationName(prop.getProperty("fromStation"),fromStation);
		util.implicitWaitForPageLoad(driver);
		util.enterStationName(prop.getProperty("toStation"),toStation);
		util.explicitWaitForElement(driver);
		toStation.sendKeys(Keys.ENTER);	
	}
}
