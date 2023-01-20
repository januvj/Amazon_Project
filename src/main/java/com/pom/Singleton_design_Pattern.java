package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Singleton_design_Pattern {

	public static WebDriver driver;

	private Homepage h;
	private Productpage p;
	private FirstProduct_AddCart f;
	private Cart_page c;
	private Proceed_To_Buy pb;

	public Singleton_design_Pattern(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);

	}

	public Homepage Homepage() {
		if (h == null) {
			h = new Homepage(driver);

		}
		return h;

	}

	public Productpage Productpage() {
		if (p == null) {
			p = new Productpage(driver);

		}
		return p;
	}

	public FirstProduct_AddCart FirstProduct_AddCart() {
		if (f == null) {
			f = new FirstProduct_AddCart(driver);
		}
		return f;
	}

	public Cart_page Cart_page() {
		if (c == null) {
			c = new Cart_page(driver);

		}
		return c;
	}

	public Proceed_To_Buy Proceed_To_Buy() {
		if (pb == null) {
			pb = new Proceed_To_Buy(driver);
		}
		return pb;
	}

}
