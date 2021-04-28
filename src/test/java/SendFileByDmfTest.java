package test.java;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SendFileByDmfTest {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test
    public void sendFileTest() throws InterruptedException {
        //Open https://dropmefiles.com
        driver.get("https://dropmefiles.com");
        //Upload any text file
        String f = "C:\\Java\\DropmeTask\\regexps.txt";
        driver.findElement(By.cssSelector(".moxie-shim-html5>input")).sendKeys(f);
        Thread.sleep(1000);
        //checking that the file is loaded
        WebElement downloaded = driver.findElement(By.className("bar"));
        String actual = downloaded.getAttribute("cssText");
        Assert.assertEquals(actual, "width: 100%");
        //Enter agrinpres@playershealth.com in the “TO” field
        driver.findElement(By.id("send_address")).sendKeys("agrinpres@playershealth.com");
        Thread.sleep(1000);
        //Enter name in the text area
        driver.findElement(By.className("comment_btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("comment")).sendKeys("Ramil");
        Thread.sleep(500);
        //Enter 9057244137@list.ru in the “FROM” field
        driver.findElement(By.id("send_from")).sendKeys("9057244137@list.ru");
        Thread.sleep(1000);
        //Print generated link
        System.out.println(driver.findElement(By.className("url")).getText());
        // Send the file
        driver.findElement(By.id("send_btn")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
