package gbckTest;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;
import org.openqa.selenium.Keys;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class sizeyouhuiquanTest {
    WebDriver driver = new FirefoxDriver();
    private Alert input;


    @Test
    public void tianjiashangpin() throws InterruptedException {

        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);

        String title = driver.getTitle();
        assertEquals("隔壁仓库 V1.1.2 - 欢迎",title);

        driver.findElement(xpath(".//*[@id='oneLevel_0']/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("促销管理")).click();
        Thread.sleep(2000);
        driver.findElement(xpath(".//*[@id='/manage/voucherType/list.do']/a")).click();//配置优惠券
        Thread.sleep(3000);

        driver.findElement(xpath(".//*[@id='main-container']/div[2]/div/div/div[3]/div/div/div/div/h3/div/a/span")).click();
        Thread.sleep(2000);
        String title2 = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 新建优惠券类型",title2);

        driver.findElement(By.id("name")).sendKeys("满5减3");
        driver.findElement(By.id("faceValue")).sendKeys("3");
        driver.findElement(By.id("paymentLimit")).sendKeys("5");
        Thread.sleep(2000);
        WebElement el = driver.findElement(By.id("typeStatus"));
        Select sel = new Select(el);
        sel.selectByValue("OVERLAB");//叠加

        driver.findElement(xpath(".//*[@id='datepickerIssue']")).click();
        Thread.sleep(2000);
        driver.findElement(xpath(".//*[@id='form']/div[9]/div/div/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[6]")).click();
        driver.findElement(xpath(".//*[@id='datepickerExpire']")).click();
        Thread.sleep(2000);
        driver.findElement(xpath(".//*[@id='form']/div[9]/div/div/div/ul/li[1]/div/div[1]/table/tbody/tr[6]/td[1]")).click();
        driver.findElement(xpath(".//*[@id='issueCount']")).sendKeys("100");
        driver.findElement(xpath(".//*[@id='minCountInPool']")).sendKeys("2");
        driver.findElement(xpath(".//*[@id='btn_save']")).click();
        Thread.sleep(4000);
        String title3 = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 配置优惠券",title3);

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
