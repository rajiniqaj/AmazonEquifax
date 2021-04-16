package com.mycompany.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazaonHomePage extends BasePage {

    public AmazaonHomePage(WebDriver driver) {
        super(driver);
    }

    //  use the different locators in prioriry id>name>tags>css>xpath
    @FindBy(id="twotabsearchtextbox")
    WebElement searchInput;

    @FindBy(id="nav-search-submit-button")
    WebElement searchButton;

// Add all elements on Main page here as a page Objects

    public void enterSearchInput(String input){
        searchInput.clear();
        searchInput.sendKeys(input);
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}
