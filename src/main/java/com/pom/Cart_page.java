package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_page {

	public static WebDriver driver;

	@FindBy(id = "nav-cart-count")
	private WebElement clickCart;

	public WebElement getClickCart() {
		return clickCart;
	}

	

	public Cart_page(WebDriver driver4) {
		this.driver = driver4;
		PageFactory.initElements(driver4, this);	}

	

}
