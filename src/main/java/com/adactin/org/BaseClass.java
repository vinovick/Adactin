package com.adactin.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getDriver(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + ("\\Driver\\chromedriver.exe"));
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("egde")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + ("\\Driver\\Edgedriver.exe"));
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + ("\\Driver\\geckodriver.exe"));
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String url) {
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void currentUrl() {
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void forward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void backward() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void refresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void quite() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getTitle() {
		try {
			driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enabled(WebElement element) {
		try {
			System.out.println(element.isEnabled());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void displayed(WebElement element) {
		try {
			System.out.println(element.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selected(WebElement element) {
		try {
			System.out.println(element.isSelected());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void screenshot(String path) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File destinateFile = new File(path);
			FileUtils.copyFileToDirectory(sourceFile, destinateFile);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void selection(WebElement element, String Option, String value) {
		Select sc = new Select(element);

		try {
			if (Option.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(value);
				sc.selectByIndex(parseInt);
			} else if (Option.equalsIgnoreCase("byValue")) {
				sc.selectByValue(value);
			} else if (Option.equalsIgnoreCase("byVisibleText")) {
				sc.selectByVisibleText(value);
			} else {
				System.out.println("Invalid option");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void inputValueElement(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void confirmAlert(String ok, String cancel) {
		try {
			if (ok.equalsIgnoreCase("ok")) {
				driver.switchTo().alert().accept();

			} else if (cancel.equalsIgnoreCase("cancel")) {
				driver.switchTo().alert().dismiss();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void promptAlert(String ok, String value, String cancel) {
		try {
			if (ok.equalsIgnoreCase("ok")) {
				driver.switchTo().alert().sendKeys(value);
				driver.switchTo().alert().accept();

			} else if (cancel.equalsIgnoreCase("cancel")) {
				driver.switchTo().alert().sendKeys(value);
				driver.switchTo().alert().accept();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void actionMethod(WebElement Element, String Options) {
		Actions ac = new Actions(driver);
		try {
			if (Options.equalsIgnoreCase("moveToElement")) {
				ac.moveToElement(Element).build().perform();
			} else if (Options.equalsIgnoreCase("contextClick")) {
				ac.contextClick(Element).build().perform();
			} else if (Options.equalsIgnoreCase("doubleClick")) {
				ac.doubleClick(Element).build().perform();
			} else {
				System.out.println("Invalid Syntax");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void drogDrop(WebElement Element, WebElement Element1) {
		try {
			Actions ad = new Actions(driver);
			ad.dragAndDrop(Element, Element1).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void robotClass() throws AWTException {
		Robot rb = new Robot();
		try {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void pageUp(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pageDown(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void frameMethod(String option, String value, WebElement element) {
		try {
			if (option.equalsIgnoreCase("byIndex")) {
				int index = Integer.parseInt(value);
				driver.switchTo().frame(index);
			} else if (option.equalsIgnoreCase("byElement")) {
				driver.switchTo().frame(element);

			} else if (option.equalsIgnoreCase("byString")) {
				driver.switchTo().frame(value);
			} else {
				System.out.println("Invalid selection");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void elementClear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void windowHandles(String Path) {
		try {
			Set<String> all_Id = driver.getWindowHandles();

			for (String st : all_Id) {
				String title = driver.switchTo().window(st).getTitle();
				System.out.println(title);
			}

			String actualTitle = Path;
			for (String st : all_Id) {
				if (driver.switchTo().window(st).getTitle().equals(actualTitle)) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void explicitWait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
