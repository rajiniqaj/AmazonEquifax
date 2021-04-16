package com.mycompany.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css="a[class='a-link-normal a-text-normal']")
	List<WebElement> searchResultsList;
	
	@FindBy(css="span[class='a-price-whole']")
	List<WebElement> pricesWhole;
	@FindBy(css="span[class='a-price-decimal']")
	List<WebElement> pricesDecimal;
	@FindBy(css="span[class='a-price-fraction']")
	List<WebElement> pricesFraction;

	public String clickOnFirstItemInSearchResultsAndReturnPrice() {
		waitForAngularRequestsToFinish();
		waitUntilElementExists(pricesWhole,60);
		String currentPrice="$"+pricesWhole.get(0).getText() +"."
				+pricesFraction.get(0).getText();
		System.out.println("First Price: "+currentPrice);
		searchResultsList.get(0).click();
		return currentPrice;
	}
	}