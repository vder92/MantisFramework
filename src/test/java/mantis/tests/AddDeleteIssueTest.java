package mantis.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddDeleteIssueTest extends BaseTest {
    @Test
    public void login() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("username")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("password")).sendKeys("admin20");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        //проверка прохождения логина
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://academ-it.ru/mantisbt/my_view_page.php", currentUrl);
        //проверка открытия страницы report issue
        driver.findElement(By.xpath("//*[@href='bug_report_page.php']")).click();
        String pageIssueUrl = driver.getCurrentUrl();
        assertEquals("https://academ-it.ru/mantisbt/bug_report_page.php", pageIssueUrl);
        //заполнение формы issue
        driver.findElement(By.id("summary")).sendKeys("sum_test");
        driver.findElement(By.id("description")).sendKeys("desc_test");
        driver.findElement(By.xpath("//*[@value='Submit Issue']")).click();

        WebDriverWait waits = new WebDriverWait(driver, 50, 300);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // поиск добавленного бага
        WebElement summary = driver.findElement(By.xpath("//tbody//tr[1]/td[11]"));
        assertEquals("sum_test", summary.getText());

        driver.findElement(By.xpath("//tbody//tr[1]/td[1]//label")).click();
        driver.findElement(By.xpath("//input[@value='OK']")).sendKeys("Delete");
        Select dropDown = new Select(driver.findElement(By.xpath("//*[@name='action']")));

        dropDown.selectByVisibleText("Delete");
        driver.findElement(By.xpath("//*[@value='OK']")).click();
        driver.findElement(By.xpath("//input[@value='Delete Issues']")).click();
        WebElement nextBug = driver.findElement(By.xpath("//tbody//tr[1]/td[11]"));
        assertNotEquals("sum_test", nextBug.getText());
    }

}