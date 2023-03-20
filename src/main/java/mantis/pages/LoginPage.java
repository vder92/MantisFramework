package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#username")
    private WebElement loginfield;
    private void login(String login){
        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        loginfield.sendKeys(login);
        loginfield.sendKeys(Keys.ENTER);
    }
}
