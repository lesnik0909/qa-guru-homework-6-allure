package guru.qa.homework.steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.homework.helpers.TestData.BASE_URL;
import static org.openqa.selenium.By.linkText;

import io.qameta.allure.Step;

public class SelenideWithAnnotationSteps {

  @Step("Open main page")
  public SelenideWithAnnotationSteps openMainPage() {
    open(BASE_URL);
    return this;
  }

  @Step("Search repository '{repositoryName}'")
  public SelenideWithAnnotationSteps searchRepository(String repositoryName) {
    $(".header-search-input").setValue(repositoryName).submit();
    $(linkText(repositoryName)).click();
    return this;
  }

  @Step("Open issue tab")
  public SelenideWithAnnotationSteps openIssueTab() {
    $("[data-content='Issues']").click();
    return this;
  }

  @Step("Search issue '{issueName}'")
  public SelenideWithAnnotationSteps searchIssue(String issueName) {
    $("#js-issues-search").setValue(issueName).submit();
    return this;
  }

  @Step("Check issue name '{issueName}'")
  public SelenideWithAnnotationSteps checkIssueName(String issueName) {
    $("#issue_75_link").shouldHave(exactText(issueName));
    return this;
  }

}
