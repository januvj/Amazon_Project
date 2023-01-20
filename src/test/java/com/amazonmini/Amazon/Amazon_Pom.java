package com.amazonmini.Amazon;

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
import com.pom.Cart_page;
import com.pom.FirstProduct_AddCart;
import com.pom.Homepage;
import com.pom.Proceed_To_Buy;
import com.pom.Productpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Pom extends Amazon_baseclass {

	 public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		driver = browserlaunch("chrome");
		getUrl("https://www.amazon.in/");

		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String selecteitem = "baby";
	Homepage h = new Homepage(driver);

		h.getDropdown();

		Select s = new Select(h.getDropdown());
		List<WebElement> dropdownoptions = s.getOptions();
		for (int i = 0; i < dropdownoptions.size(); i++) {

			WebElement onebyoneoption = dropdownoptions.get(i);
			String eachText = onebyoneoption.getText();

			if (eachText.equalsIgnoreCase(selecteitem)) {

				s.selectByVisibleText(eachText);
			}
		}

		String search = "Soft Toys";
		h.getTwosearchtext();
		userInput(h.getTwosearchtext(), search);

		Thread.sleep(3000);

		h.getAllsearchedinfo();

		for (int i = 1; i <= h.getAllsearchedinfo().size(); i++) {
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

	Productpage p = new Productpage(driver);

		p.getFirstproducttitle();

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", p.getFirstproducttitle());

		String firstproduct1 = p.getFirstproducttitle().getText();
		System.out.println(firstproduct1);


		Thread.sleep(3000);

		p.getFirstproductdiscount();

		String discountprice1 = p.getFirstproductdiscount().getText();
		System.out.println(discountprice1);
		Thread.sleep(3000);

		String parentwindow = driver.getWindowHandle();
		Thread.sleep(3000);



		p.getFirstproducttitle().click();
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
		FirstProduct_AddCart f = new FirstProduct_AddCart(driver);

		f.getClickableLink();

		String nextfirstproduct = f.getClickableLink().getText();

		if (nextfirstproduct.equalsIgnoreCase(firstproduct1)) {

			System.out.println("link match same");

		}

		else {

			System.out.println("link doesn't match");

		}


		f.getClickablePdtPrice();

		String discountprice2 = f.getClickablePdtPrice().getText();

		if (discountprice2.equalsIgnoreCase(discountprice1)) {

			System.out.println("Price match same");

		}

		else {

			System.out.println("Price doesn't match");

		}

		f.getAddtoCart();

		f.getAddtoCart().click();

		Cart_page c = new Cart_page(driver);

		c.getClickCart();

		c.getClickCart().click();

		Proceed_To_Buy pb = new Proceed_To_Buy(driver);

		pb.getPtocart();
		pb.getPtocart().click();

		TakesScreenshot v = (TakesScreenshot) driver;
		File v1 = v.getScreenshotAs(OutputType.FILE);
		File f1 = new File(
				"C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\amazonproceedtobuy.png");
		FileUtils.copyFile(v1, f1);
		driver.close();

		driver.quit();

	}

}
































//		WebElement nextpagettitle = driver
//				.findElement(By.xpath("//div/child::div[@id='centerCol']/child::div[@id=\"title_feature_div']"));
//		String title3 = nextpagettitle.getText();
//		System.out.println(title3);
//		
//		if (title3.equalsIgnoreCase(title2)) {
//			System.out.println("titles are matched");
//		}
//
//	//	WebElement discountprice2 = driver.findElement(By.xpath(
//			//	"//div[@id='centerCol']//child::div[@id='title_feature_div']/following::div/following::div[@id='corePriceDisplay_desktop_feature_div']/child::div/span/span[@class='a-offscreen];"));
//		WebElement nextpagediscount = driver.findElement(By.xpath("//div/child::h1/following::div[@class='a-section a-spacing-none aok-align-center']/child::span/child::span[@class='a-offscreen']"));
//		String discounttext = nextpagediscount.getText();
//		System.out.println(discounttext);
//
//		
//		Thread.sleep(2000);
//		if (discounttext.equalsIgnoreCase(discountprice1)) {
//			System.out.println("discountprices are equal");
//		}
//
////		WebElement addToCart = driver.findElement(
////				By.xpath("//div[@id='quantityLayoutLow_feature_div']/following::div[@id='addToCart_feature_div']"));
//		WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
//		
//		addToCart.click();
//		Thread.sleep(3000);
//
//		WebElement proceedtobuy = driver.findElement(By.name("proceedToRetailCheckout"));
//		proceedtobuy.click();
//
//		Thread.sleep(3000);
//
//		TakesScreenshot v = (TakesScreenshot) driver;
//		File v1 = v.getScreenshotAs(OutputType.FILE);
//		File f1 = new File(
//				"C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\amazonproceedtobuy.png");
//		FileUtils.copyFile(v1, f1);
//
//		driver.quit();
//	}
//
//}
