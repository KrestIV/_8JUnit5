package data;

import com.github.javafaker.Faker;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestDataGenerationFaker {

    Faker faker = new Faker();

    Format dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String[] dateOfBirth = dateFormat.format(faker.date().birthday(18, 27)).split(" ");

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male","Female","Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = dateOfBirth[0],
            monthOfBirth = dateOfBirth[1],
            yearOfBirth = dateOfBirth[2],
            subject = faker.options().option("Math","Science","Biology","Commerce"),
            hobby = faker.options().option("Sports","Reading","Music"),
            picture = faker.options().option("profile0.png","profile1.png","profile2.png"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh","Haryana", "Rajasthan"),
            city = selectCityFromState(state);

    private String selectCityFromState(String value){
        String result = " ";
        if (value.equals( "NCR")) result = faker.options().option("Delhi","Gurgaon","Noida");
        if (value.equals("Uttar Pradesh")) result = faker.options().option("Agra","Lucknow","Merrut");
        if (value.equals("Haryana")) result = faker.options().option("Karnal","Panipat");
        if (value.equals("Rajasthan")) result = faker.options().option("Jaipur","Jaiselmer");
        return result;

    }
}
