package support;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import java.util.Locale;
import java.util.Random;

public class DataFactory {

    Faker faker = new Faker(new Locale("en-US"), new Random(200));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String streetName = faker.address().streetName();
    public String city = faker.address().cityName();
    public String state = faker.address().state();
    public String zipCode = faker.address().zipCode();
    public String phoneNumber = faker.phoneNumber().cellPhone();
    public String ssnNumber = faker.idNumber().ssnValid();
    public String userName = firstName + "_" + lastName;
    public String password = faker.internet().
            password(6, 14, true, true);


}
