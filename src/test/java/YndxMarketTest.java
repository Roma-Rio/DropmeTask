package test.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class YndxMarketTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @Test
    public void yaTest() throws InterruptedException {
        driver.get("https://yandex.ru/");
        driver.findElement(By.xpath("//div[text()='Маркет']")).click();
        Set<String> wnd = driver.getWindowHandles();
        Iterator<String> i = wnd.iterator();
        i.next();
        String marketHandle = i.next();
        driver.switchTo().window(marketHandle);
        driver.findElement(By.xpath("//span[contains(text(), 'Электроника')]")).click();
        driver.findElement(By.xpath("//a[text()='Смартфоны и аксессуары']")).click();
        driver.findElement(By.xpath("//a[text()='Мобильные телефоны']")).click();
        driver.findElement(By.id("glpriceto")).sendKeys("20000");
        Thread.sleep(2000);
        driver.findElement(By.id("4925721from")).sendKeys("3");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Apple')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'HONOR')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='по цене']")).click();
        Thread.sleep(1000);
        List<WebElement> resultSortByPriceItems = driver.findElements(By.cssSelector("._3dCGE8Y9v3"));
        String firstItemString = resultSortByPriceItems.get(0).getText();
        System.out.println("First element after sorting: " + firstItemString);
        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@data-tid=\"23fad448\"]"));
        String firstItemPrice = itemPrices.get(0).getText();
        System.out.println("Price of first element in rubles: " + firstItemPrice);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}


