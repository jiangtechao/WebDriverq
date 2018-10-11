package xianshangdingdanModelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

public class pinglunguanliTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void kehuliebiaoo() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        driver.findElement(By.xpath(".//*[@id='oneLevel_0']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_0']/li[1]/a/span")).click();
        driver.findElement(By.linkText("评论管理")).click();
        Thread.sleep(4000);
        String title = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.5 - 评论列表", title);
    }

    @BeforeTest
    public void beforeTest() {

    }

    @AfterTest
    public void afterTest() {

    }
}