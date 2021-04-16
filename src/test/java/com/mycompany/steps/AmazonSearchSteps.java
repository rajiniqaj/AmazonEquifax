package com.mycompany.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mycompany.pages.AmazaonHomePage;
import com.mycompany.pages.CheckOutPage;
import com.mycompany.pages.ProductDetailsPage;
import com.mycompany.pages.SearchResultsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AmazonSearchSteps extends ScenarioSteps {

	private AmazaonHomePage homePage;
	private SearchResultsPage searchresultsPage;
	private ProductDetailsPage productDetailsPage;
	private CheckOutPage checkoutPage;

	WebDriver driver;

	String firstPrice;

	// URL can be configured in properties file
	@Step("Open amazon web application")
	public void openAmazonWebapp() {
		homePage.openUrl("https://www.amazon.com/");
		getDriver().manage().window().maximize();
	}

	@Step("Enter the input {0} for search and click on search button")
	public void enterSearchInputAndClickOnSearch(String string) {
		homePage.enterSearchInput(string);
		homePage.clickSearchButton();
	}

	@Step("Get first Item price and click on item")
	public void getFirstItemPriceAndClick() {
		firstPrice = searchresultsPage.clickOnFirstItemInSearchResultsAndReturnPrice();
	}

	@Step("Verify product details buy price with first price from search results")
	public void verifyFirstPriceWithProductDetailsPrice() {
		System.out.println("Verify test===>"+firstPrice);
		Assert.assertTrue("The product Details Price is NOT equal to search results price",
				productDetailsPage.returnNewBuyPrice().equals(firstPrice));
	}

	@Step("Click on add to cart")
	public void clickOnAddToCart() {
		productDetailsPage.clickOnAddToCart();
	}

	@Step("Verify cart price with serach item first price")
	public void verifyFirstPriceWithCartPrice() {
		Assert.assertTrue("The cart Price is NOT equal to search results price",
				checkoutPage.returnPriceFromCart().equals(firstPrice));
	}
}
