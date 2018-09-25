package gbckTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

import java.security.Key;

public class pandianTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void pandian() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver,username,password);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(".//*[@id='oneLevel_2']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_2']/li[2]/a/span")).click();
                Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='/purchase/inventory/list.do']/a")).click();
                Thread.sleep(5000);
            String title = driver.getTitle();
            Assert.assertEquals("隔壁仓库 V1.1.2 - 商品盘点",title);
        driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/div/div[3]/div/div/div/div/h3/span/a")).click();
                Thread.sleep(6000);
            String create = driver.getTitle();
            Assert.assertEquals("隔壁仓库 V1.1.2 - 创建盘点单",create);
        driver.findElement(By.id("name")).sendKeys("selenium7");
        driver.findElement(By.xpath(".//*[@id='inventory-form']/div[4]/div/div[2]/label/span")).click();
                Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='product-selector-tag']/div[1]/div/div")).click();
                Thread.sleep(3000);
        WebElement bianhao = driver.findElement(By.xpath(".//*[@id='searchKey']"));
        Select sel = new Select(bianhao);
        sel.selectByValue("productCode");
        driver.findElement(By.xpath(".//*[@id='searchValue']")).sendKeys("1000005");
        driver.findElement(By.xpath(".//*[@id='search-btn']/span")).click();
                Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='product-table']/tbody/tr/td[1]/input")).click();
        driver.findElement(By.xpath(".//*[@id='product-selector-tag']/div[2]/div/div/div[4]/button[2]")).click();
                Thread.sleep(4000);
        driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
                Thread.sleep(4000);
        driver.findElement(By.linkText("已通过PDA完成盘点")).click();
                Thread.sleep(3000);
            String PDA = driver.getTitle();
            Assert.assertEquals("隔壁仓库 V1.1.2 - 盘点",PDA);
        WebElement input = driver.findElement(By.xpath(".//*[@id='code']"));
        input.sendKeys("1000005");
        input.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(".//*[@id='bcno']")).sendKeys("10");
        driver.findElement(By.xpath(".//*[@id='btnScan']")).click();
        driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
        driver.navigate().back();//浏览器后退
                Thread.sleep(4000);
        driver.findElement(By.linkText("完成盘点")).click();//完成盘点
                Thread.sleep(4000);
        driver.findElement(By.linkText("是")).click();
                Thread.sleep(4000);
        driver.findElement(By.linkText("差异确认")).click();
                Thread.sleep(3000);
        driver.findElement(By.name("items[0].diffReason")).sendKeys("10");
        driver.findElement(By.xpath(".//*[@id='submit-btn']")).click();
                Thread.sleep(3000);

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
