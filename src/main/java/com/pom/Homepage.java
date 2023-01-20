package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	
	public static WebDriver driver;

	@FindBy(id = "searchDropdownBox")
	private WebElement dropdown;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement twosearchtext;

	@FindBy(xpath = "//div[@class='autocomplete-results-container']/child::div")
	private List<WebElement> allsearchedinfo;

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getTwosearchtext() {
		return twosearchtext;
	}

	public List<WebElement> getAllsearchedinfo() {
		return allsearchedinfo;
	}

	public Homepage(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);

	}

}