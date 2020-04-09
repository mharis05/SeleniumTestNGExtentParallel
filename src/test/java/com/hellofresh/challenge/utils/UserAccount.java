package com.hellofresh.challenge.utils;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class UserAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer birthday;
    private Integer birthMonth;
    private Integer birthYear;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String other;
    private String phone;
    private String mobilePhone;
    private String alias;
    private LocalDate randomBirthday;

    private Faker faker = new Faker();

    /**
     * UserAccount Class
     * Generates fake data to help create unique
     * new Users for registration
     */
    public UserAccount() {

        generateRandomBirthday();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = firstName + lastName + "@gmail.com";
        this.password = "qwerty";
        this.birthday = randomBirthday.getDayOfMonth();
        this.birthMonth = randomBirthday.getMonthValue();
        this.birthYear = randomBirthday.getYear();
        this.company = faker.company().name();
        this.address1 = faker.address().streetAddress();
        this.address2 = faker.address().secondaryAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.postcode = faker.address().zipCode().substring(0,5);
        this.other = faker.lorem().sentence();
        this.phone = "+1" + faker.number().digits(10);
        this.mobilePhone = faker.numerify(faker.phoneNumber().cellPhone());
        this.alias = faker.name().username();

    }

    private void generateRandomBirthday(){
        LocalDate minDate = LocalDate.of(1900, 1, 1);
        LocalDate maxDate = LocalDate.of(2019, 1, 1);
        Date randomDate = faker.date().between(java.sql.Date.valueOf(minDate), java.sql.Date.valueOf(maxDate));
        randomBirthday = randomDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public Integer getBirthday() {
        return birthday;
    }


    public Integer getBirthMonth() {
        return birthMonth;
    }


    public Integer getBirthYear() {
        return birthYear;
    }


    public String getCompany() {
        return company;
    }


    public String getAddress1() {
        return address1;
    }


    public String getAddress2() {
        return address2;
    }


    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getPostcode() {
        return postcode;
    }


    public String getOther() {
        return other;
    }


    public String getPhone() {
        return phone;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }


    public String getAlias() {
        return alias;
    }


}
