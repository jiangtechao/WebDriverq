package gbckTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import publicMode.logins;

import static org.testng.Assert.assertEquals;

public class shangpintianjiaTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void tianjiashangpin() throws InterruptedException {

        String username = "haikou";
        String password = "!2ikKxvrAh";
        logins.login(driver, username, password);
        Thread.sleep(3000);

        String title = driver.getTitle();
        assertEquals("隔壁仓库 V1.1.2 - 欢迎",title);



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

