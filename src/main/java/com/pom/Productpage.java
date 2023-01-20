package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	public static WebDriver driver;


	@FindBy(xpath = "//span[text()='RESULTS']//following::div[@class='sg-col-inner'][1]//descendant::h2//a")
	private WebElement firstproducttitle;

	@FindBy(xpath="//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']")
	private WebElement firstproductdiscount;

	

	public Productpage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getFirstproducttitle() {
		return firstproducttitle;
	}

	public WebElement getFirstproductdiscount() {
		return firstproductdiscount;
	}

}
