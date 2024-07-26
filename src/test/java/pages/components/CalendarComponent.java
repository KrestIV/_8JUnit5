package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement yearInput = $(".react-datepicker__year-select"),
                    monthInput = $(".react-datepicker__month-select");

    public void setDate(String day, String month, String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day--"
                + ((day.length() > 1)?"0":"00")
                + day
                + ":not(.react-datepicker__day--outside-month)").click();
    }
}