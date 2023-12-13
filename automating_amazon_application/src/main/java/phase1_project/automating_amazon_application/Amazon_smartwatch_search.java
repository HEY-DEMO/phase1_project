package phase1_project.automating_amazon_application;

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

public class Amazon_smartwatch_search {
	//initiating webdriver
		static WebDriver driver =null;
		public static void main(String []args) throws InterruptedException {
			String path = "drivers/msedgedriver.exe";
			System.setProperty("webdriver.edege.driver", path);
			//opening the browser
			driver = new EdgeDriver();
			//Searchin the url
			driver.get("https://www.amazon.in/");
			smartwatchsearch();
		}
		private static void smartwatchsearch() throws InterruptedException {
			//search for smart watches
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart watch");
			driver.findElement(By.id("twotabsearchtextbox")).submit();
			//Screenshot of smart watches
			screenshot("smart watches.png");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.findElement(By.cssSelector("#p_89\\/Noise > span > a > span")).click();
			//screenshot of noise smartwatches list
			screenshot("noise smartwatch list.png");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div[3]/div[1]/h2/a/span")).click();
			//screenshot of first noise product
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			screenshot("noise smartwatch.png");


			Thread.sleep(5000);

			driver.quit();


		}
		private static void screenshot(String scname) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File f = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(f, new File("Screenshots\\smartwatches\\"+scname));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
