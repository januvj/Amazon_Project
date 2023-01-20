package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstProduct_AddCart {


	public static WebDriver driver;

	@FindBy(xpath = "//div[@id='centerCol']//child::div[@id='title_feature_div']")
	private WebElement clickableLink;

	@FindBy(xpath = "//div[@id='title_feature_div']/following-sibling::div[9]/child::div[3]/child::div[1]/span[2]")
	private WebElement clickablePdtPrice;

	@FindBy(id = "add-to-cart-button")
	private WebElement addtoCart;

	public FirstProduct_AddCart(WebDriver driver3) {
		this.driver = driver3;
		PageFactory.initElements(driver3, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickableLink() {
		return clickableLink;
	}

	public WebElement getClickablePdtPrice() {
		return clickablePdtPrice;
	}

	public WebElement getAddtoCart() {
		return addtoCart;
	}

}
