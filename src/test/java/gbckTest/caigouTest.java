package gbckTest;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;


import org.testng.asserts.Assertion;
import org.testng.mustache.Model;

import publicMode.Timeout;
import publicMode.logins;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;


public class caigouTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void test() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        Thread.sleep(5000);

        String title = driver.getTitle();
        assertEquals("隔壁仓库 V1.1.5 - 欢迎", title);

        //获得cookie
        Set<Cookie> coo = driver.manage().getCookies();
        System.out.println(coo);

        driver.findElement(By.xpath(".//*[@id='oneLevel_3']/span")).click();//采购
        driver.findElement(By.xpath(".//*[@id='sub_one_3']/li[1]/a/span")).click();
        driver.findElement(By.linkText("新建采购单")).click();
        Thread.sleep(4000);
        String title2 = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.5 - 新建采购单", title2);

        driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[4]/div/div/div/div/form/div/div/div[2]/div[2]/input")).sendKeys("1000077");
        driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[4]/div/div/div/div/form/div/div/div[3]/div/button")).click();

        driver.findElement(By.linkText("我的进货单")).click();
        Thread.sleep(4000);
        String jinhuo = driver.getTitle();
        assertEquals("隔壁仓库 V1.1.2 - 我的进货单", jinhuo);

        driver.findElement(By.xpath(".//*[@id='data-table']/tbody/tr/td[8]/input")).sendKeys("10");
        driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
        Thread.sleep(2000);
        String shenhe = driver.getTitle();
        assertEquals("隔壁仓库 V1.1.5 - 待审核的采购单", shenhe);

    }
    @BeforeTest

  public void beforeTest() {
        String Url = "http://test-manage.depotnextdoor.com:7070/login";
        driver.get(Url);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
}
}
