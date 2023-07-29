package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoubleClickPage {

    public DoubleClickPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "demo")
    public WebElement textBeforeClick;

    @FindBy(xpath = "//p[@style='color: red;']")
    public WebElement textAfterClick;

    @FindBy(xpath = "//iframe[@id='iframeResult']")
    public WebElement iframe;



}
