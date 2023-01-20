package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Proceed_To_Buy {

	public static WebDriver driver;


	@FindBy(name = "proceedToRetailCheckout")
	private WebElement ptocart;

	public Proceed_To_Buy(WebDriver driver5) {
		this.driver = driver5;
		PageFactory.initElements(driver5, this);

	}

	public WebElement getPtocart() {
		return ptocart;
	}
}
