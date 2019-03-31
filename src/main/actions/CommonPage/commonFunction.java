package CommonPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class commonFunction extends BasePage {
	public commonFunction(WebDriver driver) {
		super(driver);
	}

	private int timeouts = 20;

	public void openUrl(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void input(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public String getText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextByJS(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement userName = driver.findElement(By.xpath("//input[@id='name']"));
		executeClickByJS("//input[@id='name']");
		return jsExecutor.executeScript("return arguments[0].validationMessage;", userName).toString();

	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public void clearText(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	public String getPageSource() {
		return driver.getPageSource();

	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void wardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void selectCombobox(String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public String getTextComboboxSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public String getAtribute(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(locator);

	}

	public int getSizeList(String locator) {
		List<WebElement> ListOfWebElements = driver.findElements(By.xpath(locator));
		return ListOfWebElements.size();
	}

	public boolean isDisplayed(String locator) {
		return driver.findElement(By.xpath(locator)).isDisplayed();

	}

	public boolean isSelected(String locator) {
		return driver.findElement(By.xpath(locator)).isSelected();
	}

	public boolean isEnabled(String locator) {
		return driver.findElement(By.xpath(locator)).isEnabled();
	}

	public void acceptAlert(String locator) {
		driver.findElement(By.xpath(locator)).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void acceptAlert1() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(String locator) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(String locator) {
		driver.findElement(By.xpath(locator)).click();
		Alert alert = driver.switchTo().alert();
		driver.findElement(By.xpath(locator)).click();
		alert.accept();
		return alert.getText();
	}

	public String getTextAlert1() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert.getText();
	}

	public void inputAlert(String locator, String value) {
		driver.findElement(By.xpath(locator)).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}

	public void switchWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}

	}

	public String getWindow() {
		return driver.getWindowHandle();
	}

	public void switchToIframe(String locator) {
		WebElement iframeLookingfor = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframeLookingfor);

	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void hover(String locator) {
		WebElement hoverElement = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(hoverElement).perform();

	}

	public String hoverGettext(String locator) {
		WebElement hoverElement = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		return action.moveToElement(hoverElement).toString();

	}

	public void doubleClick(String locator) {
		WebElement btnDouble = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(btnDouble).perform();

	}

	public void rightClick(String locator) {
		WebElement rightBtn = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver).contextClick(rightBtn);
		action.build().perform();

	}

	public void dragAndDrop(String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();

	}

	public void dragAndDropFromElements(WebElement a, WebElement b) {

		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(a).moveToElement(b).release(b).build();
		dragAndDrop.perform();

	}

	public void clickAndHold(String locator, int itemFrom, int itemTarget) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();

	}

	public WebElement webElement(String locator) {
		return driver.findElement(By.xpath(locator));

	}

	public void inputKeys(String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);
	}

	

	public void uploadBySendKeys(String locator, String PathImage) {
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.sendKeys(PathImage);

	}

	public void uploadByRobot(String locator, String PathImage) throws AWTException, InterruptedException {
		StringSelection select = new StringSelection(PathImage);
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.click();
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void executeScriptBrowser(String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);
	}

	public void executeClickByJS(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		js.executeScript("arguments[0].click();", element);

	}

	public void scrollToBottomPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void highlight(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style='border: 2px solid; border-color: red'", element);
	}

	public void removeAttribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public void waitPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitInvisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForProgressBar(final String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});

	}

	public void waitfluent(String locator, final String End) {
		WebElement coutDown = driver.findElement(By.xpath(locator));
		new FluentWait<WebElement>(coutDown).withTimeout(60, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						boolean flag = element.getText().endsWith(End);
						return flag;
					}
				});
	}

	public void waitAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
