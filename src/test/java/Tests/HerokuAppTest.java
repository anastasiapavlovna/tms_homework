package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HerokuAppTest {

    @Test
    public void fillLoginAndPassword() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        String expectedRes = "Secure Area";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText();
        Assert.assertEquals(expectedRes, actualResult);
        driver.quit();
    }

}
