package caigouModelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

public class yiquxiaodecaigoudanTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void kehuliebiaoo() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='oneLevel_3']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_3']/li[1]/a/span")).click();
        driver.findElement(By.linkText("已取消的采购单")).click();
        Thread.sleep(4000);
        String title = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.5 - 已取消的采购单",title);
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
