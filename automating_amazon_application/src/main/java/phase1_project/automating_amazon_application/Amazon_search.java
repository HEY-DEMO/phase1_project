package phase1_project.automating_amazon_application;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class Amazon_search {
	//initiating webdriver
	static WebDriver driver =null;
	public static void main(String []args) throws AWTException, InterruptedException {
		String path = "drivers/msedgedriver.exe";
		System.setProperty("webdriver.edege.driver", path);
		//opening the browser
		driver = new EdgeDriver();
		//Searchin the url
		driver.get("https://www.amazon.in/");
		//Screenshot of loaded webpage
		screenshot("Amazon site.png");


		mobilesearch();

		Amazon_laptop_search.main(args);
		
		Amazon_smartwatch_search.main(args);
		
	}
	private static void mobilesearch() throws  InterruptedException {
		//search for apple product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple");
		driver.findElement(By.id("twotabsearchtextbox")).submit();
		//Screenshot of apple search
		screenshot("apple mobiles.png");
		//storage 256gb
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//*[@id=\"p_n_feature_twenty-nine_browse-bin/81332996031\"]/span/a/span")).click();
		screenshot("apple 256gb.png");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Screenshot of apple category
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("mobile");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).submit();

		//Screenshot of moblies section in amazon
		screenshot("mobiles list.png");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("#p_89\\/Samsung > span > a > span")).click();
		//screenshot of samsung category
		screenshot("samsung mobiles.png");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"low-price\"]")).sendKeys("80000");
		driver.findElement(By.xpath("//*[@id=\"high-price\"]")).sendKeys("130000");
		driver.findElement(By.xpath("//*[@id=\"p_36/price-range\"]/span/form/span[3]/span/input")).click();
		//Screenshot of samsung mobile category
		screenshot("samsung price80k-130k.png");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		//screenshot of samsung s22ultra
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		screenshot("samsung s22 ultra.png");



		Thread.sleep(5000);

		driver.quit();


	}
	private static void screenshot(String scname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(f, new File("Screenshots\\mobiles\\"+scname));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

