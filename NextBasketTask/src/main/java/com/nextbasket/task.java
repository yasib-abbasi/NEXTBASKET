package com.nextbasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task {
    public static void main(String[] args) throws InterruptedException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.get("https://teststoreforsouthafri.nextbasket.shop/");
            driver.manage().window().maximize();
            // Locate the products

        // Assuming the HTML structure remains the same
        // Assuming the HTML structure remains the same
        WebDriverWait wait = new WebDriverWait(driver, 20);
        List<WebElement> productContainers = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".eYP2W")));

        for (WebElement product : productContainers) {
            List<WebElement> discountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".fLzVe.pmkBx.Sk7Kr._9IbkQ")));
            for (WebElement discountElement : discountElements) {
                if (discountElement.getText().trim().equals("-50 %")) {
                    // Product with 50% discount found
                    WebElement productTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='max-w-[1280px] m-auto px-4 sm:px-10']")));
                    String productTitle = productTitleElement.getText();
                    System.out.println("Discounted Product Title: " + productTitle);

                }

            }
        }
        // Searching an element
        driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("pai");

        WebElement addToBasketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button[aria-label='Add to basket Painting A']")));
        addToBasketButton.click();

        Thread.sleep(5000);

        //Add To Cart Button
        WebElement addCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button[aria-label='Open basket menu']")));
        addCartButton.click();
        Thread.sleep(5000);

        // Click the "Go to payment" button
        WebElement goToPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, '_2FTCz') and contains(@class, '-xvsH') and .//p[text()='Go to payment']]")));

        // Click the "Go to payment" button
        goToPaymentButton.click();

        //Enter Email
        WebElement emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email' and contains(@class, 'GuestForm_login__field__YKEO5')]")));

        // Clear any existing text in the email input field
        emailInputField.click();

        // Enter the new email address
        emailInputField.sendKeys("yasibabbasi@gmail.com");

        //Continue as guest button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//p[contains(text(),'Continue as guest')]")).click();


        //Checkout Form
        driver.findElement(By.xpath("//input[contains(@name,'shippingAddress.firstName')]")).sendKeys("Yasib Abbasi");
        driver.findElement(By.xpath("//input[@name='shippingAddress.lastName']")).sendKeys("yasib");
        driver.findElement(By.xpath("//input[@name='shippingAddress.phone']")).sendKeys("+923449416266");


        //WebElement selectedElement = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div/input"));
        //selectedElement.click();
        //selectedElement.clear();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"headlessui-combobox-input-:rf:\"]")).click();
        WebElement country = driver.findElement(By.xpath("//p[contains(text(),'South Africa')]"));
        country.click();
        //WebElement dropdownElement = driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]"));

        Thread.sleep(5000);
        WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("headlessui-combobox-button-:rj:")));

        // Click the dropdown to open it
        cityDropdown.click();

        // Find the input field within the dropdown and enter "Alberton"
        WebElement inputField = driver.findElement(By.id("headlessui-combobox-input-:rk:"));
        inputField.sendKeys("Alberton");

        // Wait for the oit
        // ptions to appear
        List<WebElement> cityOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));

        // Iterate through the options to find "Alberton"
        for (WebElement option : cityOptions) {
            if (option.getText().contains("Alberton")) {
                option.click();
                break;
            }
        }

    }

}