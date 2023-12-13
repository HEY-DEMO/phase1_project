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

public class Amazon_laptop_search {
	//initiating webdriver
		static WebDriver driver =null;
		public static void main(String []args) throws InterruptedException {
			String path = "drivers/msedgedriver.exe";
			System.setProperty("webdriver.edege.driver", path);
			//opening the browser
			driver = new EdgeDriver();
			//Searchin the url
			driver.get("https://www.amazon.in/");
			laptopsearch();
		}
		private static void laptopsearch() throws  InterruptedException {
			//search for laptops 
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
			driver.findElement(By.id("twotabsearchtextbox")).submit();
			//Screenshot of laptops search
			screenshot("laptops list.png");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.findElement(By.cssSelector("#p_n_feature_twenty-three_browse-bin\\/27387161031 > span > a > span")).click();
			screenshot("amd laptops.png");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.cssSelector("#p_n_feature_twenty-three_browse-bin\\/27387161031 > span > a > span")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			//Screenshot of apple category
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell");
			driver.findElement(By.id("twotabsearchtextbox")).submit();

			//Screenshot of moblies section in amazon
			screenshot("Dell laptop list.png");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//screenshot of oneplus category

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//*[@id=\"low-price\"]")).sendKeys("80000");
			driver.findElement(By.xpath("//*[@id=\"high-price\"]")).sendKeys("130000");
			driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]/span/input")).click();
			//Screenshot of samsung mobile category
			screenshot("dell price80k-130k.png");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
			//screenshot of first result of dell laptop
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			screenshot("dell laptop.png");


			Thread.sleep(5000);

			driver.quit();


		}
		private static void screenshot(String scname) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File f = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(f, new File("Screenshots\\laptops\\"+scname));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
