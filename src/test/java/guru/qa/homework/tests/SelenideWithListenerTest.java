package guru.qa.homework.tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.homework.helpers.TestData.BASE_URL;
import static guru.qa.homework.helpers.TestData.ISSUE_NAME;
import static guru.qa.homework.helpers.TestData.REPOSITORY_NAME;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issue")
@Story("Issue name")
@Owner("lesnik0909")
public class SelenideWithListenerTest extends BaseTest {

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Check issue name in github repository with listener")
  void checkIssueNameInGithub() {
    SelenideLogger.addListener("Allure", new AllureSelenide());

    open(BASE_URL);
    $(".header-search-input").setValue(REPOSITORY_NAME).submit();
    $(linkText(REPOSITORY_NAME)).click();
    $("[data-content='Issues']").click();
    $("#js-issues-search").setValue(ISSUE_NAME).submit();
    $("#issue_75_link").shouldHave(exactText(ISSUE_NAME));
  }

}
