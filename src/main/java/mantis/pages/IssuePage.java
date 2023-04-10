package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public IssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(xpath = "//*[@value='Submit Issue']")
    private WebElement submitIssueButton;

    public void fillSum(String summary){
        summaryField.sendKeys(summary);
    }

    public void fillDesc(String desc){
        descriptionField.sendKeys(desc);
    }

    public void submitIssue() {
        submitIssueButton.click();
    }
}
