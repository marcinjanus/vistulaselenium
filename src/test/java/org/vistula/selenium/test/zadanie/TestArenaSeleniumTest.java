package org.vistula.selenium.test.zadanie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestArenaSeleniumTest {
    protected WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.testarena.pl/zaloguj");
    }

    @After
    public void quit (){
        driver.quit();
    }
}