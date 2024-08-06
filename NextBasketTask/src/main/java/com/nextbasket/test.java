package com.nextbasket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;

public class test {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://teststoreforsouthafri.nextbasket.shop/checkout");
        driver.manage().window().maximize();
        // Locate the products

        // Wait for the dropdown options to appear
        WebDriverWait wait = new WebDriverWait(driver,30);
        List<WebElement> countryOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[id='headlessui-combobox-input-:r1q9:']")));

        // Iterate through the options to find "South Africa"
        for (WebElement option : countryOptions) {
            if (option.getText().contains("South Africa")) {
                option.click();
                break;
            }
        }

    }
}
