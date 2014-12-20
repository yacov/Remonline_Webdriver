package com.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends com.selenium.pages.TestBase {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testRegistration() throws Exception {
		//Open page
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("//span")).click();
		driver.findElement(By.id("l-auth-email")).clear();
		driver.findElement(By.id("l-auth-email")).sendKeys("volf1212@gmail.com");
		driver.findElement(By.id("l-auth-login")).clear();
		driver.findElement(By.id("l-auth-login")).sendKeys("login13334");
		driver.findElement(By.id("l-auth-pass")).clear();
		driver.findElement(By.id("l-auth-pass")).sendKeys("password");
		driver.findElement(By.xpath("//div[5]/button")).click();
		try {
			assertEquals("Ваш аккаунт готов!\nПредставьтесь пожалуйста", driver.findElement(By.cssSelector("h2.h-ta-c")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("l-auth-name")).click();
		driver.findElement(By.id("l-auth-name")).clear();
		driver.findElement(By.id("l-auth-name")).sendKeys("Иван");
		driver.findElement(By.id("l-auth-lname")).click();
		driver.findElement(By.id("l-auth-lname")).clear();
		driver.findElement(By.id("l-auth-lname")).sendKeys("Иванов");
		driver.findElement(By.id("l-auth-company")).click();
		driver.findElement(By.id("l-auth-company")).clear();
		driver.findElement(By.id("l-auth-company")).sendKeys("ООО Зао");
		driver.findElement(By.xpath("//div[@id='Z99331457cb6f']")).click();
		driver.findElement(By.xpath("//ul[@class =\"clearfix\"]/li[3]/span")).click();
		driver.findElement(By.id("l-auth-city")).click();
		driver.findElement(By.id("l-auth-city")).clear();
		driver.findElement(By.id("l-auth-city")).sendKeys("Минск");
		driver.findElement(By.id("l-auth-phone")).click();
		driver.findElement(By.xpath("//button")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("span.text-label")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}