package com.sdp;

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
import org.openqa.selenium.support.ui.Select;

import com.amazonmini.reusablemethods.Amazon_baseclass;

import com.pom.Singleton_design_Pattern;

public class Amazon_Sdp extends Amazon_baseclass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		driver = browserlaunch("chrome");
		getUrl("https://www.amazon.in/");

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String selecteitem = "baby";
		Singleton_design_Pattern sdp = new Singleton_design_Pattern(driver);

		sdp.Homepage().getDropdown();

		Select s = new Select(sdp.Homepage().getDropdown());
		List<WebElement> dropdownoptions = s.getOptions();
		for (int i = 0; i < dropdownoptions.size(); i++) {

			WebElement onebyoneoption = dropdownoptions.get(i);
			String eachText = onebyoneoption.getText();

			if (eachText.equalsIgnoreCase(selecteitem)) {

				s.selectByVisibleText(eachText);
			}
		}

		String search = "Soft Toys";
		sdp.Homepage().getTwosearchtext();
		userInput(sdp.Homepage().getTwosearchtext(), search);

		Thread.sleep(3000);

		sdp.Homepage().getAllsearchedinfo();

		for (int i = 1; i <= sdp.Homepage().getAllsearchedinfo().size(); i++) {
			WebElement selectproduct = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div[" + i + "]/div/div[@role='button']")); // reena
																														// xpat

			String eachproducttext = selectproduct.getText();
			if (eachproducttext.equalsIgnoreCase(search)) {
				selectproduct.click();
				break;
			}

		}

		Thread.sleep(3000);

		sdp.Productpage().getFirstproducttitle();

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", sdp.Productpage().getFirstproducttitle());

		String firstproduct1 = sdp.Productpage().getFirstproducttitle().getText();
		System.out.println(firstproduct1);

		Thread.sleep(3000);

		sdp.Productpage().getFirstproductdiscount();

		String discountprice1 = sdp.Productpage().getFirstproductdiscount().getText();
		System.out.println(discountprice1);
		Thread.sleep(3000);

		String parentwindow = driver.getWindowHandle();
		Thread.sleep(3000);

		sdp.Productpage().getFirstproducttitle().click();
		String currenttitle = driver.getTitle();
		Thread.sleep(3000);

		System.out.println(currenttitle);

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());

		for (String nextwindow : windowHandles) {

			if (!(nextwindow.equals(parentwindow))) {

				driver.switchTo().window(nextwindow);

			}
		}
		Thread.sleep(5000);

		sdp.FirstProduct_AddCart().getClickableLink();

		String nextfirstproduct = sdp.FirstProduct_AddCart().getClickableLink().getText();

		if (nextfirstproduct.equalsIgnoreCase(firstproduct1)) {

			System.out.println("link match same");

		}

		else {

			System.out.println("link doesn't match");

		}

		sdp.FirstProduct_AddCart().getClickablePdtPrice();

		String discountprice2 = sdp.FirstProduct_AddCart().getClickablePdtPrice().getText();

		if (discountprice2.equalsIgnoreCase(discountprice1)) {

			System.out.println("Price match same");

		}

		else {

			System.out.println("Price doesn't match");

		}

		sdp.FirstProduct_AddCart().getAddtoCart();

		sdp.FirstProduct_AddCart().getAddtoCart().click();

		sdp.Cart_page().getClickCart();

		sdp.Cart_page().getClickCart().click();


		sdp.Proceed_To_Buy().getPtocart();
		sdp.Proceed_To_Buy().getPtocart().click();

		TakesScreenshot v = (TakesScreenshot) driver;
		File v1 = v.getScreenshotAs(OutputType.FILE);
		File f1 = new File(
				"C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\amazonproceedtobuy.png");
		FileUtils.copyFile(v1, f1);
		driver.close();

		driver.quit();

	}

}
