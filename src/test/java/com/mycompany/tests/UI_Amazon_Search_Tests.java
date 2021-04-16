package com.mycompany.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mycompany.steps.AmazonSearchSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class UI_Amazon_Search_Tests {
	
	@Managed
	WebDriver driver;
	
	@Steps
	AmazonSearchSteps amazonSearchSteps;
	
	
	@Test
	public void test01SearchAmazon() {
		
		amazonSearchSteps.openAmazonWebapp();
		amazonSearchSteps.enterSearchInputAndClickOnSearch("qa testing for beginners");
		amazonSearchSteps.getFirstItemPriceAndClick();
		amazonSearchSteps.verifyFirstPriceWithProductDetailsPrice();
		amazonSearchSteps.clickOnAddToCart();
		amazonSearchSteps.verifyFirstPriceWithCartPrice();
		
	}

}
