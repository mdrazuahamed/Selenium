package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.time.Duration;

public class SellIntroduction {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Razu\\OneDrive\\Documents\\selenium_driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Razu\\OneDrive\\Documents\\selenium_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // waiting for object to exist on the page

        driver.get("https://hems-training-admin.alhaiatululya.org/login");
        driver.findElement(By.id("username")).sendKeys("dsi.admin");
        driver.findElement(By.name("password")).sendKeys("hems2022");
        driver.findElement(By.cssSelector("button#submit")).click();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
        //Thread.sleep(1000); //this thread will wait for 1000 millisecond
        System.out.println(driver.findElement(By.cssSelector("p.mb-0")).getText());
//        driver.findElement(By.linkText("পাসওয়ার্ড ভুলে গিয়েছেন?")).click();

        WebElement element = driver.findElement(By.cssSelector("a.fs--1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("razu");
        driver.findElement(By.cssSelector("button[id='submit'")).click();
        //driver.close();
    }
}
