package xianshangdingdanModelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

public class xianshangdingdanTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void xiadan() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        Thread.sleep(4000);
        driver.findElement(By.xpath(".//*[@id='oneLevel_0']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_0']/li[2]/a/span")).click();
        driver.findElement(By.xpath(".//*[@id='/order/list.do?channelEnum=APP']/a")).click();
        Thread.sleep(4000);
        String DINGDAN = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.5 - 订单",DINGDAN);
        driver.findElement(By.linkText("搜索")).click();
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
