package tests;

import com.codeborne.selenide.Configuration;
import data.Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiTest {

    @BeforeAll
    static void configureBrowser(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @ParameterizedTest
    @DisplayName("Main paige should open in different languages")
    @EnumSource(Language.class)
    void WikiShouldSupportDifferentLanguages(Language language){
        open("https://" + language.searchString + ".wikipedia.org");
        $(language.cssSelector).shouldBe(visible);
    }

    @ParameterizedTest(name = "There should be results for {0} search")
    @ValueSource(strings = {
            "Churchill","Roosevelt", "Stalin"
    })
    void popularSearchedPagesShouldExist(String searchQuery){
        open("https://en.wikipedia.org/wiki/Main_Page");
        $("input.cdx-text-input__input").setValue(searchQuery).pressEnter();
        $("span.mw-page-title-main").should(exist);
    }
}
