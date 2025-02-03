package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {
    @Test
    public void fillOutTheForm () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.uitestingplayground.com/sampleapp");
        String username = "Anna";
        driver.findElement(By.name("UserName")).sendKeys(username);
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        WebElement loginText = driver.findElement(By.xpath("//*[@id=\"loginstatus\"]"));
        String actualRes = loginText.getText();
        String expRes = String.format("Welcome, %s!", username);
        Assert.assertEquals(expRes,actualRes);
        driver.quit();
    }
}
