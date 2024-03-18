//package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomeWork4Tests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void gitHubSoftAssertions(){
        open("/");
        //$(data-target="qbsearch-input.hotkeyIndicator").click();
        $(byText("Search or jump to...")).click();
        $(".QueryBuilder-InputWrapper #query-builder-test").setValue("selenide").pressEnter();
        $("div[data-testid='results-list']").$("div.search-title a").click();
        $("a#wiki-tab").click();
        $("input#wiki-pages-filter").setValue("SoftAssertions");
        $("li.wiki-more-pages a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("""
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
                @Test
                void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                }
            }""")).shouldBe(visible);


    }


}
