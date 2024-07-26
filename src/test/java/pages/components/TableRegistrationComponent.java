package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableRegistrationComponent {

    private final SelenideElement tableHeader = $("div.modal-title h4");
    private final SelenideElement tableResult = $(".table-responsive");

    public void isHidden(){
        tableHeader.shouldNotBe(visible);
    }

    public void checkRow(String key, String value) {
        tableResult.$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
