package publicMode;

import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class logins {
	public static  void login(WebDriver driver,String username,String password){
		
		
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/label[1]/span/input")).click();
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/label[1]/span/input")).clear();
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/label[1]/span/input")).sendKeys(username);
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/label[2]/span/input")).click();
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/label[2]/span/input")).clear();
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/label[2]/span/input")).sendKeys(password);
	
	
	driver.findElement(By.xpath(".//*[@id='login-box']/div/div/form/fieldset/div[2]/button")).click();
	}
	
	
	
}
