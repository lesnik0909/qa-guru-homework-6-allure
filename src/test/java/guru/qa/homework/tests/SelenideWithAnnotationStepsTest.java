package guru.qa.homework.tests;

import static guru.qa.homework.helpers.TestData.ISSUE_NAME;
import static guru.qa.homework.helpers.TestData.REPOSITORY_NAME;

import guru.qa.homework.steps.SelenideWithAnnotationSteps;
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
public class SelenideWithAnnotationStepsTest extends BaseTest {

  SelenideWithAnnotationSteps steps = new SelenideWithAnnotationSteps();

  @Test
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Check issue name in github repository with annotation steps")
  void checkIssueNameInGithub() {
    steps
        .openMainPage()
        .searchRepository(REPOSITORY_NAME)
        .openIssueTab()
        .searchIssue(ISSUE_NAME)
        .checkIssueName(ISSUE_NAME);
  }

}
