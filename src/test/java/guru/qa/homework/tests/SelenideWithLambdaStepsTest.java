package guru.qa.homework.tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.homework.helpers.TestData.BASE_URL;
import static guru.qa.homework.helpers.TestData.ISSUE_NAME;
import static guru.qa.homework.helpers.TestData.REPOSITORY_NAME;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issue")
@Story("Issue name")
@Owner("lesnik0909")
public class SelenideWithLambdaStepsTest extends BaseTest {

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Check issue name in github repository with labmda steps")
  void checkIssueNameInGithub() {
    step("Open main page", () -> {
      open(BASE_URL);
    });
    step("Search repository " + REPOSITORY_NAME, () -> {
      $(".header-search-input").setValue(REPOSITORY_NAME).submit();
      $(linkText(REPOSITORY_NAME)).click();
    });
    step("Open issue tab", () -> {
      $("[data-content='Issues']").click();
    });
    step("Search issue " + ISSUE_NAME, () -> {
      $("#js-issues-search").setValue(ISSUE_NAME).submit();
    });
    step("Check issue name " + ISSUE_NAME, () -> {
      $("#issue_75_link").shouldHave(exactText(ISSUE_NAME));
    });
  }

}
