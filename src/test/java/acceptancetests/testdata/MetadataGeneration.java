package acceptancetests.testdata;

import org.apache.commons.lang3.RandomStringUtils;

public class MetadataGeneration {

    //testdata
    public String emailText;
    public String firstName;
    public String lastName;
    public String password;
    public String phone;
    public String address;
    public String city;
    public String state;
    public String country;
    public String zipcode;
    public String constantEmail = "DarronKBlair@dayrep.com";
    public String constantPass = "Crowd123!";

    public MetadataGeneration() {
        emailText = RandomStringUtils.randomAlphanumeric(8) + "@rhyta.com";
        firstName = "USER";
        lastName = "Test";
        password = "Testentity123!";
        phone = RandomStringUtils.randomNumeric(10);
        address = "Crowd 1 st";
        city = "Portland";
        state = "Oregon";
        country = "United States of America";
        zipcode = "97203";
    }
}
