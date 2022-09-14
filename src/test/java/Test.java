import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Test {

    @org.testng.annotations.Test
    public void test(){
        System.setProperty("webdriver.chrome.driver","C:/dev/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://avic.ua/");
            Thread.sleep(1000); //засыпание на 10 сек, чтобы успел открыться браузер
            String title = driver.getTitle();
            Assert.assertEquals(title, "AVIC ™ - зручний інтернет-магазин побутової техніки та електроніки в Україні. | Avic");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }

    }
    @org.testng.annotations.Test
    void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/dev/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://avic.ua/");
        Thread.sleep(1000); //засыпание на 10 сек, чтобі успел открыться браузер
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'page-title']")).getText(), "Популярні товари" );
        driver.quit();
    }
    @org.testng.annotations.Test
    void test3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/dev/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://avic.ua/");
        Thread.sleep(1000); //засыпание на 10 сек, чтобі успел открыться браузер
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/main/section[1]/div/div/div[2]/div[3]/div[3]/div/div[5]")).isDisplayed());
        driver.quit();
    }
}
