package org.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
     public static WebDriver chromeBrowser() {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
		 return driver;
     }
     
     public static WebDriver edgeBrowser() {
    	 WebDriverManager.edgedriver().setup();
    	 WebDriver driver = new EdgeDriver();
		return driver;	
	}
     
     public static WebDriver firefoxBrowser() {
    	 WebDriverManager.firefoxdriver().setup();
    	 WebDriver driver = new FirefoxDriver();
		return driver;
	}
     
     public static WebDriver launchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
	    	 driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
	    	 driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
	    	 driver = new EdgeDriver();
		}
		return driver;
	}
     
     public static WebDriver launchBrowserSwitch(String browsername) {
    	 switch(browsername) {
    	 case "chrome" :
    		 WebDriverManager.chromedriver().setup();
	    	 driver = new ChromeDriver();
    	 case "firefox" :
    		 WebDriverManager.firefoxdriver().setup();
	    	 driver = new FirefoxDriver();
    	 case "edge" :
    		 WebDriverManager.edgedriver().setup();
	    	 driver = new EdgeDriver();
    	 }
		return driver;
			}
     
     public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
     
     public static void implicitlyWait(int t) {
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	}
     
     public static void staticWait(int t) throws InterruptedException {
		Thread.sleep(t);
	}
     
     public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
     
     public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
     
     public static void quit() {
		driver.quit();
    }
     
     public static void clear(WebElement e) {
	    e.clear(); 
	}
     
     public static void click(WebElement e) {
    	e.click();
	}
     
     public static void sendKeys(WebElement e, String a) {
		e.sendKeys(a);
	}
     
     public static String getText(WebElement e) {
		String text = e.getText();
		System.out.println(text);
		return text;
		
	}
     
     public static String getAttributeValue(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
     
     public static String getAttributeInnerText(WebElement e) {
		String attribute = e.getAttribute("innerText");
		return attribute;
	}
     
     public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}
     
     public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
     
     public static void doubleClick(WebElement e) {
	   Actions a = new Actions(driver);
	   a.doubleClick(e).perform();
	}
     
     public static void contextClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}
     
     public static void clickAction(WebElement e) {
		Actions a = new Actions(driver);
		a.click(e).perform();
	}
     
     public static void clickAndHold(WebElement e) {
		Actions a = new Actions(driver);
		a.clickAndHold(e).perform();
	}
     
     public static void keyDownEnter() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER);
	}
     
     public static void keyUpEnter() {
		Actions a = new Actions(driver);
		a.keyUp(Keys.ENTER);
	}
     
     public static void Enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
     
     public static void Down() throws AWTException {
 		Robot r = new Robot();
 		r.keyPress(KeyEvent.VK_DOWN);
 		r.keyRelease(KeyEvent.VK_DOWN);
 	}
     
     public static void copy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
 		r.keyRelease(KeyEvent.VK_CONTROL);
 		r.keyRelease(KeyEvent.VK_C);
	}
     
     public static void paste() throws AWTException {
 		Robot r = new Robot();
 		r.keyPress(KeyEvent.VK_CONTROL);
 		r.keyPress(KeyEvent.VK_V);
  		r.keyRelease(KeyEvent.VK_CONTROL);
  		r.keyRelease(KeyEvent.VK_V);
 	}
     
     public static Alert alert() {
		Alert a = driver.switchTo().alert();
		return a;
	}
     
     public static void accept(Alert a) {
		a.accept();
	}
     
     public static void dismiss(Alert a) {
		a.dismiss();
	}
     
     public static void sendKeys(Alert a, String s) {
		a.sendKeys(s);
	}
     
     public static String getTextAlert(Alert a) {
		String text = a.getText();
		return text;
	}
     
     public static void selectByIndex(WebElement e,int i) {
		Select s = new Select(e);
		s.selectByIndex(i);
	}
     
     public static void selectByValue(WebElement e,String a) {
		Select s = new Select(e);
		s.selectByValue(a);
	}
     
     public static void selectByVisibleText(WebElement e, String a) {
		Select s = new Select(e);
		s.selectByVisibleText(a);
	}
     
     public static Boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}
     
     public static String getOptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		for(int i = 0;i<options.size();i++) {
			WebElement w = options.get(i);
			String text = w.getText();
			return text;
		}
		return null;
		
	}
     
     public static String getAllSelectedOptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for(WebElement x : allSelectedOptions) {
			String text = x.getText();
			return text;
		}
		return null;
		
	}
     
     public static String getFirstSelectedOptions(WebElement e) {
 		Select s = new Select(e);
 		WebElement firstSelectedOption = s.getFirstSelectedOption();
 			String text = firstSelectedOption.getText();
			return text;
 	}
     
     public static void deselectByIndex(WebElement e, int i) {
		Select s = new Select(e);
		s.deselectByIndex(i);
	}
     
     public static void deselectByValue(WebElement e, String a) {
		Select s = new Select(e);
		s.deselectByValue(a);
	}
     
     public static void deselectByVisibleText(WebElement e,String a) {
		Select s = new Select(e);
		s.deselectByVisibleText(a);
	}
     
     public static void deselectAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}
     
     public static void getScreenshotAs() throws IOException {
	    TakesScreenshot t = (TakesScreenshot)driver;
	    File src = t.getScreenshotAs(OutputType.FILE);
	    
	    long filename = System.currentTimeMillis();
	    
	    File dest = new File("C:\\Users\\Navin\\eclipse-workspace\\AAMavenPrograms\\Screenshots\\"+filename+".png");
	    FileUtils.copyFile(src, dest);
   }
     
     public static void executeScript(String a, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(a, e);
	}
     
     public static void frame(WebElement e) {
		driver.switchTo().frame(e);
	}
     
     public static void defaultContent() {
		driver.switchTo().defaultContent();
	}
     
     public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
     
     public static void window(String id) {
		driver.switchTo().window(id);
	}
     
     
     public static String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
   }
     
     public static void getWindowHandles(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>l = new ArrayList<String>();
		l.addAll(windowHandles);
		driver.switchTo().window(l.get(i));
	}
     
     public static void to(String url) {
		driver.navigate().to(url);
	}
     
     public static void back() {
		driver.navigate().back();
	}
     
     public static void forward() {
		driver.navigate().forward();
	}
     
     public static void refresh() {
		driver.navigate().refresh();
	}
     
     
     
     
     

}
