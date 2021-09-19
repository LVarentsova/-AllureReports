package io.github.qa.guru.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testGithub() {
        open("https://github.com");

        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(".repo-list").$(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#68")).should(Condition.visible);
    }
}
