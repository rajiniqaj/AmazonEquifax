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

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id="newBuyBoxPrice")
	WebElement newBuyPrice;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCart;
	
	
	public String returnNewBuyPrice() {
		element(newBuyPrice).waitUntilVisible();
		System.out.println("New Buy Price: "+newBuyPrice.getText());
		return newBuyPrice.getText();

	}
	
	public void clickOnAddToCart() {
		element(addToCart).click();
		waitABit(1000);
	}
	
}
