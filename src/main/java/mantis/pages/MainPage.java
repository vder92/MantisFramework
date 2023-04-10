package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@href='bug_report_page.php']")
    private WebElement reportIssue;

    @FindBy(xpath = "//tbody//tr[1]/td[11]")
    private WebElement issueSummary;

    @FindBy(xpath = "//tbody//tr[1]/td[1]//label")
    private WebElement issueCheckBox;

    @FindBy(xpath = "//*[@name='action']")
    private WebElement actionList;

     @FindBy(xpath = "//*[@value='DELETE']")
    private WebElement deleteString;

    @FindBy(xpath = "//*[@value='OK']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@value='Delete Issues']")
    private WebElement confirmDeleteButton;

    public void getReportIssuePage(){
    reportIssue.click();
    }

    public String getSummary(){
        return issueSummary.getText();
    }

    public void chooseIssue(){
        issueCheckBox.click();
    }
    public void chooseDropDown(){
        actionList.click();
    }
    public void chooseDelete(){
        deleteString.click();
    }
    public void submitDelete(){
        submitButton.click();
    }
    public void confirmDelete(){
        confirmDeleteButton.click();
    }

}