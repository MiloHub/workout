package com.naviance.sample.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSelenium2 {

	
	protected WebDriverWait wait;
	protected String url = "http://localhost:8080/naviance-code-challenge";
	public WebDriver getDriver() {
		
		 WebDriver driver = new FirefoxDriver();
		 wait = new WebDriverWait(driver, 10);
		return driver;
	}

	public void waitForElementPresent(final By locator) {
		this.wait.until((visibilityOfElementLocated(locator)));
	}

	private ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(by);
				if (!(element instanceof WebElement))
					return element;
				return ((WebElement) element).isDisplayed() ? element : null;
			}
		};
	}

	private WebElement waitForWebElementNotPresent(By locator) {
		return wait.until(invisibilityOfElementDetected(locator));
	}

	private ExpectedCondition<WebElement> invisibilityOfElementDetected(
			final By by) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(by);
				if (!(element instanceof WebElement))
					return element;
				return ((WebElement) element).isDisplayed() ? null : element;
			}
		};
	}
}
