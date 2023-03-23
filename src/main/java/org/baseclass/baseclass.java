package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static WebDriver driver;

	

//	public static WebDriver chromeBrowser() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		return driver;
//	}
//
//	public static WebDriver edgeBrowse() {
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
//		return driver;
//	}

	// webdriver
	public static void urllanch(String s) {
		driver.get(s);
	}

	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

	public static void getcurrenturl() {
		driver.getCurrentUrl();
	}

	public static void title() {
		driver.getTitle();
	}
	//maximize
	
	public static void maximize() {
driver.manage().window().maximize();
	}
	//implicity wait
	public static void implicitywait() {
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	
	// webelement

	public static void sendkeys(WebElement e, String data) {
		e.sendKeys(data);
	}

	public static void webelementclick(WebElement e) {
		e.click();

	}

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}

	public static String getAttributetext(WebElement e) {
		String attribute = e.getAttribute("innertext");
		return attribute;
	}

	// action
	public static void movetoElement() {
		Actions a = new Actions(driver);
		Actions dragAndDrop = a.dragAndDrop(null, null);

	}

	public static void doubleClick() {
		Actions a = new Actions(driver);
		Actions doubleClick = a.doubleClick();
	}

	public static void Contextclick() {
		Actions a = new Actions(driver);
		a.contextClick();
	}

	public static void Clickandhold() {
		Actions a = new Actions(driver);
		a.clickAndHold();
	}

	public static void release() {
		Actions a = new Actions(driver);
		a.release();
	}

	public static void draganddrop() {
		Actions a = new Actions(driver);
		a.dragAndDrop(null, null);

	}

	public static void perform() {
		Actions a = new Actions(driver);

		a.perform();
	}

	// select
	public static void selectbyindex(WebElement dropdown,int a) {
		Select s = new Select(dropdown);
		s.deselectByIndex(a);
	}

	public static void selectbyvalue(WebElement dropdown, String a) {
		

		Select s = new Select(dropdown);
		s.selectByValue(a);
	}

	public static void selectByVisibleText(WebElement e, String Text) {
		Select s = new Select(e);
		s.selectByVisibleText(Text);
	}

	public static void getfirstselectedoption(WebElement dropdown) {
		Select s = new Select(dropdown);
		WebElement a = s.getFirstSelectedOption();
	}

	public static List getallselectedoption(WebElement dropdown) {

		Select s = new Select(dropdown);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public static boolean ismultiple(WebElement dropdown) {
		Select s = new Select(dropdown);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	public static void deselectbyvalue(WebElement dropdown, String d) {

		Select s = new Select(dropdown);
		s.deselectByValue(d);
	}

	public static void deselectbyindex(WebElement dropdown) {
		Select s = new Select(dropdown);
		s.deselectByIndex(0);
	}

	public static void deselectvisibletext(WebElement dropdown, String f) {
		Select s = new Select(dropdown);
		s.deselectByVisibleText(f);
	}

	public static void deselectall(WebElement dropdown) {
		Select s = new Select(dropdown);
		s.deselectAll();
	}

//Alert
//accept	
	public static Alert accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
		return a;
	}

	public static Alert dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		return a;

	}

	public static Alert gettext() {
		Alert a = driver.switchTo().alert();
		a.getText();
		return a;
	}

	public static Alert sendkeys() {
		Alert a = driver.switchTo().alert();
		a.sendKeys(null);
		;
		return a;
	}

//Robot
	public static void controlA() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	public static void controlC() throws AWTException {
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	private void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	private void tab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

//navigation
	public static void navigationback() {
		driver.navigate().back();

	}

	public static void navigationrefresh() {
		driver.navigate().refresh();

	}

	public static void navigationto(String value) {
		driver.navigate().to(value);
	}

	public static void navigationforward() {
		driver.navigate().forward();
		;

	}

	// screenshot
	public static void Getscreenshoot(String s) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f3 = tk.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Admin\\Desktop\\oooo\\Mevenproject\\mvn screenshot\\" + s + ".png");
		FileUtils.copyFile(f3, f);
	}

	// getscreenshot
	public static void getscreenshot(WebElement e, String s) throws IOException {
		File sc = e.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Admin\\Desktop\\oooo\\Mevenproject\\mvn screenshot\\" + s + ".png");
		FileUtils.copyFile(sc, d);
	}

	// javascriptexecutor
	public static void executescript(WebElement e, String s) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('s' " + s + ",)", e);

	}

	public static void javascriptExecutorclick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
	}

	public static void javascriptExecutorgetattribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" return arguments[0].getAttribute('value')", e);
	}

//frame
	public static WebDriver framesindex() {
		WebDriver frame = driver.switchTo().frame(0);
		return frame;
	}

	public static WebDriver framesid(String s) {
		WebDriver frame1 = driver.switchTo().frame(s);
		return frame1;

	}

	public static WebDriver framename(String d) {
		WebDriver frame2 = driver.switchTo().frame(d);
		return frame2;
	}

	public static WebDriver frameElement(WebElement e) {
		WebDriver frame3 = driver.switchTo().frame(e);
		return frame3;
	}

//windows handling
//	public static String getwindowhandle() {
//		String windowHandle = driver.getWindowHandle();
//		return windowHandle;
//	}
//
//	public static Set getwindowhandles() {
//		Set<String> windowHandles = driver.getWindowHandles();
//		return windowHandles;
//	}

public static WebDriver browserlanch(String browsername) {
if(	browsername.equalsIgnoreCase("chrome")){
	WebDriverManager.chromedriver().setup();
	 driver =new ChromeDriver();	
}
else if (browsername.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	 driver =new EdgeDriver();
}
return driver;
//}
//	public static WebDriver browserlanch(String browsername) {
//		switch (browsername) {
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//
//			driver = new EdgeDriver();
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//
//			driver = new FirefoxDriver();
//
//		}
//		return driver;
//
//	//}

}}
