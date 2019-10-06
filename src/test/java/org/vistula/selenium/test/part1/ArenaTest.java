package org.vistula.selenium.test.part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArenaTest {

    private WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void myFirstSeleniumTest() {
        driver = new ChromeDriver(); //uruchamia przegladarke na white screenie
        driver.get("http://demo.testarena.pl/zaloguj"); //przechodzi do strony
        Assertions.assertThat(driver.getTitle()).contains("TestArena"); //sprawdza czy tytul zawiera string
        driver.quit();
    }

    @Test
    public void myFirstInteractionTest() {
        driver = new ChromeDriver(); //uruchamia przegladarke na white screenie
        driver.get("http://demo.testarena.pl/zaloguj");  //przechodzi do strony
        WebElement email = driver.findElement(By.id("email")); //tworzy element o id email
        WebElement password = driver.findElement(By.id("password")); //tworzy element o id password
        WebElement login = driver.findElement(By.id("login")); //tworzy element o id login

        WebElement odzyskajhaslo = driver.findElement(By.className("a[href='http://demo.testarena.pl/odzyskaj_haslo']")); //tworzy element o href

        email.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        login.click();

        new WebDriverWait(driver, 3, 250) //czekanie maxymalnie 3 sekundy / odpytuje co 250 ms ale defaultowo co 500ms/ Najlepiej 100ms /
                .until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");
        driver.quit();
    }

    @Test
    public void recaptchaTest() {
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");
        WebElement login = driver.findElement(By.id("login"));
        login.click();

        new WebDriverWait(driver, 3, 250)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.className("login_form_error")));
        driver.quit();
    }

    @Test
    public void sendString() {
        driver = new ChromeDriver(); //uruchamia przegladarke na white screenie
        driver.get("http://google.pl"); //przechodzi do strony
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
        searchBox.sendKeys("Vistula University");
        searchBox.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 3, 250)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector("a[href='https://vistula.edu.pl/']")));
        driver.quit();
    }

}
