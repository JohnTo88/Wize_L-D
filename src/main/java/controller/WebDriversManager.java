package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ulties.TienIch;

public class WebDriversManager {
	/**
	 * This method is to auto-detect browser and auto-create web driver
	 * 
	 * @author hanv
	 * @param BROWSER_NAME chrome ff ie
	 */
	static WebDriver driver;
	protected static boolean ieFlag;
	protected static boolean chromeFlag;
	protected String baseUrl;
	protected Actions action;
	
	public static WebDriver moTrinhDuyet(String BROWSER_NAME) {

		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

		String chromedriver = TienIch.getResources("chromedriver.exe");
		String IEdriver = TienIch.getResources("IEDriverServer.exe");
		String FireFox = TienIch.getResources("geckodriver.exe");
		String Edge = TienIch.getResources("MicrosoftWebDriver.exe");

		if ("chrome".equals(BROWSER_NAME)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches", "--disable-extensions");
			System.setProperty("webdriver.chrome.driver", chromedriver);
			driver = new ChromeDriver(options);
			chromeFlag = true;
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			return driver;
			
			//========  RUN EDGE with VERSION <= Microsoft EdgeHTML 17 ========= 
			/*System.setProperty("webdriver.edge.driver", Edge);
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;*/
			
			// ========  RUN EDGE with VERSION >= Microsoft EdgeHTML 18 ========= 
	
		/*	driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;*/
			
		} 
		
		else if ("ie".equals(BROWSER_NAME)) {
			System.setProperty("webdriver.ie.driver", IEdriver);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(capabilities);
			ieFlag = true;
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;

		} else  {

			// Save the path of the XPI files as per your saved location
			// Pass the XPIs path to the profile
			// profile.setPreference("plugins.hide_infobar_for_missing_plugin",true);
			/*
			 * profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
			 * profile.setPreference("startup.homepage_welcome_url.additional",
			 * "about:blank"); profile.setPreference("dom.max_script_run_time", 0);
			 * DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			 * capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			 */

			/*
			 * File pathToBinary = new
			 * File("C:\\Users\\ha.nguyen-viet\\AppData\\Local\\Mozilla Firefox\\Firefox.exe"
			 * ); FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary); FirefoxProfile
			 * firefoxProfile = new FirefoxProfile(); driver = new FirefoxDriver
			 * (ffBinary,firefoxProfile);
			 */

			/*	*/

			System.setProperty("webdriver.gecko.driver", FireFox);

			File pathToBinary = new File(
					"C:\\\\Users\\\\ha.nguyen-viet\\\\AppData\\\\Local\\\\Mozilla Firefox\\\\Firefox.exe");
			FirefoxOptions options = new FirefoxOptions();

			FirefoxBinary fireFoxbinary = new FirefoxBinary(pathToBinary);
			options.setBinary(fireFoxbinary);

			driver = new FirefoxDriver(options);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}

	}

	/**
	 * This method is to start with a remote web driver using Selenium Grid on 3
	 * chosen nodes:
	 * 
	 * 10.0.3.223 - win7x64 - FF 10.0.3.214 - win8.1x64 - IE 10.0.3.226 - win8x86 -
	 * Chrome
	 * 
	 * @author hanv
	 */
	public void initSeleniumTest(String browserName, String platform, String version)
			throws FileNotFoundException, IOException {

		DesiredCapabilities cap = null;
		// RemoteWebDriver driver = null;

		// Set browser
		switch (browserName) {
		case "firefox":
			cap = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://10.0.3.223:4444/wd/hub"), cap);
			break;
		case "chrome":
			cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://10.0.3.226:4444/wd/hub"), cap);
			break;
		case "internet explorer":
			cap = DesiredCapabilities.internetExplorer();
			driver = new RemoteWebDriver(new URL("http://10.0.3.214:4444/wd/hub"), cap);
			break;
		/*
		 * case "safari": cap = DesiredCapabilities.safari(); driver = new
		 * RemoteWebDriver(new URL("http://10.0.3.214:4444/wd/hub"),cap); break;
		 */
		default:
			System.out.print("The value of parameter 'browserName' might be incorrect or null");
			break;
		}

		// driver.get("http://www.coccoc.com/search#!");

		// Set platform
		cap.setCapability("Platform", platform);

		// Check version
		if (version != null)
			if (!version.equals(""))
				cap.setVersion(version);
	}

	
	/**
	 * This method is to start with whatever browser you want
	 * 
	 * @author hanv
	 * @param DEFAULT_BASEURL String the homepage URL of targeted web application
	 *                        opParams Object optional parameter
	 */
	public void autoDetectBrowser(String DEFAULT_BASEURL) {
		String browser = System.getProperty("browser");
		if ("chrome".equals(browser)) {
			driver = new ChromeDriver();
			chromeFlag = true;
		} else if ("iexplorer".equals(browser)) {
			driver = new InternetExplorerDriver();
			ieFlag = true;
		} else {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("plugins.hide_infobar_for_missing_plugin", true);
			profile.setPreference("dom.max_script_run_time", 0);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);

			driver = new FirefoxDriver();
		}
		baseUrl = System.getProperty("baseUrl");
		if (baseUrl == null)
			baseUrl = DEFAULT_BASEURL;
		action = new Actions(driver);
		new WebDriverWait(driver, 10);
	}


}
