package xianshangdingdanModelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import publicMode.logins;

public   class peisongtaiTest {
    private static WebDriver driver;
    @Test
    public  void xiadan() throws InterruptedException {

        driver.findElement(By.xpath(".//*[@id='oneLevel_0']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_0']/li[2]/a/span")).click();
        driver.findElement(By.xpath(".//*[@id='/orderdelivery/list.do']/a")).click();
        Thread.sleep(4000);
        String DINGDAN = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.5 - 配送台",DINGDAN);

    }

    @BeforeSuite
    public void beforeTest() throws InterruptedException {
        String Url = "http://test-manage.depotnextdoor.com:7070/login";
        driver.get(Url);
        driver.manage().window().maximize();
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        Thread.sleep(4000);
    }

    @AfterSuite
    public void aftertest() throws InterruptedException {
        Thread.sleep(4000);
    }
}
