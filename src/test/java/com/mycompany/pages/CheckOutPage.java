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

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id="nav-cart-text-container")
	WebElement cartIcon;
	
	@FindBy(css="div[class='sc-list-item-content'] p")
	WebElement cartProductPrice;
	
	
	public void clickOnCartIcon() {
		element(cartIcon).click();
		waitABit(1000);
	}
	
	public String returnPriceFromCart() {
		clickOnCartIcon();
		System.out.println(cartProductPrice.getText());
		return cartProductPrice.getText();
	}
	
}
