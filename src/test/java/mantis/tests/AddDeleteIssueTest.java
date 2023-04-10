package mantis.tests;

import mantis.pages.MainPage;
import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
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
    public MantisSite mantisSite;

    @Test
    public void addDeleteIssue() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        //проверка прохождения логина
        String loginPageUrl = mantisSite.getPageURL();
        assertEquals("https://academ-it.ru/mantisbt/my_view_page.php", loginPageUrl);

        //проверка открытия страницы report issue
        mantisSite.reportIssuePage();
        String issuePageUrl = mantisSite.getPageURL();
        assertEquals("https://academ-it.ru/mantisbt/bug_report_page.php", issuePageUrl);

        //заполнение формы issue
        String sumTest = "sum_test";
        mantisSite.fillSum("sum_test");
        //assertEquals(sumTest, mantisSite.getIssuePage().getSummary());

        String descTest = "desc_test";
        mantisSite.fillDesc("desc_test");
        //assertEquals(descTest, mantisSite.getIssuePage().getDescription());

        //Submit issue
        mantisSite.submitIssue();

        //ожидание загрузки страницы с Issues
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        SoftAssertions softAssert = new SoftAssertions();

        // проверка что баг есть в списке
        softAssert.assertThat(sumTest).isEqualTo(mantisSite.getMainPage().getSummary());

        //удаление бага
        mantisSite.chooseIssue(); //чек-бокс отмечен
        mantisSite.chooseDropDown(); //клик выпадающего списка
        mantisSite.chooseDelete(); //выбор опции Delete
        mantisSite.submitDelete();  //нажатие ОК после выбора Delete
        mantisSite.confirmDelete();  //нажатие кнопки Delete Issue

        //проверка что удаленного бага нет в списке
        softAssert.assertThat(sumTest).isNotEqualTo(mantisSite.getMainPage().getSummary());


    }

}