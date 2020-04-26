package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartOrderTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver","D://Study//CartOrder//driver//win//chromedriver.exe" );
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void cartOrderTest() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Жан-Жак Иванов");
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("+79270000000");
        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector(".button__text")).submit();
        String successText = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals( "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", successText);
    }

/*    @Test
    void cartOrderFailTest() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("");
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("+79270000000");
        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector(".button__text")).submit();
        String failText = driver.findElement(By.cssSelector(".input_invalid")).getText();
        assertEquals("Поле обязательно для заполнения", failText);
    }*/
}
