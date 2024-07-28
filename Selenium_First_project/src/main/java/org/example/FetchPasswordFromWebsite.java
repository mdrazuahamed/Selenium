package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.Driver;
import java.time.Duration;

public class FetchPasswordFromWebsite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Razu\\OneDrive\\Documents\\selenium_driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Razu\\OneDrive\\Documents\\selenium_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Razu");
        driver.findElement(By.name("inputPassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(),"* Incorrect username or password");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("Razu Ahamed");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("en.razu.ahamed@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("01762700100");

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
        String password = trimPasswordFromString(driver.findElement(By.cssSelector("p.infoMsg")).getText());
        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Razu");
        driver.findElement(By.name("inputPassword")).sendKeys(password);

        driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
        driver.findElement(By.cssSelector("input#chkboxTwo")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public static String trimPasswordByWebDriver(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        String passwordSentence = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        String [] passwordArray = passwordSentence.split("'");
        String password = passwordArray[1].split("'")[0];
        System.out.println(password);
        return password;
    }

    public static String trimPasswordFromString(String passwordInSentence) {
        String [] passwordArray = passwordInSentence.split("'");
        String password = passwordArray[1].split("'")[0];
        System.out.println(password);
        return password;
    }
}
