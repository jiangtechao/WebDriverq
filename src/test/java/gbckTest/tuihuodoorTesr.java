package gbckTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

public class tuihuodoorTesr {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void tuihuo() throws InterruptedException {
        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver,username,password);
        Thread.sleep(5000);

        driver.findElement(By.xpath(".//*[@id='oneLevel_0']/span")).click();
        driver.findElement(By.xpath(".//*[@id='sub_one_0']/li[3]/a/span")).click();
        driver.findElement(By.xpath(".//*[@id='/order/posReturn/list.do?orderChannl=MANAGE']/a")).click();
            Thread.sleep(4000);//门店订单退货申请

        driver.findElement(By.linkText("申请退货")).click();
        Thread.sleep(3000);
        String shenqingtuihuo = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 申请退货",shenqingtuihuo);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='btn_applyReturn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("申请退货")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='sub_one_0']/li[3]/a/span")).click();
        driver.findElement(By.xpath(".//*[@id='/order/orderReturn/list.do?channelEnum=MANAGE']/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("审核")).click();
        Thread.sleep(3000);
        String list = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 退换货单列表",list);
        driver.findElement(By.xpath(".//*[@id='audit-pass']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='layui-layer2']/div[3]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='layui-layer4']/div[3]/a")).click();//审核通过
        Thread.sleep(4000);
        driver.findElement(By.xpath(".//*[@id='/order/orderReturn/inStockList.do?channelEnum=MANAGE']/a")).click();
        Thread.sleep(3000);
        String tuihuoruku = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 退货入库",tuihuoruku);
        driver.findElement(By.linkText("退货")).click();
        Thread.sleep(3000);
        String tuihuodan = driver.getTitle();
        Assert.assertEquals("隔壁仓库 V1.1.2 - 退货单",tuihuodan);
        driver.findElement(By.linkText("编辑")).click();
        Thread.sleep(2000);
        WebElement el = driver.findElement(By.xpath(".//*[@id='actualQuantity']"));
        el.clear();
        el.sendKeys("1");
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='expressName']")).sendKeys("中通快递");
        driver.findElement(By.xpath(".//*[@id='expressNo']")).sendKeys("2345");
        driver.findElement(By.xpath(".//*[@id='btn_confirm']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("layui-layer3")).click();//已通过pda完成出库

    }
    @BeforeTest
    public void beforeTest(){
        String Url = "http://test-manage.depotnextdoor.com:7070/login";
        driver.get(Url);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
}
