package gbckTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;
import	org.openqa.selenium.Keys;
public class shanghuaddTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void shanghuTest() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(".//*[@id='oneLevel_1']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_1']/li[2]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='/shops/toRegist']/a")).click();
        Thread.sleep(4000);
        String title = driver.getTitle();
                 Assert.assertEquals("隔壁仓库 V1.1.2 - page.user.edit", title);

        driver.findElement(By.xpath(".//*[@id='shopName']")).sendKeys("selenium1");//新增商户输入信息
        driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("jtc1");
        WebElement el = driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[1]/div[3]/span/select"));//商户类型选择
        Select sel = new Select(el);
        sel.selectByValue("3");//烧烤店
        driver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys("13311111111");
        WebElement PROVENCE = driver.findElement(By.xpath(".//*[@id='sel_provinceId']"));
        Select pro = new Select(PROVENCE);
        pro.selectByValue("21");//海南省
        Thread.sleep(2000);
        WebElement CITY = driver.findElement(By.xpath(".//*[@id='sel_cityId']"));
        Select ci = new Select(CITY);
        ci.selectByValue("121");//三亚市
        Thread.sleep(2000);
        WebElement SEARCH = driver.findElement(By.xpath(".//*[@id='sel_districtId']"));
        Select sea = new Select(SEARCH);
        sea.selectByValue("2360");//市区
        driver.findElement(By.xpath(".//*[@id='deliveryAddress']")).sendKeys("海滨小镇");
        driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[5]/div/div/div/ul")).click();
        WebElement pay = driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[5]/div/div/div/ul/li/input"));
        pay.click();
        pay.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath
                (".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[6]/div[1]/table/tbody/tr[2]/td[1]/div/a[2]")
        ).sendKeys("D:\\图片\\index.jpeg");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath
                (".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[6]/div[1]/table/tbody/tr[2]/td[2]/div/a[2]")
        ).sendKeys("D:\\图片\\index.jpeg");
        Thread.sleep(3000);
        driver.findElement(By.xpath
                (".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[6]/div[1]/table/tbody/tr[2]/td[3]/div/a[2]")
        ).sendKeys("D:\\图片\\index.jpeg");
        Thread.sleep(3000);
        driver.findElement(By.xpath
                (".//*[@id='main-container']/div[2]/div/div/div[4]/div[1]/div/div/div/div[6]/div[1]/table/tbody/tr[2]/td[4]/div/a[2]")
        ).sendKeys("D:\\图片\\index.jpeg");
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='businessLicenceName']")).sendKeys("123456");
        driver.findElement(By.xpath(".//*[@id='businessLicenceId']")).sendKeys("1234567");
        driver.findElement(By.xpath(".//*[@id='liquorSellLicenceId']")).sendKeys("12345678");
        driver.findElement(By.xpath(".//*[@id='corporateId']")).sendKeys("123456789");
        driver.findElement(By.xpath(".//*[@id='sub_save']")).click();
        Thread.sleep(4000);

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
