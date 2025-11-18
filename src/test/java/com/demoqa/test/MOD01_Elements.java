package com.demoqa.test;

import com.demoqa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MOD01_Elements extends BaseTest {

    public String pageName;

    @Test(groups = {"smoke"})
    public void PRECHECK_01_verifyPageTitle() {
        Assert.assertEquals(driver.getTitle(), "DEMOQA");
    }

    @Test(groups = {"healthCheck"})
    public void PRECHECK_02_verifyPageUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("demoqa.com"));
    }

    @Test(enabled = false)
    public void PRECHECK_03_verifyLogoIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("app")).isDisplayed());
    }

    @Test(groups = {"E2E", "Regression", "Elements"},enabled = false)
    public void MOD_01_TS_001_ValidateTextInputSubmission() throws InterruptedException {
        /*
         * 1. Navigate to Text Box page
         * 2. Enter "John Doe" in Full Name field
         * 3. Enter "test@example.com" in Email field
         * 4. Click Submit
         * 5. Verify output displays entered values
         * */
        pageName = "Elements";

        driver.findElement(By.xpath(String.format("//div[@class='card-body']/h5[text()='%s']", pageName))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(text(),'Please')]")));
    }
}
