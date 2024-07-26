package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableRegistrationComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput   = $("#lastName"),
            userEmailInput  = $("#userEmail"),
            genderWrapper   = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput   = $("#dateOfBirthInput"),
            subjectInput    = $("#subjectsInput"),
            hobbyInput      = $("#hobbiesWrapper"),
            pictureInput    = $("#uploadPicture"),
            addressInput    = $("#currentAddress"),
            stateInput      = $("#state"),
            stateSelector   = $("#stateCity-wrapper"),
            cityInput       = $("#city"),
            citySelector    = $("#stateCity-wrapper"),
            submitButton    = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableRegistrationComponent tableRegistrationComponent = new TableRegistrationComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value){
        hobbyInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadProfilePicture(String value){
        pictureInput.uploadFromClasspath("img/" + value);

        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value){
        stateInput.click();
        stateSelector.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.click();
        citySelector.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit(){
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableRegistrationComponent.checkRow(key, value);

        return this;
    }

    public RegistrationPage checkForError() {
        tableRegistrationComponent.isHidden();

        return this;
    }

}