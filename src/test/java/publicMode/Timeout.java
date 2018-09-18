package publicMode;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Timeout {
	private static WebDriver driver;
	

	public static void wait(String xpath) throws InterruptedException{
		
		//显式等待，针对某个元素等待点击
		WebDriverWait wait = new WebDriverWait(driver,10,1);
		  wait.until(new ExpectedCondition<WebElement>(){
			  public WebElement apply(WebDriver text) { return text.findElement(By.xpath("xpath"));
			  }
			  }).click();

      }
	
	
		
	
	//通过xpath获取元素清除文本并写入
	public void findElementByXpathAndClearSendkeys(By xpath, String text) {
		driver.findElements(xpath).clear();
		driver.findElement(xpath).sendKeys(text);
}
	public void findElementByXpathAndClearSendkeys(By xpath, int num) {
		driver.findElement(xpath).clear();
		driver.findElement(xpath).sendKeys(num+"");
		
		
}
	
	//判断元素是否存在
	public boolean exists(By selector) {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//设置查询组件等待时间
				try {
					driver.findElement(selector);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
				return true;
					} catch (Exception e) {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
				return false;
					}
}
	
	
	//判断是否有警告框
	public boolean judgeAlert(WebDriver driver) {
			try {
					driver.switchTo().alert();
						return true;
				} catch (Exception e) {
					output("没有发现警告框！");
					return false;
}
}
private void output(String string) {
	// TODO Auto-generated method stub
	
}
	
}