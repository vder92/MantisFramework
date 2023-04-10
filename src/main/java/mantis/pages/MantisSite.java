package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private IssuePage issuePage;

    public MantisSite(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        issuePage = new IssuePage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);
    }

//    public IssuePage getIssuePage() {
//        return issuePage;
//    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void reportIssuePage() {
        mainPage.getReportIssuePage();
    }

    public String getPageURL() {
        String anyPageUrl = driver.getCurrentUrl();
        return anyPageUrl;
    }

    public void fillSum(String summary) {
        issuePage.fillSum(summary);
    }

    public void fillDesc(String description) {
        issuePage.fillDesc(description);
    }

    public void submitIssue() {
        issuePage.submitIssue();
    }

    public void chooseIssue() {
        mainPage.chooseIssue();
    }
    public void chooseDropDown(){
        mainPage.chooseDropDown();
    }
    public void chooseDelete(){
        mainPage.chooseDelete();
    }

    public void submitDelete(){
        mainPage.submitDelete();
    }
    public void confirmDelete(){
        mainPage.confirmDelete();
    }
}
