package com.qa.ahq.nswtripplanner.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.ahq.nswtripplanner.common.NswTripPlannerTestUtils;
import com.qa.ahq.nswtripplanner.pages.NswTripPlannerPage;

public class NswTripPlannerTest extends NswTripPlannerTestUtils{

	public WebDriver driver;
	
	NswTripPlannerPage nswTripPlannerPage;
	
	@Test
	public void validateListOfTripReturned(){
		driver=getDriver();
		nswTripPlannerPage = new NswTripPlannerPage(driver);
		nswTripPlannerPage.pressEnterKey();
		Assert.assertFalse(nswTripPlannerPage.getResultList().isEmpty());	
	}
	
			
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
}
