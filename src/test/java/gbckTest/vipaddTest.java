package gbckTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

import java.util.concurrent.TimeUnit;

public class vipaddTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void testsuit() throws InterruptedException {

        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 欢迎", title);
        driver.findElement(By.xpath(".//*[@id='oneLevel_1']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_1']/li[1]/a/span")).click();
        driver.findElement(By.xpath(".//*[@id='/member.do']/a")).click();//新增会员
        driver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys("18812345670");
        driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("jtc1");
        WebElement province = driver.findElement(By.xpath(".//*[@id='sel_provinceId']"));
        Select sel = new Select(province);//声明Select对象
        sel.selectByValue("21");//海南省
        WebElement city = driver.findElement(By.xpath(".//*[@id='sel_cityId']"));
        Select sel2 = new Select(city);
        sel2.selectByValue("125");//海口市
        Thread.sleep(2000);
        WebElement area = driver.findElement(By.xpath(".//*[@id='sel_districtId']"));
        Select sel3 = new Select(area);
        sel3.selectByValue("8006");
        driver.findElement(By.xpath(".//*[@id='deliveryAddress']")).sendKeys("海南省海口市琼山区A");
        driver.findElement(By.xpath(".//*[@id='sub_button']")).click();//保存
        Thread.sleep(3000);
        String title2 = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 会员列表", title2);

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
