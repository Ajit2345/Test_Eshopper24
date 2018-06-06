package base_test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.data_resource.DataSource;
import com.google.common.io.Files;
import com.read_data_from_excel.ReadDataFromExcelSheet;

import loggerHelper.LoggerHelper;
import util.ResourceHelper;

public class TestBase {
	
	protected WebDriver driver;
//	ResourceHelper resourceHelper = new ResourceHelper();
	Logger log = LoggerHelper.getLogger(TestBase.class);
	
	/**
	 * This method will initiate the Webdriver
	 * @param browser
	 */
	public void getBrowser( String browser){
//		System.out.println(browser);
		log.info("browser is: "+ browser);
		if(System.getProperty("os.name").contains("Window")){ 
			System.out.println(" my systemis: "+System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.firefox.driver", ResourceHelper.getResourcePath("\\drivers\\geckodriver.exe"));
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\drivers\\chromedriver.exe"));				
				driver = new ChromeDriver();
			}
		}else if(System.getProperty("os.name").contains("Mac")){
			System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.firefox.driver", ResourceHelper.getResourcePath("\\drivers\\geckodriver"));
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\drivers\\chromedriver"));
				driver = new ChromeDriver();
			}
		}		
	}
	
	
	/**
	 * This method will give excel data in 2D array based on sheet name
	 * @param path
	 * @param sheetName
	 * @return
	 */
	public String[][] getExcelData(String excelName, String sheetName){	
		String excelLocation = ResourceHelper.getResourcePath("\\testData\\excel\\"+ excelName);		
		return ReadDataFromExcelSheet.readExcelFiles(excelLocation, sheetName);		
	}
	/**
	 * 
	 * This method will update result in excel sheet
	 * @param path
	 * @param sheetName
	 * @param testCaseName
	 * @param testStatus
	 */
	public  void updateResult(String path, String sheetName, String testCaseName, String testStatus){
		ReadDataFromExcelSheet.updateResult(path, sheetName, testCaseName, testStatus);	
	}	
	/**
	 * This method will take a screenshot
	 * @param imageName
	 */
	public void takeScreenShot(String imageName){
	
		try {
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(ResourceHelper.getResourcePath("\\screenshot\\"+imageName+".png"));
			Files.copy(sourceFile, destinationFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String getData(String name){
		log.info("inside getData("+name+")");
//		return DataSource.getBrowserType();
		return DataSource.OR.getProperty(name);
		
	}
	
	@BeforeTest
	public void launchBrowser(){
		getBrowser(getData("browserType"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(DataSource.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(DataSource.getPageLoadTime(), TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeBrowser(){
		endBrowser();
	}
	
	public void getApplicationURL(String url){
		log.info("url is: "+url);
		driver.get(url);
	}
	
	public void endBrowser(){
		log.info("Browser is closing....");
		driver.quit();
		log.info("Browser is closed.");
		}


}
