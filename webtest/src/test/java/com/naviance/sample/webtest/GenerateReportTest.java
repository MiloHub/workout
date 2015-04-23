package com.naviance.sample.webtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenerateReportTest extends BaseSelenium2 {
	WebDriver driver;

	@Before
	public void setUp() {
		driver = getDriver();

		if (System.getProperty("url") != null) {
			url = System.getProperty("url");
		}
		driver.get(url);
		driver.manage().window().setSize(new Dimension(1024, 768));
	}

	@Test
	public void testHomePage() {
		try {
			System.out.println(driver.getTitle());
			WebElement element = driver.findElement(By.id("home"));
			System.out.println("home -->" + element.getText());
			WebElement element1 = driver.findElement(By.id("rnd"));
			System.out.println(element1.getText());
		} finally {
			driver.close();
		}
	}

	@Test
	public void testRankandDecilePage() {
		try {
			driver.get(url);
			WebElement element = driver.findElement(By.id("rnd"));
			element.click();
			WebElement stdName = driver.findElement(By.id("add_std_name"));
			stdName.sendKeys("TOMMIE");
			WebElement gpa = driver.findElement(By.id("add_std_gpa"));
			gpa.sendKeys("2");
			WebElement addStudent = driver.findElement(By.id("addButton"));
			addStudent.submit();
		} finally {
			driver.close();
		}
	}

	@Test
	public void testRankandDecileGenerateReport() {
		try {
			WebElement element = driver.findElement(By.id("rnd"));
			element.click();
			Select select = new Select(driver.findElement(By.id("student")));
			select.selectByVisibleText("TOMMIE");
			WebElement generateRank = driver.findElement(By.id("generateRank"));
			generateRank.submit();
			waitForElementPresent(By.xpath("//*[@id=\"" + "body"
					+ "\"]/tr/td[3]"));
			WebElement gpa = driver.findElement(By.xpath("//*[@id=\"" + "body"
					+ "\"]/tr/td[3]"));
			System.out.println("gpa-->" + gpa.getText());
		} finally {
			driver.close();
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
