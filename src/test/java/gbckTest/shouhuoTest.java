package gbckTest;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import publicMode.logins;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.reporters.jq.BasePanel.D;

public class shouhuoTest {
	 WebDriver driver = new FirefoxDriver();
  @Test
  public void f() throws InterruptedException {
	  String username = "08988888888";
	  String password = "zqkg%iQ1GW";
	  logins.login(driver,username,password);
	 			 String title = driver.getTitle();
	  			 Assert.assertEquals("隔壁仓库 V1.1.2 - 欢迎",title);
	  Thread.sleep(2000);

	  //获得cookie
	  Set<Cookie> coo = driver.manage().getCookies();
	  System.out.println(coo);

	  driver.findElement(By.xpath(".//*[@id='oneLevel_0']/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='sub_one_0']/li[2]/a/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='/purchaseApply/approval/list.do']/a")).click();

	  WebDriverWait wait2 = new WebDriverWait(driver,10,1);
	  wait2.until(new ExpectedCondition<WebElement>(){
		  public WebElement apply(WebDriver text) { return text.findElement(By.linkText("审核"));
		  }
	  }).click();

	  Thread.sleep(2000);
				String title2 = driver.getTitle();
				Assert.assertEquals("隔壁仓库 V1.1.2 - 采购",title2);

	  WebDriverWait wait5 = new WebDriverWait(driver,10,1);
	  wait5.until(new ExpectedCondition<WebElement>(){
		  public WebElement apply(WebDriver text) { return text.findElement(By.xpath(".//*[@id='btn_save']"));
		  }
	  }).click();
	  Thread.sleep(5000);
	 driver.findElement(By.linkText("供货管理列表")).click();
	  			String title3 = driver.getTitle();
	  			Assert.assertEquals("隔壁仓库 V1.1.2 - 已确认的采购单",title3);

	  Thread.sleep(2000);
	  driver.findElement(By.linkText("上传")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='logo_file']")).sendKeys("D:\\图片\\index.jpeg");
	  	//隐式等待6S
	  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(".//*[@id='save_img']")).click();


	  driver.findElement(By.xpath(".//*[@id='financial_id']/label")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='layui-layer1']/div[3]/a[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("财务审核列表")).click();
	  WebDriverWait wait4 = new WebDriverWait(driver,10,1);
	  wait4.until(new ExpectedCondition<WebElement>(){
		  public WebElement apply(WebDriver text) { return text.findElement(By.linkText("通过"));
		  }
	  }).click();

	  driver.findElement(By.linkText("确认")).click();
	  driver.findElement(By.linkText("供货管理列表")).click();
	  Thread.sleep(2000);
	  			String title4 = driver.getTitle();
	  			Assert.assertEquals("隔壁仓库 V1.1.2 - 已确认的采购单",title4);
	  driver.findElement(By.linkText("推送订单")).click();
	  driver.findElement(By.xpath(".//*[@id='omsWarehouseCode']")).sendKeys("5182");
	  driver.findElement(By.linkText("确认")).click();
	  Thread.sleep(6000);
	  driver.navigate().refresh();

  }
  

private void aeesrtEquals(String title, String string) {
	// TODO Auto-generated method stub
	
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
