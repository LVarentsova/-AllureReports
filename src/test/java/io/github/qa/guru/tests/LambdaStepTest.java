package io.github.qa.guru.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private final static String URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
             open(URL);
        });

        step("Find repository " + REPOSITORY, () -> {
             $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
             $(".repo-list").$(By.linkText(REPOSITORY)).click();
        });

        step("Открываем Issues", () -> {
             $("#issues-tab").click();
        });

        step("Проверяем наличие Issues с номером 68", () -> {
             $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
