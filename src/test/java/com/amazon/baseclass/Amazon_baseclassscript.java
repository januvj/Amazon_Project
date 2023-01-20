package com.amazon.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.amazonmini.reusablemethods.Amazon_baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_baseclassscript extends Amazon_baseclass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		driver = browserlaunch("chrome");
		getUrl("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String selecteitem = "baby";
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

		List<WebElement> dropdownoptions = getOptions(dropDown);

		for (int i = 0; i < dropdownoptions.size(); i++) {

			WebElement onebyoneoption = dropdownoptions.get(i);
			String eachText = getText(onebyoneoption);
			if (eachText.equalsIgnoreCase(selecteitem)) {
				dropDownSelect(dropDown, "text", eachText);


			}
		}

		String search = "Soft Toys";
		WebElement twosearchtext = driver.findElement(By.id("twotabsearchtextbox"));
		// twosearchtext.sendKeys(search);
		userInput(twosearchtext, search);
		sleep();
		List<WebElement> allsearchedinfo = driver
				.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		for (int i = 1; i <= allsearchedinfo.size(); i++) {
			WebElement selectproduct = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']")); // reena
																														// xpath

			// WebElement selectproduct =
			// driver.findElement(By.xpath("//div/child::div[2]/child::div[@class='nav-issFlyout
			// nav-flyout']/child::div/child::div"));

			String eachproducttext = getText(selectproduct); // selectproduct.getText();
			if (eachproducttext.equalsIgnoreCase(search)) {
				selectproduct.click();
				break;
			}

		}

		Thread.sleep(3000);
		WebElement firstproducttitle = driver
				.findElement(By.xpath("//div/child::span[text()='RESULTS']/following::img[@class='s-image']"
						+ "/following::div/child::div[contains(@class,'a-section a-spacing-none')]/child::h2[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", firstproducttitle);

		String firstproduct1 = getText(firstproducttitle); // firstproducttitle.getText();
		System.out.println(firstproduct1);

//		WebElement firstproductdiscount = driver.findElement(By.xpath("//div/child::span[text()='RESULTS']/following::img[@class='s-image']/following::div/child::div[contains(@class,'a-section a-spacing-none')]/"
//				+ "child::h2[1]/following::span[@class='a-price']/child::span[1]"));

		sleep();
		WebElement firstproductdiscount = driver.findElement(By.xpath("//div/child::span[text()='RESULTS']/"
				+ "following::img[@class='s-image']/following::div/child::"
				+ "div[contains(@class,'a-section a-spacing-none')]/child::h2[1]/following::span[1][@class='a-price']"));

		String discountprice1 = getText(firstproductdiscount); // firstproductdiscount.getText();
		System.out.println(discountprice1);
		Thread.sleep(3000);

		String parentwindow = singleWindow(); // driver.getWindowHandle();
		Thread.sleep(3000);

		// firstproductdiscount.click();
		clickOnElement(firstproductdiscount);
		String currenttitle = getTitle(); // driver.getTitle();
		Thread.sleep(3000);

		System.out.println(currenttitle);

		Set<String> windowHandles = multipleWindow(); // driver.getWindowHandles();
		System.out.println(windowHandles.size());

		for (String nextwindow : windowHandles) {

			if (!(nextwindow.equals(parentwindow))) {

				driver.switchTo().window(nextwindow);

			}
		}
		sleep();
		WebElement clickableLink = driver
				.findElement(By.xpath("//div[@id='centerCol']//child::div[@id='title_feature_div']"));

		String nextfirstproduct = getText(clickableLink); // clickableLink.getText();

		if (nextfirstproduct.equalsIgnoreCase(firstproduct1)) {

			System.out.println("link match same");

		}

		else {

			System.out.println("link doesn't match");

		}

		WebElement clickablePdtPrice = driver.findElement

		(By.xpath(
				"//div[@id='centerCol']//child::div[@id='title_feature_div']/following::div/following::div[@id='corePriceDisplay_desktop_feature_div']/child::div/span/span[@class='a-offscreen']"));

		String discountprice2 = getText(clickablePdtPrice); // clickablePdtPrice.getText();

		if (discountprice2.equalsIgnoreCase(discountprice1)) {

			System.out.println("Price match same");

		}

		else {

			System.out.println("Price doesn't match");

		}

		WebElement addtoCart = driver.findElement(By.id("add-to-cart-button"));
		clickOnElement(addtoCart);

		WebElement clickCart = driver.findElement(By.id("nav-cart-count"));
		clickOnElement(clickCart);

		WebElement pToCart = driver.findElement(By.name("proceedToRetailCheckout"));
		clickOnElement(pToCart);

		TakesScreenshot v = (TakesScreenshot) driver;
		File v1 = v.getScreenshotAs(OutputType.FILE);
		File f1 = new File(
				"C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\amazonproceedtobuy.png");
		FileUtils.copyFile(v1, f1);
		close();

		quit();
	}

}
