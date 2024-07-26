package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.RegistrationPage;
import data.TestDataGenerationFaker;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class HomeWorkPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    //TestDataGenerationFaker tData = new TestDataGenerationFaker();

    static Stream<Arguments> FilledTableShouldReturnAllFieldsFilledTest() {
        return Stream.of(
                Arguments.of(
                        new TestDataGenerationFaker()
                ),
                Arguments.of(
                        new TestDataGenerationFaker()
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    void FilledTableShouldReturnAllFieldsFilledTest(TestDataGenerationFaker tData) {
        registrationPage.openPage()
                .setFirstName(tData.firstName)
                .setLastName(tData.lastName)
                .setEmail(tData.email)
                .setGender(tData.gender)
                .setUserNumber(tData.phoneNumber)
                .setDateOfBirth(tData.dayOfBirth, tData.monthOfBirth, tData.yearOfBirth)
                .setSubject(tData.subject)
                .setHobby(tData.hobby)
                .uploadProfilePicture(tData.picture)
                .setAddress(tData.address)
                .setState(tData.state)
                .setCity(tData.city)
                .submit()

                .checkResult("Student Name", String.format("%s %s",tData.firstName,tData.lastName))
                .checkResult("Student Email", tData.email)
                .checkResult("Gender", tData.gender)
                .checkResult("Mobile", tData.phoneNumber)
                .checkResult("Date of Birth", String.format("%s %s,%s",tData.dayOfBirth,tData.monthOfBirth,tData.yearOfBirth))
                .checkResult("Subjects", tData.subject)
                .checkResult("Hobbies", tData.hobby)
                .checkResult("Picture", tData.picture)
                .checkResult("Address", tData.address)
                .checkResult("State and City", String.format("%s %s",tData.state,tData.city));
    }

    @ParameterizedTest
    @MethodSource("FilledTableShouldReturnAllFieldsFilledTest")
    void successfulMinimalRegistrationTest(TestDataGenerationFaker tData) {
        registrationPage.openPage()
                .setFirstName(tData.firstName)
                .setLastName(tData.lastName)
                .setGender(tData.gender)
                .setUserNumber(tData.phoneNumber)
                .submit()

                .checkResult("Student Name", String.format("%s %s",tData.firstName,tData.lastName))
                .checkResult("Gender", tData.gender)
                .checkResult("Mobile", tData.phoneNumber);
    }

    @ParameterizedTest
    @MethodSource("FilledTableShouldReturnAllFieldsFilledTest")
    void negativeFullRegistrationTest(TestDataGenerationFaker tData) {
        registrationPage.openPage()
                .setFirstName(tData.firstName)
                .setLastName(tData.lastName)
                .setEmail(tData.firstName)
                .setGender(tData.gender)
                .setUserNumber(tData.phoneNumber)
                .submit()

                .checkForError();
    }
}