package com.mycompany.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.parser.Element;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Write all the common methods in this base page class
public class BasePage extends PageObject {

    public BasePage(WebDriver driver){
        super(driver);
    }

    public WebElement waitUntilElementExists(WebElement element, int waitSeconds){
        getDriver().manage().timeouts().implicitlyWait(500L, TimeUnit.MILLISECONDS);
        for(int i=0; i<waitSeconds*2;)
            try {
                return element;
            } catch (Exception e){
                i++;
            }
        Assert.fail(String.format("the searched element '%s' NOT found after %d seconds!", new Object[] {element.getText(), Integer.valueOf(waitSeconds)}));
    return element;
    }

    public List<WebElement> waitUntilElementExists(List<WebElement> element, int waitSeconds){
        getDriver().manage().timeouts().implicitlyWait(500L, TimeUnit.MILLISECONDS);
        for(int i=0; i<waitSeconds*2;)
            try {
                return element;
            } catch (Exception e){
                i++;
            }
        //Assert.fail(String.format("the searched element '%s' NOT found after %d seconds!", new Object[] {element.getText(), Integer.valueOf(waitSeconds)}));
        return element;
    }
}
